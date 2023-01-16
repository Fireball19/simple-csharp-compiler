import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class StupsTypeErrorsTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/stups/type-errors/";
  private final int errorCode = 6;

  @Test
  public void assignBoolExprToIntVar() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignBoolExprToIntVar.cs");
    compiler.compile();
  }

  @Test
  public void assignBoolVarToIntVar() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignBoolVarToIntVar.cs");
    compiler.compile();
  }

  @Test
  public void assignIntExprToBoolVar() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignIntExprToBoolVar.cs");
    compiler.compile();
  }

  @Test
  public void assignStringExprToBoolVar() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignStringExprToBoolVar.cs");
    compiler.compile();
  }

  @Test
  public void boolFunctionToInt() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "BoolFunctionToInt.cs");
    compiler.compile();
  }

  @Test
  public void duplicateIdentifier() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "DuplicateIdentifier.cs");
    compiler.compile();
  }

  @Test
  public void duplicateIdentifier2() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "DuplicateIdentifier2.cs");
    compiler.compile();
  }

  @Test
  public void missingSpace2() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "MissingSpace2.cs");
    compiler.compile();
  }

  @Test
  public void notDeclared() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "NotDeclared.cs");
    compiler.compile();
  }

  @Test
  public void plusOnBoolean() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "PlusOnBoolean.cs");
    compiler.compile();
  }

  @Test
  public void putDoubleInInt() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "PutDoubleInInt.cs");
    compiler.compile();
  }

  @Test
  public void returnWithoutExpression() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ReturnWithoutExpression.cs");
    compiler.compile();
  }

  @Test
  public void typoBool() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "TypoBool.cs");
    compiler.compile();
  }

  @Test
  public void typoBool2() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "TypoBool2.cs");
    compiler.compile();
  }

  @Test
  public void undeclaredFunctionCall() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "UndeclaredFunctionCall.cs");
    compiler.compile();
  }

  @Test
  public void undeclaredVariable() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "UndeclaredVariable.cs");
    compiler.compile();
  }

  @Test
  public void wrongArgNumber() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WrongArgNumber.cs");
    compiler.compile();
  }

  @Test
  public void wrongCompare() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WrongCompare.cs");
    compiler.compile();
  }

  @Test
  public void wrongFunctionArgs() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WrongFunctionArgs.cs");
    compiler.compile();
  }

  @Test
  public void wrongReturnValue() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WrongReturnValue.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypesInArithmetic() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WrongTypesInArithmetic.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypesInArithmetic2() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WrongTypesInArithmetic2.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypesInArithmetic3() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WrongTypesInArithmetic3.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypesInLogic() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "wrongTypesInLogic.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypesInLogic2() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "wrongTypesInLogic2.cs");
    compiler.compile();
  }

  @Test
  public void wrongTypesInLogic3() {
    exit.expectSystemExitWithStatus(errorCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "wrongTypesInLogic3.cs");
    compiler.compile();
  }
}
