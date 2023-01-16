import org.junit.Test;
import sablecc.lexer.LexerException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserFailParTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/fail/parser/par/";

  @Test
  public void emptyParExpression() throws IOException, LexerException {
    assertEquals("[9,32] expecting: int literal, double literal, string literal," +
        " bool literal, identifier, '+', '-', '!', '('",
        parserTestUtil.parse(pathSuffix + "EmptyParExpression.cs"));
  }
}
