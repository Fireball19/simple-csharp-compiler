package codegenerator;

import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;
import symboltable.SymbolTable;
import symboltable.Type;

public class CodeGenerator extends DepthFirstAdapter {

  private final SymbolTable symbolTable;
  private final CastFinder castFinder;

  private final String className;
  private String code = "";
  private String tmpCode = "";
  private String currentScope = "";
  private int stackHeight = 2;
  private int maxLocals = 1;
  private int labelCounter = 0;
  private int cmpExpressionCounter = 0;
  private Type type;

  /**
   * Constructor for the code generator
   * @param symbolTable a precalculated table that contains all symbols
   */
  public CodeGenerator(String className, SymbolTable symbolTable, CastFinder castFinder) {
    this.symbolTable = symbolTable;
    this.castFinder = castFinder;
    this.className = className;
  }

  @Override
  public void caseAInitializationVariable(AInitializationVariable node) {
    node.getExpression().apply(this);

    String variableName = node.getIdentifier().toString().substring(0, node.getIdentifier().toString().lastIndexOf(" "));
    int variableIndex = symbolTable.getVariableIndex(this.currentScope, variableName);

    Type tmp = symbolTable.getType(this.currentScope, variableName);
    switch (tmp) {
      case INT:
      case BOOL:
        tmpCode += "\tistore "+ variableIndex + "\n";
        break;
      case DOUBLE:
        tmpCode += "\tdstore "+ variableIndex + "\n";
        maxLocals++;
        break;
      case STRING:
        tmpCode += "\tastore "+ variableIndex + "\n";
        break;
    }

    maxLocals++;
    stackHeight--;
    this.type = tmp;
  }

  @Override
  public void caseAVariableAssignmentStatement(AVariableAssignmentStatement node) {
    node.getExpression().apply(this);

    String variableName = node.getIdentifier().toString().substring(0, node.getIdentifier().toString().lastIndexOf(" "));
    int variableIndex = symbolTable.getVariableIndex(this.currentScope, variableName);

    Type tmp = symbolTable.getType(this.currentScope, variableName);
    switch (tmp) {
      case INT:
      case BOOL:
        tmpCode += "\tistore "+ variableIndex + "\n";
        break;
      case DOUBLE:
        tmpCode += "\tdstore "+ variableIndex + "\n";
        maxLocals++;
        break;
      case STRING:
        tmpCode += "\tastore "+ variableIndex + "\n";
        break;
    }

    maxLocals++;
    stackHeight--;
    this.type = tmp;
  }

  @Override
  public void outAIdentifierExpression(AIdentifierExpression node) {
    String variableName = node.getIdentifier().toString().substring(0, node.getIdentifier().toString().lastIndexOf(" "));
    int variableIndex = symbolTable.getVariableIndex(this.currentScope, variableName);

    Type tmp = symbolTable.getType(this.currentScope, variableName);
    switch (tmp) {
      case INT:
      case BOOL:
        tmpCode += "\tiload "+ variableIndex + "\n";
        break;
      case DOUBLE:
        tmpCode += "\tdload "+ variableIndex + "\n";
        stackHeight++;
        break;
      case STRING:
        tmpCode += "\taload "+ variableIndex + "\n";
        break;
    }

    if (tmp == Type.INT) {
      Node parent = node.parent();
      while (PExpression.class.isAssignableFrom(parent.getClass()) ||
          parent.parent().getClass().equals(AInitializationVariable.class) ||
          parent.parent().getClass().equals(AVariableAssignmentStatement.class)) {
        parent = parent.parent();
      }

      parent.apply(castFinder);
      if (castFinder.needsACast()) {
        tmpCode += "\ti2d\n";
        stackHeight += 2;
        tmp = Type.DOUBLE;
      }
    }

    stackHeight++;
    this.type = tmp;
  }

