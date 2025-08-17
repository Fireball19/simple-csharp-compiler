import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class LexerFailTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/fail/lexer/";
  private final int exitCode = 3;

  @Test
  public void unknown_symbol() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "unknown_symbol.cs");
    compiler.compile();
  }
}
