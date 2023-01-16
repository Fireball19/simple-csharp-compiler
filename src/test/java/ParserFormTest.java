import org.junit.Test;
import sablecc.lexer.LexerException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserFormTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/parser/form/";

  @Test
  public void form() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "form.cs"));
  }
}
