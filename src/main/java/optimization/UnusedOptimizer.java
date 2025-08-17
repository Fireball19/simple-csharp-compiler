package optimization;

import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;
import symboltable.SymbolTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

public class UnusedOptimizer extends DepthFirstAdapter {

  private final SymbolTable symbolTable;

  private final HashMap<String, Boolean> used = new HashMap<>();
  private final LinkedList<String> result = new LinkedList<>();

  public UnusedOptimizer(SymbolTable symbolTable) {
    this.symbolTable = symbolTable;
  }

  @Override
  public void caseAMainForm(AMainForm node) {
    used.clear();
    for (String s : symbolTable.getMainScopeKeySet()) {
      used.put(s, Boolean.FALSE);
    }

    for (Node n : node.getStatements()) {
      n.apply(this);
    }

    Set<String> set = used.keySet().stream()
        .filter(key -> Boolean.FALSE.equals(used.get(key)))
        .collect(Collectors.toSet());
    result.addAll(set);
  }

  @Override
  public void caseAMethod(AMethod node) {
    used.clear();

    for (Node n : node.getStatements()) {
      n.apply(this);
    }

    Set<String> set = used.keySet().stream()
        .filter(key -> Boolean.FALSE.equals(used.get(key)))
        .collect(Collectors.toSet());
    result.addAll(set);
  }

  @Override
  public void caseAIdentifierExpression(AIdentifierExpression node) {
    used.put(node.getIdentifier().getText(), true);
  }

  public void printResult() {
    for (String s : result) {
      System.out.println("INFO: Unused variable '" + s + "'.");
    }
  }
}
