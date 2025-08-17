import sablecc.lexer.Lexer;
import sablecc.lexer.LexerException;
import sablecc.node.Start;
import sablecc.parser.Parser;
import sablecc.parser.ParserException;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

public class ParserTestUtil {
  public String parse(String filename) throws IOException, LexerException {
    CSharpFileReader fileReader = new CSharpFileReader(filename);
    String input = fileReader.getFileString();

    StringReader reader = new StringReader(input);
    PushbackReader r = new PushbackReader(reader);
    Lexer l = new Lexer(r);
    Parser p = new Parser(l);

    String message = "";
    try {
      Start start = p.parse();
    } catch (ParserException e) {
      message = e.getMessage();
    }

    return message;
  }
}
