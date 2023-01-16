package checker;

import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;

/**
 * The statement checker.
 * Fix for the grammar, only allows functions calls as expression statements.
 */
public class StatementChecker extends DepthFirstAdapter {

  @Override
  public void caseACallStatement(ACallStatement node) {
    String expression = node.getExpression().getClass().getSimpleName();

    if (!expression.equals("AFunctionExpression")) {
      System.err.println("ERROR: Only function call expressions can be used as a statement.");
      System.exit(4);
    }
  }
}
