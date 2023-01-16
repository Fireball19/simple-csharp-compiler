import org.junit.Test;
import sablecc.lexer.LexerException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserVariableTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/parser/variable/";

  @Test
  public void variables_declaration() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "variables_declaration.cs"));
  }

  @Test
  public void variable_declaration() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "variable_declaration.cs"));
  }

  @Test
  public void variable_int_initialization() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "variable_int_initialization.cs"));
  }

  @Test
  public void variable_identifier_initialization() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "variable_identifier_initialization.cs"));
  }

  @Test
  public void variable_bool_initialization() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "variable_bool_initialization.cs"));
  }

  @Test
  public void variable_bool_initialization_true() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "variable_bool_initialization_true.cs"));
  }
}
