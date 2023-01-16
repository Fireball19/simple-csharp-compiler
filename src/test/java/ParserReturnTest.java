import org.junit.Test;
import sablecc.lexer.LexerException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserReturnTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/parser/return/";

  @Test
  public void return_bool_false() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "return_bool_false.cs"));
  }

  @Test
  public void return_bool_true() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "return_bool_true.cs"));
  }

  @Test
  public void return_double_const() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "return_double_const.cs"));
  }

  @Test
  public void return_fib() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "return_fib.cs"));
  }

  @Test
  public void return_int_const() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "return_int_const.cs"));
  }

  @Test
  public void return_negative_int_const() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "return_negative_int_const.cs"));
  }

  @Test
  public void return_no_expression() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "return_no_expression.cs"));
  }

  @Test
  public void return_string() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "return_string.cs"));
  }
}
