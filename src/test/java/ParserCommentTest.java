import sablecc.lexer.LexerException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserCommentTest {

  private final ParserTestUtil parserTestUtil = new ParserTestUtil();
  private final static String pathSuffix = "c#/parser/comment/";

  @Test
  public void comment() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "comment.cs"));
  }

  @Test
  public void comment_multiple() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "comment_multiple.cs"));
  }

  @Test
  public void comment_multiple2() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "comment_multiple2.cs"));
  }

  @Test
  public void comment_with_code() throws IOException, LexerException {
    assertEquals("", parserTestUtil.parse(pathSuffix + "comment_with_code.cs"));
  }
}
