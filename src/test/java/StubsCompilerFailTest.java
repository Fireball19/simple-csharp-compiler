import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class StubsCompilerFailTest {

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  @Test
  public void only_one_argument() {
    exit.expectSystemExitWithStatus(1);
    String[] args = new String[1];
    args[0] = "arg1";
    StupsCompiler.main(args);
  }

  @Test
  public void three_arguments() {
    exit.expectSystemExitWithStatus(1);
    String[] args = new String[3];
    args[0] = "arg1";
    args[1] = "arg2";
    args[2] = "arg3";
    StupsCompiler.main(args);
  }
}
