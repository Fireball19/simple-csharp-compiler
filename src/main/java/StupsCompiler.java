/**
 * The stups compiler.
 * Contains the main method and handles the console arguments.
 * <br>
 * SYSTEM.EXIT ERROR CODES:
 *  <table>
 *   <tr>
 *     <th>Value</th>
 *     <th>Description</th>
 *   </tr>
 *   <tr>
 *     <td>1</td>
 *     <td>for argument errors in {@link StupsCompiler} and {@link CSharpCompiler#run()}.</td>
 *   </tr>
 *   <tr>
 *     <td>2</td>
 *     <td>for file reading errors in {@link CSharpFileReader}.</td>
 *   </tr>
 *   <tr>
 *     <td>3</td>
 *     <td>for {@link sablecc} io, lexer and parser errors.</td>
 *   </tr>
 *   <tr>
 *     <td>4</td>
 *     <td>for errors in additional parsing checks in {@link checker.FunctionChecker} and
 *     {@link checker.StatementChecker}.</td>
 *   </tr>
 *   <tr>
 *     <td>5</td>
 *     <td>for errors in return statements in {@link checker.ReturnChecker}</td>
 *   </tr>
 *   <tr>
 *     <td>6</td>
 *     <td>for errors in finding symbols and checking types in {@link symboltable.SymbolTable},
 *     {@link symboltable.SymbolFinder} and {@link checker.TypeChecker}</td>
 *   </tr>
 * </table>
 */
public class StupsCompiler {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("""
          ERROR: Wrong number of arguments. Usage:
          FORMAT: -mode <filename.cs>
          VALID MODES: -compile""");
      System.exit(1);
    }

    String mode = args[0];
    String filename = args[1];

    CSharpCompiler compiler = new CSharpCompiler(mode, filename);
    compiler.run();
  }
}
