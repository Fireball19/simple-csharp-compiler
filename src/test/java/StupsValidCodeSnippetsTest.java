import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class StupsValidCodeSnippetsTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/stups/valid-codesnipsets/";

  @Test
  public void addInt() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AddInt.cs");
    compiler.compile();
  }

  @Test
  public void assignBool() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignBool.cs");
    compiler.compile();
  }

  @Test
  public void assignBooleanFunctionCall() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignBooleanFunctionCall.cs");
    compiler.compile();
  }

  @Test
  public void assignDoubleFunctionCall() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignDoubleFunctionCall.cs");
    compiler.compile();
  }

  @Test
  public void assignIntCompare() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignIntCompare.cs");
    compiler.compile();
  }

  @Test
  public void assignIntCompare2() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignIntCompare2.cs");
    compiler.compile();
  }

  @Test
  public void assignIntFunctionCall() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignIntFunctionCall.cs");
    compiler.compile();
  }

  @Test
  public void assignNegativeDouble() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignNegativeDouble.cs");
    compiler.compile();
  }

  @Test
  public void assignNegativeNumber() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignNegativeNumber.cs");
    compiler.compile();
  }

  @Test
  public void assignNumber() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignNumber.cs");
    compiler.compile();
  }

  @Test
  public void assignString() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignString.cs");
    compiler.compile();
  }

  @Test
  public void assignString2() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignString2.cs");
    compiler.compile();
  }

  @Test
  public void assignString3() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignString3.cs");
    compiler.compile();
  }

  @Test
  public void assignStringFunctionCall() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignStringFunctionCall.cs");
    compiler.compile();
  }

  @Test
  public void callDoubleFunctionWithIntArg() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "CallDoubleFunctionWithIntArg.cs");
    compiler.compile();
  }

  @Test
  public void assignIntToDouble() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignIntToDouble.cs");
    compiler.compile();
  }

  @Test
  public void callInIf() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "CallInIf.cs");
    compiler.compile();
  }

  @Test
  public void callInWhile() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "CallInWhile.cs");
    compiler.compile();
  }

  @Test
  public void declareBoolean() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "DeclareBoolean.cs");
    compiler.compile();
  }

  @Test
  public void declareDouble() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "DeclareDouble.cs");
    compiler.compile();
  }

  @Test
  public void declareInt() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "DeclareInt.cs");
    compiler.compile();
  }

  @Test
  public void declareString() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "DeclareString.cs");
    compiler.compile();
  }

  @Test
  public void doubleInWhile() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "DoubleInWhile.cs");
    compiler.compile();
  }

  @Test
  public void doubleLessThanInteger() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "DoubleLessThanInteger.cs");
    compiler.compile();
  }

  @Test
  public void emptyMainMethod() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "EmptyMainMethod.cs");
    compiler.compile();
  }

  @Test
  public void emptyMethodWithArgs() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "EmptyMethodWithArgs.cs");
    compiler.compile();
  }

  @Test
  public void emptyWhileLoop() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "EmptyWhileLoop.cs");
    compiler.compile();
  }

  @Test
  public void expressionAddInt() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionAddInt.cs");
    compiler.compile();
  }

  @Test
  public void expressionAndBool() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionAndBool.cs");
    compiler.compile();
  }

  @Test
  public void expressionDivInt() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionDivInt.cs");
    compiler.compile();
  }

  @Test
  public void expressionEqualBool() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionEqualBool.cs");
    compiler.compile();
  }

  @Test
  public void expressionGreaterBool() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionGreaterBool.cs");
    compiler.compile();
  }

  @Test
  public void expressionGreaterEqualBool() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionGreaterEqualBool.cs");
    compiler.compile();
  }

  @Test
  public void expressionLessBool() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionLessBool.cs");
    compiler.compile();
  }

  @Test
  public void expressionLessEqualBool() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionLessEqualBool.cs");
    compiler.compile();
  }

  @Test
  public void expressionModInt() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionModInt.cs");
    compiler.compile();
  }

  @Test
  public void expressionMulInt() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionMulInt.cs");
    compiler.compile();
  }

  @Test
  public void expressionNotBool() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionNotBool.cs");
    compiler.compile();
  }

  @Test
  public void expressionOrBool() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionOrBool.cs");
    compiler.compile();
  }

  @Test
  public void expressionSubInt() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionSubInt.cs");
    compiler.compile();
  }

  @Test
  public void expressionUnaryMinusInt() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionUnaryMinusInt.cs");
    compiler.compile();
  }

  @Test
  public void expressionUnaryPlusInt() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionUnaryPlusInt.cs");
    compiler.compile();
  }

  @Test
  public void expressionUnequalBool() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ExpressionUnequalBool.cs");
    compiler.compile();
  }

  @Test
  public void functionCall() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "FunctionCall.cs");
    compiler.compile();
  }

  @Test
  public void functionCallWithArgs() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "FunctionCallWithArgs.cs");
    compiler.compile();
  }

  @Test
  public void ifNoElse() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfNoElse.cs");
    compiler.compile();
  }

  @Test
  public void ifNoElse2() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfNoElse2.cs");
    compiler.compile();
  }

  @Test
  public void ifWhileIf() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfWhileIf.cs");
    compiler.compile();
  }

  @Test
  public void ifWhileIf2() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfWhileIf2.cs");
    compiler.compile();
  }

  @Test
  public void ifWhileIf3() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfWhileIf3.cs");
    compiler.compile();
  }

  @Test
  public void ifWhileIf4() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfWhileIf4.cs");
    compiler.compile();
  }

  @Test
  public void ifWithElse() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfWithElse.cs");
    compiler.compile();
  }

  @Test
  public void ifWithElseNoBlock() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfWithElseNoBlock.cs");
    compiler.compile();
  }

  @Test
  public void ifWithIntExpression() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfWithIntExpression.cs");
    compiler.compile();
  }

  @Test
  public void ifWithIntExpression2() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfWithIntExpression2.cs");
    compiler.compile();
  }

  @Test
  public void ifWithIntExpression3() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfWithIntExpression3.cs");
    compiler.compile();
  }

  @Test
  public void ifWithStringExpression() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfWithStringExpression.cs");
    compiler.compile();
  }

  @Test
  public void ifWithStringExpression2() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IfWithStringExpression2.cs");
    compiler.compile();
  }

  @Test
  public void multilineComment() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "MultilineComment.cs");
    compiler.compile();
  }

  @Test
  public void nestedCalls() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "NestedCalls.cs");
    compiler.compile();
  }

  @Test
  public void singlelineComment() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "SinglelineComment.cs");
    compiler.compile();
  }

  @Test
  public void twoFunctions() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "TwoFunctions.cs");
    compiler.compile();
  }

  @Test
  public void whileIf() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WhileIf.cs");
    compiler.compile();
  }

  @Test
  public void whileIf2() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WhileIf2.cs");
    compiler.compile();
  }

  @Test
  public void whileIf3() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WhileIf3.cs");
    compiler.compile();
  }

  @Test
  public void whileIf4() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WhileIf4.cs");
    compiler.compile();
  }

  @Test
  public void whileWithBoolExpression() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WhileWithBoolExpression.cs");
    compiler.compile();
  }

  @Test
  public void whileWithIntExpression() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WhileWithIntExpression.cs");
    compiler.compile();
  }

  @Test
  public void whileWithIntExpression2() {
    exit.expectSystemExitWithStatus(0);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WhileWithIntExpression2.cs");
    compiler.compile();
  }
}
