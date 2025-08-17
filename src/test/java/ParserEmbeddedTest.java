import org.junit.Test;
import sablecc.lexer.LexerException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserEmbeddedTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/parser/embedded/";

  @Test
  public void if_else() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "if_else.cs"));
  }

  @Test
  public void if_empty() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "if_empty.cs"));
  }

  @Test
  public void if_if_if() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "if_if_if.cs"));
  }

  @Test
  public void if_if_while_empty() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "if_if_while_empty.cs"));
  }

  @Test
  public void if_single_assignment() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "if_single_assignment.cs"));
  }

  @Test
  public void while_method() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "while_method.cs"));
  }
}
