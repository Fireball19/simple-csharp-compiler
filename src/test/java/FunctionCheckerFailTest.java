import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class FunctionCheckerFailTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/fail/functionchecker/";
  private final int errorCode = 4;

  @Test
  public void function_int_constant() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "function_int_constant.cs");
    compiler.compile();
  }

  @Test
  public void function_double_constant() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "function_double_constant.cs");
    compiler.compile();
  }

  @Test
  public void function_string_constant() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "function_string_constant.cs");
    compiler.compile();
  }

  @Test
  public void function_bool_true_constant() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "function_bool_true_constant.cs");
    compiler.compile();
  }

  @Test
  public void function_bool_false_constant() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "function_bool_false_constant.cs");
    compiler.compile();
  }
}
