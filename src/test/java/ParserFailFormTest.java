import static org.junit.Assert.assertEquals;
import sablecc.lexer.LexerException;
import org.junit.Test;

import java.io.IOException;

public class ParserFailFormTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/fail/parser/form/";

  @Test
  public void main_missing_args() throws IOException, LexerException {
    assertEquals("[7,34] expecting: 'args'", parserTestUtil.parse(pathSuffix + "main_missing_args.cs"));
  }

  @Test
  public void main_missing_array() throws IOException, LexerException {
    assertEquals("[7,33] expecting: '['", parserTestUtil.parse(pathSuffix + "main_missing_array.cs"));
  }

  @Test
  public void main_missing_Main() throws IOException, LexerException {
    assertEquals("[7,21] expecting: 'Main'", parserTestUtil.parse(pathSuffix + "main_missing_Main.cs"));
  }

  @Test
  public void main_missing_string() throws IOException, LexerException {
    assertEquals("[7,26] expecting: 'string'", parserTestUtil.parse(pathSuffix + "main_missing_string.cs"));
  }

  @Test
  public void main_missing_void() throws IOException, LexerException {
    assertEquals("[7,16] expecting: 'void'", parserTestUtil.parse(pathSuffix + "main_missing_void.cs"));
  }

  @Test
  public void only_using() throws IOException, LexerException {
    assertEquals("[1,14] expecting: 'namespace'", parserTestUtil.parse(pathSuffix + "only_using.cs"));
  }

  @Test
  public void only_using_and_namespace() throws IOException, LexerException {
    assertEquals("[5,1] expecting: 'class'", parserTestUtil.parse(pathSuffix + "only_using_and_namespace.cs"));
  }

  @Test
  public void only_using_namespace_and_class() throws IOException, LexerException {
    assertEquals("[7,5] expecting: 'static'", parserTestUtil.parse(pathSuffix + "only_using_namespace_and_class.cs"));
  }
}
