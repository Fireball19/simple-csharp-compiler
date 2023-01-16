import org.junit.Test;
import sablecc.lexer.LexerException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserIdentifierTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/parser/identifier/";

  @Test
  public void identifier_mix() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "identifier_mix.cs"));
  }

  @Test
  public void identifier_only_dollar() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "identifier_only_dollar.cs"));
  }

  @Test
  public void identifier_only_letter() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "identifier_only_letter.cs"));
  }

  @Test
  public void identifier_only_underscore() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "identifier_only_underscore.cs"));
  }
}
