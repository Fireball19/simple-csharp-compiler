package codegenerator;

import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;
import symboltable.SymbolTable;
import symboltable.Type;

public class CastFinder extends DepthFirstAdapter {

  private final SymbolTable symbolTable;
  private boolean needsCast;
  private String currentScope = "";
  private String currentFunctionCall = "";
  private int currentFunctionParameterIndex = 0;
  private Type type = Type.INT;

  public CastFinder(SymbolTable symbolTable) {
    this.symbolTable = symbolTable;
  }

  @Override
  public void caseADoubleLiteral(ADoubleLiteral node) {
    this.type = Type.DOUBLE;
  }

  @Override
  public void caseAIdentifierExpression(AIdentifierExpression node) {
    String identifier = node.getIdentifier().toString().substring(0, node.getIdentifier().toString().lastIndexOf(" "));

    Type variableType = symbolTable.getType(this.currentScope, identifier);
    if (variableType == Type.DOUBLE) {
      this.type = Type.DOUBLE;
    }
  }

  @Override
  public void caseAInitializationVariable(AInitializationVariable node) {
    String identifier = node.getIdentifier().toString().substring(0, node.getIdentifier().toString().lastIndexOf(" "));

    node.getExpression().apply(this);

    Type variableType = symbolTable.getType(this.currentScope, identifier);
    if (variableType == Type.DOUBLE) {
      this.type = Type.DOUBLE;
    }
  }

  @Override
  public void caseAVariableAssignmentStatement(AVariableAssignmentStatement node) {
    String identifier = node.getIdentifier().toString().substring(0, node.getIdentifier().toString().lastIndexOf(" "));

    node.getExpression().apply(this);

    Type variableType = symbolTable.getType(this.currentScope, identifier);
    if (variableType == Type.DOUBLE) {
      this.type = Type.DOUBLE;
    }
  }

  @Override
  public void caseAFunctionExpression(AFunctionExpression node) {
    if (this.currentFunctionCall.equals("")) {
    } else {
      Type variableType = symbolTable.getParameterType(this.currentFunctionCall, this.currentFunctionParameterIndex);
      if (variableType == Type.DOUBLE) {
        this.type = Type.DOUBLE;
      }
    }
  }

  @Override
  public void caseAReturnStatement(AReturnStatement node) {
    Type returnType = symbolTable.getType("Methods", this.currentScope);

    node.getExpression().apply(this);

    if (returnType == Type.DOUBLE) {
      this.type = Type.DOUBLE;
    }
  }

  @Override
  public void caseAWriteLineStatement(AWriteLineStatement node) {
    node.getExpression().apply(this);
  }

  public boolean needsACast() {
    if (this.type == Type.DOUBLE) {
      this.needsCast = true;
    }

    boolean tmp = this.needsCast;
    this.needsCast = false;
    this.type = Type.INT;
    return tmp;
  }

  public void setCurrentScope(String newScope) {
    this.currentScope = newScope;
  }

  public void setCurrentFunctionParameterIndex(int newFunctionParameterIndex) {
    this.currentFunctionParameterIndex = newFunctionParameterIndex;
  }

  public void setCurrentFunctionCall(String newFunctionCall) {
    this.currentFunctionCall = newFunctionCall;
  }
}