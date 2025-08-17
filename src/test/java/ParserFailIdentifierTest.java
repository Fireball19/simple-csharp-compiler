import org.junit.Test;
import sablecc.lexer.LexerException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserFailIdentifierTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/fail/parser/identifier/";

  @Test
  public void identifier_bool_false_literal() throws IOException, LexerException {
    assertEquals("[9,17] expecting: identifier", parserTestUtil.parse(pathSuffix + "identifier_bool_false_literal.cs"));
  }

  @Test
  public void identifier_bool_true_literal() throws IOException, LexerException {
    assertEquals("[9,17] expecting: identifier", parserTestUtil.parse(pathSuffix + "identifier_bool_true_literal.cs"));
  }

  @Test
  public void identifier_double_literal() throws IOException, LexerException {
    assertEquals("[9,17] expecting: identifier", parserTestUtil.parse(pathSuffix + "identifier_double_literal.cs"));
  }

  @Test
  public void identifier_int_literal() throws IOException, LexerException {
    assertEquals("[9,17] expecting: identifier", parserTestUtil.parse(pathSuffix + "identifier_int_literal.cs"));
  }

  @Test
  public void identifier_string_literal() throws IOException, LexerException {
    assertEquals("[9,17] expecting: identifier", parserTestUtil.parse(pathSuffix + "identifier_string_literal.cs"));
  }
}
