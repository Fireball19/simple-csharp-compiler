package checker;

import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;
import symboltable.SymbolTable;
import symboltable.Type;

/**
 * The return checker.
 * Checks if returns are possibly unreachable or missing.
 */
public class ReturnChecker extends DepthFirstAdapter {

  private final SymbolTable symbolTable;
  private String result = "";
  private boolean hasNotNestedReturn = false;

  /**
   * Constructor for the return checker.
   * @param symbolTable a precalculated table that contains all symbols except initialized variables
   */
  public ReturnChecker(SymbolTable symbolTable) {
    this.symbolTable = symbolTable;
  }

  @Override
  public void caseAMethod(AMethod node) {
    this.result = "";
    this.hasNotNestedReturn = false;

    String function = node.toString().substring(0, node.toString().indexOf(" "));
    Type function_type = symbolTable.getType(SymbolTable.METHODS_SCOPE, function);

    for (Node n : node.getStatements()) {
      n.apply(this);
    }

    if (!result.contains("return") && (function_type != Type.VOID) && (!hasNotNestedReturn)) {
      System.err.println("ERROR: Missing 'return' or possibly unreachable in function '"
                          + node.getIdentifier().getText() + "'.");
      System.exit(5);
    }
  }

  @Override
  public void caseAIfStatement(AIfStatement node) {
    node.getStatement().apply(this);

    this.result = "";
  }

  @Override
  public void caseAIfElseStatement(AIfElseStatement node) {
    node.getRight().apply(this);
  }

  @Override
  public void caseAWhileStatement(AWhileStatement node) {
    node.getStatement().apply(this);

    this.result = "";
  }

  @Override
  public void caseABlockStatement(ABlockStatement node) {
    for (Node n : node.getStatement()) {
      n.apply(this);
    }
  }

  @Override
  public void caseAReturnStatement(AReturnStatement node) {
    // check if return is not in a nested statement
    if (node.parent().getClass().getSimpleName().equals("AMethod")) {
      this.hasNotNestedReturn = true;
    }

    this.result = "return";
  }
}