  @Override
  public void caseAFunctionExpression(AFunctionExpression node) {
    int counter = 0;
    for (Node n : node.getParameters()) {
      castFinder.setCurrentFunctionCall(node.getFunction().toString().substring(0, node.getFunction().toString().lastIndexOf(" ")));
      castFinder.setCurrentFunctionParameterIndex(counter);
      n.apply(this);
      counter++;
    }

    String functionName = node.getFunction().toString().substring(0, node.getFunction().toString().lastIndexOf(" "));

    StringBuilder parameters = new StringBuilder();
    for (int i = 0; i < symbolTable.getParameterSize(functionName); i++) {
      Type tmp = symbolTable.getParameterType(functionName, i);
      switch (tmp) {
        case INT:
          parameters.append("I");
          break;
        case DOUBLE:
          parameters.append("D");
          stackHeight++;
          break;
        case BOOL:
          parameters.append("Z");
          break;
        case STRING:
          parameters.append("Ljava/lang/String;");
          break;
      }
    }

    Type tmp2 = symbolTable.getType(SymbolTable.METHODS_SCOPE, functionName);
    String returnType = "";
    switch (tmp2) {
      case INT:
        returnType = "I";
        break;
      case DOUBLE:
        returnType = "D";
        break;
      case BOOL:
        returnType = "Z";
        break;
      case STRING:
        returnType = "Ljava/lang/String;";
        break;
      case VOID:
        returnType = "V";
        break;
    }

    stackHeight++;
    tmpCode += "\tinvokestatic " + className + "/" + functionName + "(" + parameters +")" + returnType + "\n";

    if (tmp2 == Type.INT) {
      Node parent = node.parent();
      while (PExpression.class.isAssignableFrom(parent.getClass()) ||
          parent.parent().getClass().equals(AInitializationVariable.class) ||
          parent.parent().getClass().equals(AVariableAssignmentStatement.class)) {
        parent = parent.parent();
      }

      parent.apply(castFinder);
      if (castFinder.needsACast()) {
        tmpCode += "\ti2d\n";
        stackHeight += 2;
        tmp2 = Type.DOUBLE;
      } else {
        tmp2 = Type.INT;
      }
    }

    this.type = tmp2;
  }

  @Override
  public void caseAWriteLineStatement(AWriteLineStatement node) {
    tmpCode += "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n";

    if (node.getExpression() == null) {
      this.type = Type.VOID;
    } else {
      node.getExpression().apply(this);
    }

    String tmp = "";
    switch (type) {
      case INT:
        tmp = "I";
        break;
      case DOUBLE:
        tmp = "D";
        stackHeight++;
        break;
      case BOOL:
        tmp = "Z";
        break;
      case STRING:
        tmp = "Ljava/lang/String;";
        break;
      case VOID:
        tmp = "";
        break;
    }

    tmpCode += "\tinvokevirtual java/io/PrintStream/println(" + tmp + ")V\n";
    stackHeight++;
  }

  @Override
  public void caseAIntLiteral(AIntLiteral node) {
    String number = node.getIntLiteral().toString().replace(" ", "");
    tmpCode += "\tldc " + number + "\n";

    Node parent = node.parent();
    while (PExpression.class.isAssignableFrom(parent.getClass()) ||
           parent.parent().getClass().equals(AInitializationVariable.class) ||
           parent.parent().getClass().equals(AVariableAssignmentStatement.class)) {
      parent = parent.parent();
    }

    parent.apply(castFinder);
    if (castFinder.needsACast()) {
      tmpCode += "\ti2d\n";
      stackHeight += 2;
      this.type = Type.DOUBLE;
    } else {
      this.type = Type.INT;
    }

    stackHeight++;
  }

  @Override
  public void caseADoubleLiteral(ADoubleLiteral node) {
    String number = node.getDoubleLiteral().toString().replace(" ", "");
    tmpCode += "\tldc2_w " + number + "d\n";
    stackHeight += 2;
    this.type = Type.DOUBLE;
  }

  @Override
  public void caseABoolLiteral(ABoolLiteral node) {
    String bool = node.getBoolLiteral().toString().replace(" ", "");

    switch (bool) {
      case "true":
        bool = "bipush 1";
        break;
      case "false":
        bool = "bipush 0";
        break;
    }

    tmpCode += "\t" + bool + "\n";
    stackHeight++;
    this.type = Type.BOOL;
  }

  @Override
  public void caseAStringLiteral(AStringLiteral node) {
    String string = node.getStringLiteral().toString().substring(0, node.getStringLiteral().toString().lastIndexOf(" "));
    tmpCode += "\tldc " + string + "\n";
    stackHeight++;
    this.type = Type.STRING;
  }

  @Override
  public void outAAddExpression(AAddExpression node) {
    if (type == Type.DOUBLE) {
      tmpCode += "\tdadd\n";
    } else {
      tmpCode += "\tiadd\n";
    }
    stackHeight--;
  }

