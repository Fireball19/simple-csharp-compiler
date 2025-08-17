package checker;

import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;

/**
 * The function checker.
 * Fix for the grammar, prevents literal(...).
 */
public class FunctionChecker extends DepthFirstAdapter {

  private int pos;
  private int line;

  // literal regex expressions, have to match the sablecc grammar
  private final static String INT_LITERAL = "\\d+";
  private final static String DOUBLE_LITERAL = "\\d+.\\d+";
  private final static String BOOL_LITERAL = "true|false";
  private final static String STRING_LITERAL = "\"\\p{ASCII}*\""; // does not need to exclude " from ASCII, parser does that already

  @Override
  public void caseAFunctionExpression(AFunctionExpression node) {
    String literal = node.getFunction().toString().replaceAll(" ", "");

    if (literal.matches(INT_LITERAL) || literal.matches(DOUBLE_LITERAL) || literal.matches(BOOL_LITERAL)
        || literal.matches(STRING_LITERAL)) {
      node.getFunction().apply(this);
      System.err.println("ERROR: Expected 'identifier' but found '" + literal + "' in line " + line + " at position " + pos + ".");
      System.exit(4);
    }

    for(Node n : node.getParameters()) {
      n.apply(this);
    }
  }

  @Override
  public void caseAIntLiteral(AIntLiteral node) {
    this.line = node.getIntLiteral().getLine();
    this.pos = node.getIntLiteral().getPos();
  }

  @Override
  public void caseADoubleLiteral(ADoubleLiteral node) {
    this.line = node.getDoubleLiteral().getLine();
    this.pos = node.getDoubleLiteral().getPos();
  }

  @Override
  public void caseAStringLiteral(AStringLiteral node) {
    this.line = node.getStringLiteral().getLine();
    this.pos = node.getStringLiteral().getPos();
  }

  @Override
  public void caseABoolLiteral(ABoolLiteral node) {
    this.line = node.getBoolLiteral().getLine();
    this.pos = node.getBoolLiteral().getPos();
  }
}
