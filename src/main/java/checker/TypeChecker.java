package checker;

import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;
import symboltable.SymbolTable;
import symboltable.Type;

/**
 * The type checker.
 */
public class TypeChecker extends DepthFirstAdapter {

  private final SymbolTable symbolTable;
  private Type result;

  /**
   * Constructor for the type checker.
   * @param symbolTable a precalculated table that contains all symbols except initialized variables
   */
  public TypeChecker(SymbolTable symbolTable) {
    this.symbolTable = symbolTable;
  }

  @Override
  public void caseAInitializationVariable(AInitializationVariable node) {
    String identifier = node.getIdentifier().getText();
    Type type = Type.findType(node.getType().getClass().getSimpleName());

    String scope;

    if (node.parent().getClass().equals(AMainForm.class)) {
      scope = SymbolTable.MAIN_SCOPE;
    } else {
      scope = node.parent().toString().substring(0, node.parent().toString().indexOf(" "));
    }

    node.getExpression().apply(this);
    Type right = this.result;

    if (symbolTable.contains(scope, identifier)) {
      System.err.println("ERROR: Variable '" + identifier + "' declared more than once in the same scope.");
      System.exit(6);
    }

    // double type initializations, allows casting from int to double
    if (type == Type.DOUBLE && !checkCasting(right)) {
      System.err.println("ERROR: Variable '" + identifier + "' expected '" + type + "' " +
                         "or implicit casting of 'int' but found '" + right + "'.");
      System.exit(6);

    } else {
      // int, bool, string type initializations
      if ((type != Type.DOUBLE) && (right != type)) {
        System.err.println("ERROR: Variable '" + identifier + "' expected type '" + type + "' but found '" + right + "'.");
        System.exit(6);
      }
    }

    symbolTable.putInitializedVariable(scope, identifier, type);
  }

  @Override
  public void caseAVariableAssignmentStatement(AVariableAssignmentStatement node) {
    String identifier = node.getIdentifier().getText();

    Node parent = node;

    String function = "";
    // Find the parent function of the return statement
    while (!(parent.getClass().getSimpleName().equals("ANamespaceForm"))) {
      if (parent.getClass().getSimpleName().equals("AMainForm")) {
        function = SymbolTable.MAIN_SCOPE;
        break;
      }
      if (parent.getClass().getSimpleName().equals("AMethod")) {
        function = parent.toString().substring(0, parent.toString().indexOf(" "));
        break;
      }

      parent = parent.parent();
    }

    if(!symbolTable.contains(function, identifier)) {
      System.err.println("ERROR: Variable '" + identifier + "' does not exist in the function '" + function + "'.");
      System.exit(6);
    }

    Type type = symbolTable.getType(function, identifier);
    node.getExpression().apply(this);
    Type right = this.result;

    // double type assignments, allows casting from int to double
    if (type == Type.DOUBLE && !checkCasting(right)) {
      System.err.println("ERROR: Variable '" + identifier + "' expected '" + type + "' " +
                         "or implicit casting of 'int' but found '" + right + "'.");
      System.exit(6);

    } else {
      // int, bool, string type assignments
      if ((type != Type.DOUBLE) && (right != type)) {
        System.err.println("ERROR: Variable '" + identifier + "' expected type '" + type + "' but found '" + right + "'.");
        System.exit(6);
      }
    }

    symbolTable.initializeVariable(function, identifier);
  }

  @Override
  public void caseAIdentifierExpression(AIdentifierExpression node) {
    String identifier = node.getIdentifier().getText();
    Type tmp = null;

    Node parent = node;
    while (!(parent.getClass().getSimpleName().equals("ANamespaceForm"))) {
      // Check identifier in main scope
      if (parent.getClass().getSimpleName().equals("AMainForm")) {
        tmp = symbolTable.getType(SymbolTable.MAIN_SCOPE, identifier);

        if (!symbolTable.isVariableInitialized(SymbolTable.MAIN_SCOPE, identifier)) {
          System.err.println("ERROR: Variable '" + identifier + "' used but was not initialized in 'Main'.");
          System.exit(6);
        }
        break;
      }

      // Check identifier in the methods scope
      if (parent.getClass().getSimpleName().equals("AMethod")) {
        String function = parent.toString().substring(0, parent.toString().indexOf(" "));
        tmp = symbolTable.getType(function, identifier);

        if (!symbolTable.isVariableInitialized(function, identifier)) {
          System.err.println("ERROR: Variable '" + identifier + "' used but was not initialized in '" + function + "'.");
          System.exit(6);
        }
        break;
      }

      // Check if identifier is a method
      if (parent.getClass().getSimpleName().equals("AClassCForm")) {
        tmp = symbolTable.getType(SymbolTable.METHODS_SCOPE, identifier);
        break;
      }

      parent = parent.parent();
    }

    this.result = tmp;
  }