  @Override
  public void outASubExpression(ASubExpression node) {
    if (type == Type.DOUBLE) {
      tmpCode += "\tdsub\n";
    } else {
      tmpCode += "\tisub\n";
    }
    stackHeight--;
  }

  @Override
  public void outAPlusExpression(APlusExpression node) {
    //   /\_/\
    //  ( o.o )
    //   > ^ <
    // Monday I have nothing to do
    // Tuesday I have nothing to do
    // ...
  }

  @Override
  public void outAMinusExpression(AMinusExpression node) {
    if (type == Type.DOUBLE) {
      tmpCode += "\tdneg\n";
    } else {
      tmpCode += "\tineg\n";
    }
  }

  @Override
  public void outAModExpression(AModExpression node) {
    if (type == Type.DOUBLE) {
      tmpCode += "\tdrem\n";
    } else {
      tmpCode += "\tirem\n";
    }
    stackHeight--;
  }

  @Override
  public void outAMultExpression(AMultExpression node) {
    if (type == Type.DOUBLE) {
      tmpCode += "\tdmul\n";
    } else {
      tmpCode += "\timul\n";
    }
    stackHeight--;
  }

  @Override
  public void outADivExpression(ADivExpression node) {
    if (type == Type.DOUBLE) {
      tmpCode += "\tddiv\n";
    } else {
      tmpCode += "\tidiv\n";
    }
    stackHeight--;
  }

  @Override
  public void outACmpSmallerExpression(ACmpSmallerExpression node) {
    int tmp;
    if (this.type == Type.INT || this.type == Type.BOOL) {
      tmpCode += "\tisub\n";
      stackHeight--;
    }
    tmp = cmpExpressionCounter;

    if (this.type == Type.DOUBLE) {
      tmpCode += "\tdcmpl\n";
    }
    tmpCode += "\tiflt LabelTrue" + (cmpExpressionCounter++) + "\n";
    stackHeight--;

    tmpCode += "\tbipush 0\n";
    stackHeight++;
    tmpCode += "\tgoto LabelCmpSmallerEnd" + tmp + "\n";
    tmpCode += "LabelTrue" + tmp + ":\n";
    tmpCode += "\tbipush 1\n";
    stackHeight++;
    tmpCode += "LabelCmpSmallerEnd" + tmp + ":\n";

    type = Type.BOOL;
  }

  @Override
  public void outACmpGreaterExpression(ACmpGreaterExpression node) {
    if (this.type == Type.INT || this.type == Type.BOOL) {
      tmpCode += "\tisub\n";
      stackHeight--;
    }

    int tmp = cmpExpressionCounter;

    if (this.type == Type.DOUBLE) {
      tmpCode += "\tdcmpg\n";
    }
    tmpCode += "\tifgt LabelTrue" + (cmpExpressionCounter++) + "\n";
    stackHeight--;

    tmpCode += "\tbipush 0\n";
    stackHeight++;
    tmpCode += "\tgoto LabelCmpGreaterEnd" + tmp + "\n";
    tmpCode += "LabelTrue" + tmp + ":\n";
    tmpCode += "\tbipush 1\n";
    stackHeight++;
    tmpCode += "LabelCmpGreaterEnd" + tmp + ":\n";

    type = Type.BOOL;
  }

  @Override
  public void outACmpEqualsSmallerExpression(ACmpEqualsSmallerExpression node) {
    if (this.type == Type.INT || this.type == Type.BOOL) {
      tmpCode += "\tisub\n";
      stackHeight--;
    }

    int tmp = cmpExpressionCounter;

    if (this.type == Type.DOUBLE) {
      tmpCode += "\tdcmpl\n";
    }
    tmpCode += "\tifle LabelTrue" + (cmpExpressionCounter++) + "\n";
    stackHeight--;

    tmpCode += "\tbipush 0\n";
    stackHeight++;
    tmpCode += "\tgoto LabelCmpEqualsSmallerEnd" + tmp + "\n";
    tmpCode += "LabelTrue" + tmp + ":\n";
    tmpCode += "\tbipush 1\n";
    stackHeight++;
    tmpCode += "LabelCmpEqualsSmallerEnd" + tmp + ":\n";

    type = Type.BOOL;
  }

