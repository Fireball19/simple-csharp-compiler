import org.junit.Test;
import sablecc.lexer.LexerException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserOutputTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/parser/output/";

  @Test
  public void output_bool_true() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "output_bool_true.cs"));
  }

  @Test
  public void output_double_const() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "output_double_const.cs"));
  }

  @Test
  public void output_int_const() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "output_int_const.cs"));
  }

  @Test
  public void output_no_expression() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "output_no_expression.cs"));
  }

  @Test
  public void output_string() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "output_string.cs"));
  }
}
