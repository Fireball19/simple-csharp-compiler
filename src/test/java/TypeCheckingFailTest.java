import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class TypeCheckingFailTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/fail/typechecking/";
  private final int errorCode = 6;

  @Test
  public void add_int_bool() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "add_int_bool.cs");
    compiler.compile();
  }

  @Test
  public void if_wrong_type() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "if_wrong_type.cs");
    compiler.compile();
  }

  @Test
  public void method_add_wrong_type() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "method_add_wrong_type.cs");
    compiler.compile();
  }

  @Test
  public void method_not_declared() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "method_not_declared.cs");
    compiler.compile();
  }

  @Test
  public void return_wrong_type() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "return_wrong_type.cs");
    compiler.compile();
  }

  @Test
  public void return_double_wrong_type() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "return_double_wrong_type.cs");
    compiler.compile();
  }

  @Test
  public void return_wrong_type_void() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "return_wrong_type_void.cs");
    compiler.compile();
  }

  @Test
  public void two_methods_same_identifier() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "two_methods_same_identifier.cs");
    compiler.compile();
  }

  @Test
  public void variable_declared_two_times() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "variable_declared_two_times.cs");
    compiler.compile();
  }

  @Test
  public void variable_initialized_main_does_not_exist() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "variable_initialized_main_does_not_exist.cs");
    compiler.compile();
  }

  @Test
  public void variable_initialized_statement_wrong_type() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "variable_initialized_statement_wrong_type.cs");
    compiler.compile();
  }

  @Test
  public void variable_initialized_statement_wrong_scope() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "variable_initialized_statement_wrong_scope.cs");
    compiler.compile();
  }

  @Test
  public void variable_initialized_statement_function_does_not_exist() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "variable_initialized_statement_function_does_not_exist.cs");
    compiler.compile();
  }

  @Test
  public void variable_initialized_two_times() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "variable_initialized_two_times.cs");
    compiler.compile();
  }

  @Test
  public void variable_initialized_wrong_type() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "variable_initialized_wrong_type.cs");
    compiler.compile();
  }

  @Test
  public void writeline_wrong_type() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "writeline_wrong_type.cs");
    compiler.compile();
  }

  @Test
  public void if_not_bool_expression() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "if_not_bool_expression.cs");
    compiler.compile();
  }

  @Test
  public void if_else_not_bool_expression() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "if_else_not_bool_expression.cs");
    compiler.compile();
  }

  @Test
  public void variable_undeclared() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "variable_undeclared.cs");
    compiler.compile();
  }

  @Test
  public void variable_undeclared_2() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "variable_undeclared_2.cs");
    compiler.compile();
  }

  @Test
  public void variable_undeclared_3() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "variable_undeclared_3.cs");
    compiler.compile();
  }

  @Test
  public void while_not_bool_expression() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "while_not_bool_expression.cs");
    compiler.compile();
  }

  @Test
  public void variable_not_initialized() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "variable_not_initialized.cs");
    compiler.compile();
  }

  @Test
  public void wrong_type_function_call() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "wrong_type_function_call.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypeIntPar() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "WrongTypeIntPar.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypeIntPar2() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "WrongTypeIntPar2.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypeIntPar3() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "WrongTypeIntPar3.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypeIntPar4() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "WrongTypeIntPar4.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypeIntPar5() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "WrongTypeIntPar5.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypeStringPar() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("compile", pathSuffix + "WrongTypeStringPar.cs");
    compiler.compile();
  }
}