  @Override
  public void outACmpEqualsGreaterExpression(ACmpEqualsGreaterExpression node) {
    if (this.type == Type.INT || this.type == Type.BOOL) {
      tmpCode += "\tisub\n";
      stackHeight--;
    }

    int tmp = cmpExpressionCounter;

    if (this.type == Type.DOUBLE) {
      tmpCode += "\tdcmpg\n";
    }
    tmpCode += "\tifge LabelTrue" + (cmpExpressionCounter++) + "\n";
    stackHeight--;

    tmpCode += "\tbipush 0\n";
    stackHeight++;
    tmpCode += "\tgoto LabelCmpEqualsGreaterEnd" + tmp + "\n";
    tmpCode += "LabelTrue" + tmp + ":\n";
    tmpCode += "\tbipush 1\n";
    stackHeight++;
    tmpCode += "LabelCmpEqualsGreaterEnd" + tmp + ":\n";

    type = Type.BOOL;
  }

  @Override
  public void outANotExpression(ANotExpression node) {
    int tmp = labelCounter++;
    tmpCode += "\tifeq LabelNotTrue" + tmp + "\n";
    tmpCode += "\tbipush 0\n";
    tmpCode += "\tgoto LabelNotEnd" + tmp + "\n";
    tmpCode += "LabelNotTrue" + tmp + ":\n";
    tmpCode += "\tbipush 1\n";
    tmpCode += "\tLabelNotEnd" + tmp + ":\n";
    type = Type.BOOL;
  }

  @Override
  public void outALogicalAndExpression(ALogicalAndExpression node) {
    tmpCode += "\tiand\n";
    stackHeight--;
    type = Type.BOOL;
  }

  @Override
  public void outALogicalOrExpression(ALogicalOrExpression node) {
    tmpCode += "\tior\n";
    stackHeight--;
    type = Type.BOOL;
  }

  @Override
  public void outACmpEqualsExpression(ACmpEqualsExpression node) {
    if (type == Type.STRING) {
      tmpCode += "\tinvokevirtual java/lang/String/equals(Ljava/lang/Object;)Z\n";
    } else {
      if (this.type == Type.INT || this.type == Type.BOOL) {
        tmpCode += "\tisub\n";
        stackHeight--;
      }

      int tmp = cmpExpressionCounter;

      if (this.type == Type.DOUBLE) {
        tmpCode += "\tdcmpl\n";
      }
      tmpCode += "\tifeq LabelTrue" + (cmpExpressionCounter++) + "\n";
      stackHeight--;

      tmpCode += "\tbipush 0\n";
      stackHeight++;
      tmpCode += "\tgoto LabelCmpEqualsEnd" + tmp + "\n";
      tmpCode += "LabelTrue" + tmp + ":\n";
      tmpCode += "\tbipush 1\n";
      stackHeight++;
      tmpCode += "LabelCmpEqualsEnd" + tmp + ":\n";
    }

    type = Type.BOOL;
  }

  @Override
  public void outACmpNotEqualsExpression(ACmpNotEqualsExpression node) {
    if (type == Type.STRING) {
      tmpCode += "\tinvokevirtual java/lang/String/equals(Ljava/lang/Object;)Z\n";
      // negate
      int tmp = labelCounter++;
      tmpCode += "\tifeq LabelNotTrue" + tmp + "\n";
      tmpCode += "\tbipush 0\n";
      tmpCode += "\tgoto LabelNotEnd" + tmp + "\n";
      tmpCode += "LabelNotTrue" + tmp + ":\n";
      tmpCode += "\tbipush 1\n";
      tmpCode += "\tLabelNotEnd" + tmp + ":\n";
    } else {
      if (this.type == Type.INT || this.type == Type.BOOL) {
        tmpCode += "\tisub\n";
        stackHeight--;
      }

      int tmp = cmpExpressionCounter;

      if (this.type == Type.DOUBLE) {
        tmpCode += "\tdcmpl\n";
      }
      tmpCode += "\tifne LabelTrue" + (cmpExpressionCounter++) + "\n";
      stackHeight--;

      tmpCode += "\tbipush 0\n";
      stackHeight++;
      tmpCode += "\tgoto LabelCmpNotEqualsEnd" + tmp + "\n";
      tmpCode += "LabelTrue" + tmp + ":\n";
      tmpCode += "\tbipush 1\n";
      stackHeight++;
      tmpCode += "LabelCmpNotEqualsEnd" + tmp + ":\n";
    }

    type = Type.BOOL;
  }