  @Override
  public void caseAFunctionExpression(AFunctionExpression node) {
    String identifier = node.getFunction().toString().replaceAll(" ", "");
    if (!symbolTable.containsMethod(identifier)) {
      System.err.println("ERROR: Function '" + identifier + "' used but was not declared.");
      System.exit(6);
    }

    // Check parameter count
    if (node.getParameters().size() > symbolTable.getParameterSize(identifier)
        || node.getParameters().size() < symbolTable.getParameterSize(identifier)) {
      System.err.println("ERROR: Wrong parameter count for function '" + identifier
                        + "' expected '" + symbolTable.getParameterSize(identifier)
                        + "' but found '" + (node.getParameters().size()) + "'.");
      System.exit(6);
    }

    // Check parameter type
    int paramCounter = 0;
    for (Node n : node.getParameters()) {
      n.apply(this);
      Type type = this.result;
      Type paramType = symbolTable.getParameterType(identifier, paramCounter);

      // double type parameters, allows casting from int to double
      if (paramType == Type.DOUBLE && !checkCasting(type)) {
        System.err.println("ERROR: Wrong type for parameter expected '"
                           + paramType + "' or implicit casting of 'int' but found '" + type + "'.");
        System.exit(6);

      } else {
        // int, bool, string type parameters
        if ((paramType != Type.DOUBLE) && (type != paramType)) {
          System.err.println("ERROR: Wrong type for parameter expected '" + paramType + "' but found '" + type + "'.");
          System.exit(6);
        }
      }

      paramCounter++;
    }

    // set result to function return type
    this.result = symbolTable.getType(SymbolTable.METHODS_SCOPE, identifier);
  }

  @Override
  public void caseAAddExpression(AAddExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (checkArithmetic(left, right)) {
      printErrorArithmetic("+", left, right);
      System.exit(6);
    }

    // implicit casting of int to double
    if (left == Type.DOUBLE && right == Type.INT || left == Type.INT && right == Type.DOUBLE) {
      this.result = Type.DOUBLE;
    }
  }

  @Override
  public void caseASubExpression(ASubExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (checkArithmetic(left, right)) {
      printErrorArithmetic("+", left, right);
      System.exit(6);
    }

    // implicit casting of int to double
    if (left == Type.DOUBLE && right == Type.INT || left == Type.INT && right == Type.DOUBLE) {
      this.result = Type.DOUBLE;
    }
  }

  @Override
  public void caseAPlusExpression(APlusExpression node) {
    node.getExpression().apply(this);
    Type type = this.result;

    if(checkArithmeticUnary(type)) {
      printErrorArithmeticUnary("+", type);
      System.exit(6);
    }
  }

  @Override
  public void caseAMinusExpression(AMinusExpression node) {
    node.getExpression().apply(this);
    Type type = this.result;

    if(checkArithmeticUnary(type)) {
      printErrorArithmeticUnary("-", type);
      System.exit(6);
    }
  }

  @Override
  public void caseAModExpression(AModExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (checkArithmetic(left, right)) {
      printErrorArithmetic("%", left, right);
      System.exit(6);
    }

    // implicit casting of int to double
    if (left == Type.DOUBLE && right == Type.INT || left == Type.INT && right == Type.DOUBLE) {
      this.result = Type.DOUBLE;
    }
  }

  @Override
  public void caseAMultExpression(AMultExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (checkArithmetic(left, right)) {
      printErrorArithmetic("*", left, right);
      System.exit(6);
    }

    // implicit casting of int to double
    if (left == Type.DOUBLE && right == Type.INT || left == Type.INT && right == Type.DOUBLE) {
      this.result = Type.DOUBLE;
    }
  }

