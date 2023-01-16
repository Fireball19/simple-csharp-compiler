import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class StupsParseErrorsTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  private final static String pathSuffix = "c#/stups/parse-errors/";
  private final int exitCode = 3;

  @Test
  public void assignValueToFunctionCall() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "AssignValueToFunctionCall.cs");
    compiler.compile();
  }

  @Test
  public void colonInsteadOfSemi() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "ColonInsteadOfSemi.cs");
    compiler.compile();
  }

  @Test
  public void commaToMuch() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "CommaToMuch.cs");
    compiler.compile();
  }

  @Test
  public void commentInDeclaration() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "CommentInDeclaration.cs");
    compiler.compile();
  }

  @Test
  public void declarationInsteadOfExpression() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "DeclarationInsteadOfExpression.cs");
    compiler.compile();
  }

  @Test
  public void doubleWithComma() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "DoubleWithComma.cs");
    compiler.compile();
  }

  @Test
  public void illegalIDName() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IllegalIDName.cs");
    compiler.compile();
  }

  @Test
  public void illegalProgramName() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "IllegalProgramName.cs");
    compiler.compile();
  }

  @Test
  public void missingArgAfterNot() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "MissingArgAfterNot.cs");
    compiler.compile();
  }

  @Test
  public void missingArgAfterUnaryPlus() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "MissingArgAfterUnaryPlus.cs");
    compiler.compile();
  }

  @Test
  public void missingBracket() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "MissingBracket.cs");
    compiler.compile();
  }

  @Test
  public void missingBracket2() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "MissingBracket2.cs");
    compiler.compile();
  }

  @Test
  public void missingBracket3() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "MissingBracket3.cs");
    compiler.compile();
  }

  @Test
  public void missingBracket4() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "MissingBracket4.cs");
    compiler.compile();
  }

  @Test
  public void missingReturnType() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "MissingReturnType.cs");
    compiler.compile();
  }

  @Test
  public void missingSemicolon() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "MissingSemicolon.cs");
    compiler.compile();
  }

  @Test
  public void missingSpace() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "MissingSpace.cs");
    compiler.compile();
  }

  @Test
  public void noneExistingCompare() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "NoneExistingCompare.cs");
    compiler.compile();
  }

  @Test
  public void noneExistingType() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "NoneExistingType.cs");
    compiler.compile();
  }

  @Test
  public void noneExistingType2() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "NoneExistingType2.cs");
    compiler.compile();
  }

  @Test
  public void notANumber() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "NotANumber.cs");
    compiler.compile();
  }

  @Test
  public void plusOneOperator() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "PlusOneOperator.cs");
    compiler.compile();
  }

  @Test
  public void stringLiteral() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "StringLiteral.cs");
    compiler.compile();
  }

  @Test
  public void stringWrongQuote() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "StringWrongQuote.cs");
    compiler.compile();
  }

  @Test
  public void wrongIfElse() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WrongIfElse.cs");
    compiler.compile();
  }

  @Test
  public void wrongIfElse2() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WrongIfElse2.cs");
    compiler.compile();
  }

  @Test
  public void wrongSemicolon() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WrongSemicolon.cs");
    compiler.compile();
  }

  @Test
  public void wrongSpace() {
    exit.expectSystemExitWithStatus(exitCode);
    CSharpCompiler compiler = new CSharpCompiler("-compile", pathSuffix + "WrongSpace.cs");
    compiler.compile();
  }
}