  @Override
  public void caseAReturnStatement(AReturnStatement node) {
    if (node.getExpression() == null) {
    } else {
      node.getExpression().apply(this);
    }

    this.type = symbolTable.getType("Methods", this.currentScope);

    String tmp = "";
    switch (type) {
      case INT:
      case BOOL:
        tmp = "\tireturn\n";
        break;
      case DOUBLE:
        tmp = "\tdreturn\n";
        break;
      case STRING:
        tmp = "\tareturn\n";
        break;
      case VOID:
        tmp += "\treturn\n";
        break;
    }

    tmpCode += tmp;
  }

  @Override
  public void caseAMainForm(AMainForm node) {
    this.currentScope = "Main";
    castFinder.setCurrentScope("Main");
    this.tmpCode = "";
    this.stackHeight = 2;
    this.maxLocals = 1;

    for (Node n : node.getVariableDefinitions()) {
      n.apply(this);
    }

    for (Node n : node.getStatements()) {
      n.apply(this);
    }

    methodCode("main", "[Ljava/lang/String;", "V");
  }

  @Override
  public void caseAMethod(AMethod node) {
    String functionName = node.getIdentifier().toString().substring(0, node.getIdentifier().toString().lastIndexOf(" "));
    this.currentScope = functionName;
    castFinder.setCurrentScope(functionName);
    this.tmpCode = "";
    this.stackHeight = 2;
    this.maxLocals = 1;

    for (Node n : node.getVariableDefinitions()) {
      n.apply(this);
    }

    for (Node n : node.getStatements()) {
      n.apply(this);
    }

    Type returnType = Type.findType(node.getReturnType().getClass().getSimpleName());
    String tmp = "";
    switch (returnType) {
      case INT:
        tmp = "I";
        break;
      case DOUBLE:
        tmp = "D";
        break;
      case BOOL:
        tmp = "Z";
        break;
      case STRING:
        tmp = "Ljava/lang/String;";
        break;
      case VOID:
        tmp = "V";
        break;
    }

    StringBuilder parameters = new StringBuilder();
    for (int i = 0; i < symbolTable.getParameterSize(functionName); i++) {
      Type tmp2 = symbolTable.getParameterType(functionName, i);
      switch (tmp2) {
        case INT:
          parameters.append("I");
          break;
        case DOUBLE:
          parameters.append("D");
          break;
        case BOOL:
          parameters.append("Z");
          break;
        case STRING:
          parameters.append("Ljava/lang/String;");
          break;
      }

      maxLocals++;
    }

    methodCode(node.getIdentifier().getText(), parameters.toString(), tmp);
  }

  @Override
  public void caseAWhileStatement(AWhileStatement node) {
    int tmp = labelCounter++;
    tmpCode += "LabelWhileUp" + tmp + ":\n";
    node.getExpression().apply(this);
    tmpCode += "\tifeq LabelWhileDown"+ tmp + "\n";
    stackHeight--;
    node.getStatement().apply(this);
    tmpCode += "\tgoto LabelWhileUp" + tmp + "\n";
    tmpCode += "LabelWhileDown" + tmp + ":\n";
  }

  @Override
  public void caseAIfStatement(AIfStatement node) {
    int tmp = labelCounter++;
    node.getExpression().apply(this);
    tmpCode += "\tifeq LabelIfDown" + tmp + "\n";
    stackHeight--;
    node.getStatement().apply(this);
    tmpCode += "LabelIfDown" + tmp + ":\n";
  }

  @Override
  public void caseAIfElseStatement(AIfElseStatement node) {
    int tmp = labelCounter++;
    node.getExpression().apply(this);
    tmpCode += "\tifeq LabelIfElse" + tmp + "\n";
    stackHeight--;
    node.getLeft().apply(this);
    tmpCode += "\tgoto LabelIfElseEnd" + tmp + "\n";
    tmpCode += "LabelIfElse" + tmp + ":\n";
    node.getRight().apply(this);
    tmpCode += "LabelIfElseEnd" + tmp + ":\n";
  }

  public String getCode() {
    return this.code;
  }

  public int getStackHeight() {
    return this.stackHeight;
  }

  public int getMaxLocals() {
    return this.maxLocals;
  }

  private void methodCode(String name, String parameter, String returnType) {
    code += ".method public static " + name + "(" + parameter + ")" + returnType + "\n" +
            "\t.limit stack " + this.getStackHeight() + "\n"+
            "\t.limit locals " + this.getMaxLocals() + "\n"+
            tmpCode +
            "\treturn\n" +
            ".end method\n";
  }
}