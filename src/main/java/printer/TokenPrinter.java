package printer;

import sablecc.lexer.Lexer;
import sablecc.lexer.LexerException;
import sablecc.node.*;

import java.io.IOException;

public class TokenPrinter {

  private final Lexer lexer;

  public TokenPrinter(Lexer lexer) {
    this.lexer = lexer;
  }

  public void print() {
    System.out.println("""
        /*************/
        /****TOKEN****/
        /*************/""");
    Token t = null;
    do {
      try {
        t = lexer.next();
      } catch (IOException e) {
        System.err.println("SABLECC IO ERROR: " + e.getMessage());
        System.exit(1);
      } catch (LexerException e) {
        System.err.println("SABLECC LEXER ERROR: " + e.getMessage());
        System.exit(1);
      }
      printToken(t);
    } while (!(t instanceof EOF));

    System.out.print("""

        /*************/
        /****TOKEN****/
        /*************/
        """);
  }

  private void printToken(Token token) {
    // ignored tokens
    if (token.getClass() == TTabs.class || token.getClass() == TWhiteSpaces.class) {
      return;
    }

    // print tokens with text
    else if (token.getClass() == TIdentifier.class ||
        token.getClass() == TCommentSingleLine.class ||
        token.getClass() == TCommentMultipleLines.class) {
      System.out.print(token.getClass().getSimpleName().toUpperCase().substring(1) + ": " + token.getText());
    }

    // line token
    else if (token.getClass() == TLine.class) {
      System.out.print(token.getClass().getSimpleName().toUpperCase().substring(1) + " " + token.getLine());
    }

    else {

      if (token.getClass() == EOF.class) {
        System.out.print(token.getClass().getSimpleName().toUpperCase());
      }

      else {
        System.out.print(token.getClass().getSimpleName().toUpperCase().substring(1));
      }
    }

    if (token.getClass() != EOF.class) {
      System.out.println();
    }
  }
}
