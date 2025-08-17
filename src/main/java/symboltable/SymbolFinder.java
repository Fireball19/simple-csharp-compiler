package symboltable;

import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;

/**
 * The symbol finder.
 * Finds declared variables and functions but not initialized variables.
 */
public class SymbolFinder extends DepthFirstAdapter {

  private final SymbolTable symbolTable;

  public SymbolFinder(SymbolTable symbolTable) {
    this.symbolTable = symbolTable;
  }

  @Override
  public void caseADeclarationVariable(ADeclarationVariable node) {
    String identifier = node.getIdentifier().getText();
    String type = node.getType().getClass().getSimpleName();

    String scope;

    if (node.parent().getClass().equals(AMainForm.class)) {
      scope = SymbolTable.MAIN_SCOPE;
    } else {
      scope = node.parent().toString().substring(0, node.parent().toString().indexOf(" "));
    }

    if (symbolTable.contains(scope, identifier)) {
      System.err.println("ERROR: Variable '" + identifier + "' declared more than once in the same scope.");
      System.exit(6);
    }

    symbolTable.putVariable(scope, identifier, Type.findType(type));
  }

  @Override
  public void caseAParameter(AParameter node) {
    String identifier = node.getIdentifier().getText();
    String type = node.getType().getClass().getSimpleName();

    String scope;

    if (node.parent().getClass().equals(AMainForm.class)) {
      scope = SymbolTable.MAIN_SCOPE;
    } else {
      scope = node.parent().toString().substring(0, node.parent().toString().indexOf(" "));
    }

    if (symbolTable.contains(scope, identifier)) {
      System.err.println("ERROR: Variable '" + identifier + "' declared more than once in the same scope.");
      System.exit(6);
    }

    symbolTable.addParameterType(scope, Type.findType(type));
    symbolTable.putInitializedVariable(scope, identifier, Type.findType(type));
  }

  @Override
  public void caseAMethod(AMethod node) {
    String identifier = node.getIdentifier().getText();
    String return_type = node.getReturnType().getClass().getSimpleName();

    if (symbolTable.containsMethod(identifier)) {
      System.err.println("ERROR: Function '" + identifier + "' declared more than once.");
      System.exit(6);
    }

    symbolTable.putMethod(identifier, Type.findType(return_type));

    for(Node n : node.getParameterDefinitions()) {
      n.apply(this);
    }

    for (Node n : node.getVariableDefinitions()) {
      n.apply(this);
    }
  }
}
