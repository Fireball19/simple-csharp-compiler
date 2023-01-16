import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class ReturnCheckerFailTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/fail/returnchecker/";
  private final int errorCode = 5;

  @Test
  public void if_return() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "if_return.cs");
    compiler.compile();
  }

  @Test
  public void if_else_if() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "if_else_if.cs");
    compiler.compile();
  }

  @Test
  public void if_else_while_if_else() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "if_else_while_if_else.cs");
    compiler.compile();
  }

  @Test
  public void if_else_while_if_else_many_returns() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "if_else_while_if_else_many_returns.cs");
    compiler.compile();
  }

  @Test
  public void while_if_else() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "while_if_else.cs");
    compiler.compile();
  }

  @Test
  public void missing_return() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "missing_return.cs");
    compiler.compile();
  }

  @Test
  public void while_return() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "while_return.cs");
    compiler.compile();
  }
}
