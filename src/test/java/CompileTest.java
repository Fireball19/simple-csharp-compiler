import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class CompileTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/complex/";

  @Test
  public void nested_while() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "nested_while.cs");
    compiler.compile();
  }

  @Test
  public void print_if() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "print_if.cs");
    compiler.compile();
  }

  @Test
  public void many_variables_main() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "many_variables_main.cs");
    compiler.compile();
  }

  @Test
  public void writeline_empty_statements() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "writeline_empty_statements.cs");
    compiler.compile();
  }

  @Test
  public void nested_if() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "nested_if.cs");
    compiler.compile();
  }
}
