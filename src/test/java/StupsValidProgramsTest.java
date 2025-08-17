import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class StupsValidProgramsTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/stups/valid-programs/";

  @Test
  public void celsiusToFahrenheit() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "CelsiusToFahrenheit.cs");
    compiler.compile();
  }

  @Test
  public void fahrenheitToCelsius() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "FahrenheitToCelsius.cs");
    compiler.compile();
  }

  @Test
  public void fibonacciRecursive() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "FibonacciRecursive.cs");
    compiler.compile();
  }

  @Test
  public void helloWorld() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "HelloWorld.cs");
    compiler.compile();
  }

  @Test
  public void rgbToCYMK() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "RgbToCYMK.cs");
    compiler.compile();
  }
}
