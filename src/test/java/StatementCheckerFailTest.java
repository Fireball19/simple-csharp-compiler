import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class StatementCheckerFailTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/fail/statementchecker/";
  private final int errorCode = 4;

  @Test
  public void statement_add() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_add.cs");
    compiler.compile();
  }

  @Test
  public void statement_bool_false_literal() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_bool_false_literal.cs");
    compiler.compile();
  }

  @Test
  public void statement_bool_true_literal() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_bool_true_literal.cs");
    compiler.compile();
  }

  @Test
  public void statement_div() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_div.cs");
    compiler.compile();
  }

  @Test
  public void statement_double_literal() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_double_literal.cs");
    compiler.compile();
  }

  @Test
  public void statement_equals() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_equals.cs");
    compiler.compile();
  }

  @Test
  public void statement_identifier() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_identifier.cs");
    compiler.compile();
  }

  @Test
  public void statement_int_literal() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_int_literal.cs");
    compiler.compile();
  }

  @Test
  public void statement_logical_and() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_logical_and.cs");
    compiler.compile();
  }

  @Test
  public void statement_logical_or() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_logical_or.cs");
    compiler.compile();
  }

  @Test
  public void statement_mod() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_mod.cs");
    compiler.compile();
  }

  @Test
  public void statement_mult() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_mult.cs");
    compiler.compile();
  }

  @Test
  public void statement_not_equals() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_not_equals.cs");
    compiler.compile();
  }

  @Test
  public void statement_string_literal() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_string_literal.cs");
    compiler.compile();
  }

  @Test
  public void statement_sub() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_sub.cs");
    compiler.compile();
  }

  @Test
  public void statement_unary_minus() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_unary_minus.cs");
    compiler.compile();
  }

  @Test
  public void statement_unary_not() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_unary_not.cs");
    compiler.compile();
  }

  @Test
  public void statement_unary_plus() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "statement_unary_plus.cs");
    compiler.compile();
  }
}
