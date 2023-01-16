import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class ReturnCheckerTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/returnchecker/";

  @Test
  public void return_functions() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "return_functions.cs");
    compiler.compile();
  }

  @Test
  public void return_nested() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "return_nested.cs");
    compiler.compile();
  }

  @Test
  public void void_optional_return() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "void_optional_return.cs");
    compiler.compile();
  }
}