  @Override
  public void caseADivExpression(ADivExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (checkArithmetic(left, right)) {
      printErrorArithmetic("/", left, right);
      System.exit(6);
    }

    // implicit casting of int to double
    if (left == Type.DOUBLE && right == Type.INT || left == Type.INT && right == Type.DOUBLE) {
      this.result = Type.DOUBLE;
    }
  }

  @Override
  public void caseACmpSmallerExpression(ACmpSmallerExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (checkArithmetic(left, right)) {
      printErrorArithmetic("<", left, right);
      System.exit(6);
    }

    this.result = Type.BOOL;
  }

  @Override
  public void caseACmpGreaterExpression(ACmpGreaterExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (checkArithmetic(left, right)) {
      printErrorArithmetic(">", left, right);
      System.exit(6);
    }

    this.result = Type.BOOL;
  }

  @Override
  public void caseACmpEqualsSmallerExpression(ACmpEqualsSmallerExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (checkArithmetic(left, right)) {
      printErrorArithmetic("<=", left, right);
      System.exit(6);
    }

    this.result = Type.BOOL;
  }

  @Override
  public void caseACmpEqualsGreaterExpression(ACmpEqualsGreaterExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (checkArithmetic(left, right)) {
      printErrorArithmetic(">=", left, right);
      System.exit(6);
    }

    this.result = Type.BOOL;
  }

  @Override
  public void caseANotExpression(ANotExpression node) {
    node.getExpression().apply(this);
    Type type = this.result;

    if(checkLogicalUnary(type)) {
      printErrorLogicalUnary("!", type);
      System.exit(6);
    }
  }

  @Override
  public void caseALogicalAndExpression(ALogicalAndExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (checkLogical(left, right)) {
      printErrorLogical("&&", left, right);
      System.exit(6);
    }
  }

  @Override
  public void caseALogicalOrExpression(ALogicalOrExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (checkLogical(left, right)) {
      printErrorLogical("||", left, right);
      System.exit(6);
    }
  }

  @Override
  public void caseACmpEqualsExpression(ACmpEqualsExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (left == Type.INT || left == Type.DOUBLE && right == Type.INT || right == Type.DOUBLE) {
    } else {
      if (checkComparison(left, right)) {
        printErrorComparison("==", left, right);
        System.exit(6);
      }
    }

    this.result = Type.BOOL;
  }

  @Override
  public void caseACmpNotEqualsExpression(ACmpNotEqualsExpression node) {
    node.getLeft().apply(this);
    Type left = this.result;
    node.getRight().apply(this);
    Type right = this.result;

    if (left == Type.INT || left == Type.DOUBLE && right == Type.INT || right == Type.DOUBLE) {
    } else {
      if (checkComparison(left, right)) {
        printErrorComparison("==", left, right);
        System.exit(6);
      }
    }

    this.result = Type.BOOL;
  }

  @Override
  public void caseAIfStatement(AIfStatement node) {
    Type type = Type.BOOL;
    node.getExpression().apply(this);
    Type expression = this.result;

    if (expression != type) {
      System.err.println("ERROR: 'if' statement requires a 'bool' expression but found '" + expression + "'.");
      System.exit(6);
    }

    node.getStatement().apply(this);
  }

  @Override
  public void caseAIfElseStatement(AIfElseStatement node) {
    Type type = Type.BOOL;
    node.getExpression().apply(this);
    Type expression = this.result;

    if (expression != type) {
      System.err.println("ERROR: 'if else' statement requires a 'bool' expression but found '" + expression + "'.");
      System.exit(6);
    }

    node.getLeft().apply(this);
    node.getRight().apply(this);
  }

  @Override
  public void caseAWhileStatement(AWhileStatement node) {
    Type type = Type.BOOL;
    node.getExpression().apply(this);
    Type expression = this.result;

    if (expression != type) {
      System.err.println("ERROR: 'while' statement requires a 'bool' expression but found '" + expression + "'.");
      System.exit(6);
    }

    node.getStatement().apply(this);
  }

