import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class StatementCheckerTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/statementchecker/";

  @Test
  public void three_functions() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "three_functions.cs");
    compiler.compile();
  }
}
