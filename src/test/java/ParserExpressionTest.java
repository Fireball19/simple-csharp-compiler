import org.junit.Test;
import sablecc.lexer.LexerException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserExpressionTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/parser/expression/";

  @Test
  public void expression_function() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "expression_function.cs"));
  }
}
