import org.junit.Test;
import sablecc.lexer.LexerException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserMethodTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/parser/method/";

  @Test
  public void no_initialization_variables_main() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "no_initialization_variables_main.cs"));
  }

  @Test
  public void no_initialization_variables_methods() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "no_initialization_variables_methods.cs"));
  }

  @Test
  public void no_initialization_variables_methods_and_main() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "no_initialization_variables_methods_and_main.cs"));
  }

  @Test
  public void no_parameter_method() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "no_parameter_method.cs"));
  }

  @Test
  public void no_parameter_methods() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "no_parameter_methods.cs"));
  }

  @Test
  public void parameter_method() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "parameter_method.cs"));
  }

  @Test
  public void parameters_method() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "parameters_method.cs"));
  }
}