  @Override
  public void caseAReturnStatement(AReturnStatement node) {
    Node parent = node;

    String function = "";
    // Find the parent function of the return statement
    while (!(parent.getClass().getSimpleName().equals("ANamespaceForm"))) {
      if (parent.getClass().getSimpleName().equals("AMainForm")) {
        function = "main";
        break;
      }

      if (parent.getClass().getSimpleName().equals("AMethod")) {
        function = parent.toString().substring(0, parent.toString().indexOf(" "));
        break;
      }

      parent = parent.parent();
    }

    Type function_type;

    if (function.equals("main")) {
      function_type = Type.VOID;
    } else {
      function_type = symbolTable.getType(SymbolTable.METHODS_SCOPE, function);
    }

    // void return type methods
    if (node.getExpression() == null && (function_type != Type.VOID)) {
      System.err.println("ERROR: Wrong type for 'return' expected '"
                         + function_type + "' but found 'void' in function '" + function + "'.");
      System.exit(6);
    }

    // other return type methods
    if (node.getExpression() != null) {
      node.getExpression().apply(this);
      Type type = this.result;

      // double return type methods, allows casting from int to double
      if (function_type == Type.DOUBLE && !checkCasting(type)) {
        System.err.println("ERROR: Wrong type for 'return' expected '"
            + function_type + "' or implicit casting of 'int' but found '" + type + "' in function '" + function + "'.");
        System.exit(6);

      } else {
        // int, bool, string return type methods
        if ((function_type != Type.DOUBLE) && (type != function_type)) {
          System.err.println("ERROR: Wrong type for 'return' expected '"
              + function_type + "' but found '" + type + "' in function '" + function + "'.");
          System.exit(6);
        }
      }
    }
  }

  @Override
  public void caseAIntLiteral(AIntLiteral node) {
    this.result = Type.INT;
  }

  @Override
  public void caseADoubleLiteral(ADoubleLiteral node) {
    this.result = Type.DOUBLE;
  }

  @Override
  public void caseAStringLiteral(AStringLiteral node) {
    this.result = Type.STRING;
  }

  @Override
  public void caseABoolLiteral(ABoolLiteral node) {
    this.result = Type.BOOL;
  }

  // for implicit type casting between int and double in return, function parameters and variable initializations
  private boolean checkCasting(Type type) {
    if (type == Type.DOUBLE) return true;
    if (type == Type.INT) return true;
    return false;
  }

  // for implicit type casting between int and double in arithmetic expressions
  private boolean checkArithmetic(Type left, Type right) {
    return !((left == Type.INT || left == Type.DOUBLE) && (right == Type.INT || right == Type.DOUBLE));
  }

  // for implicit type casting between int and double in unary expressions
  private boolean checkArithmeticUnary(Type type) {
    return !((type == Type.INT || type == Type.DOUBLE));
  }

  private boolean checkLogicalUnary(Type type) {
    return !(type == Type.BOOL);
  }

  private boolean checkLogical(Type left, Type right) {
    return !((left == Type.BOOL) && (right == Type.BOOL));
  }

  private boolean checkComparison(Type left, Type right) {
    return !(left == right);
  }

  private void printErrorArithmetic(String operator, Type left, Type right) {
    System.err.println("ERROR: Operator '" + operator + "' only allows 'int' or 'double' but found: '" + left + "' and '" + right + "'.");
  }

  private void printErrorLogical(String operator, Type left, Type right) {
    System.err.println("ERROR: Operator '" + operator + "' only allows 'bool' but found: '" + left + "' and '" + right + "'.");
  }

  private void printErrorArithmeticUnary(String operator, Type type) {
    System.err.println("ERROR: Unary operator '" + operator + "' only allows 'int' or 'double' but found: '" + type + "'.");
  }

  private void printErrorLogicalUnary(String operator, Type type) {
    System.err.println("ERROR: Unary operator '" + operator + "' only allows 'bool' but found: '" + type + "'.");
  }

  private void printErrorComparison(String operator, Type left, Type right) {
    System.err.println("ERROR: Operator '" + operator + "' only allows the same types or implicit casting from int to double " +
                       "but found: '" + left + "' and '" + right + "'.");
  }
}
