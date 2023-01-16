import org.junit.Test;
import sablecc.lexer.LexerException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserFailMethodTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/fail/parser/method/";

  @Test
  public void parameter_method_missing_comma() throws IOException, LexerException {
    assertEquals("[11,47] expecting: ')', ','", parserTestUtil.parse(pathSuffix + "parameter_method_missing_comma.cs"));
  }

  @Test
  public void parameter_method_missing_identifier() throws IOException, LexerException {
    assertEquals("[11,34] expecting: identifier", parserTestUtil.parse(pathSuffix + "parameter_method_missing_identifier.cs"));
  }

  @Test
  public void parameter_method_missing_type() throws IOException, LexerException {
    assertEquals("[11,58] expecting: 'int', 'double', 'string', 'bool'", parserTestUtil.parse(pathSuffix + "parameter_method_missing_type.cs"));
  }
}
