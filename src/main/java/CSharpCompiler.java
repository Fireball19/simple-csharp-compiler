import checker.FunctionChecker;
import checker.ReturnChecker;
import checker.StatementChecker;
import checker.TypeChecker;
import codegenerator.CastFinder;
import codegenerator.CodeGenerator;
import optimization.UnusedOptimizer;
import printer.TokenPrinter;
import sablecc.lexer.Lexer;
import sablecc.lexer.LexerException;
import sablecc.node.Start;
import sablecc.parser.Parser;
import sablecc.parser.ParserException;
import symboltable.SymbolFinder;
import symboltable.SymbolTable;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * The c# compiler.
 * Puts everything together.
 */
public class CSharpCompiler {

  private final String mode;
  private final String filePath;
  private String sourceFileName = "";
  private String className = "";

  /**
   * @param mode      supported are -compile
   * @param filePath  only accepts .cs files
   */
  public CSharpCompiler(String mode, String filePath) {
    this.mode = mode;
    this.filePath = filePath;
  }

  public void run() {
   if (this.mode.equals("-compile")) {
     this.compile();
   } else {
     System.err.println("ERROR: Unknown mode '" + this.mode + "'\n" +
                         "VALID MODES: -compile");
     System.exit(1);
   }

  }

  public void compile() {
    Parser parser = initParser();

    try {
      Start start = parser.parse();
      System.out.println("Lexing successful.");
      System.out.println("Parsing successful.");

      // Additional parsing checks
      System.out.println("Initializing additional parsing checker.");
      FunctionChecker functionChecker = new FunctionChecker();
      StatementChecker statementChecker = new StatementChecker();
      System.out.println("Checking statements.");
      start.apply(statementChecker);
      System.out.println("Checking statements successful.");
      System.out.println("Checking function expressions.");
      start.apply(functionChecker);
      System.out.println("Checking function expressions successful.");

      // Symbol Table
      System.out.println("Initializing symbol table.");
      SymbolTable symbolTable = new SymbolTable();
      SymbolFinder symbolFinder = new SymbolFinder(symbolTable);
      System.out.println("Finding symbols.");
      start.apply(symbolFinder);
      System.out.println("Finding symbols successful.");

      // Return checker
      System.out.println("Initializing return checker.");
      ReturnChecker returnChecker = new ReturnChecker(symbolTable);
      System.out.println("Checking return statements.");
      start.apply(returnChecker);
      System.out.println("Checking return statements successful.");

      // Typechecking
      System.out.println("Initializing type checker.");
      TypeChecker typeChecker = new TypeChecker(symbolTable);
      System.out.println("Checking types.");
      start.apply(typeChecker);
      System.out.println("Checking types successful.");

      System.out.println("Initializing code generator.");
      CastFinder castFinder = new CastFinder(symbolTable);
      CodeGenerator codeGenerator = new CodeGenerator(this.className, symbolTable, castFinder);
      System.out.println("Generating code.");
      start.apply(codeGenerator);
      System.out.println("Generating code successful.");

      System.out.println("Writing Jasmin Bytecode file.");
      String jasminCode = createJasminCodeHeader(codeGenerator);
      Writer fileWriter = new BufferedWriter(
                          new OutputStreamWriter(
                          new FileOutputStream(this.className + ".j"), StandardCharsets.UTF_8));
      fileWriter.append(jasminCode);
      fileWriter.close();
      System.out.println("Writing Jasmin Bytecode file successful.");

    } catch (IOException e) {
      System.err.println("SABLECC IO ERROR: " + e.getMessage());
      System.exit(3);

    } catch (LexerException e) {
      System.err.println("SABLECC LEXER ERROR: " + e.getMessage());
      System.exit(3);

    } catch (ParserException e) {
      System.err.println("SABLECC PARSER ERROR: " + e.getMessage());
      System.exit(3);
    }

    System.exit(0);
  }

  public void optimize() {
    Parser parser = initParser();

    try {
      Start start = parser.parse();
      System.out.println("Lexing successful.");
      System.out.println("Parsing successful.");

      // Additional parsing checks
      System.out.println("Initializing additional parsing checker.");
      FunctionChecker functionChecker = new FunctionChecker();
      StatementChecker statementChecker = new StatementChecker();
      System.out.println("Checking statements.");
      start.apply(statementChecker);
      System.out.println("Checking statements successful.");
      System.out.println("Checking function expressions.");
      start.apply(functionChecker);
      System.out.println("Checking function expressions successful.");

      // Symbol Table
      System.out.println("Initializing symbol table.");
      SymbolTable symbolTable = new SymbolTable();
      SymbolFinder symbolFinder = new SymbolFinder(symbolTable);
      System.out.println("Finding symbols.");
      start.apply(symbolFinder);
      System.out.println("Finding symbols successful.");

      // Return checker
      System.out.println("Initializing return checker.");
      ReturnChecker returnChecker = new ReturnChecker(symbolTable);
      System.out.println("Checking return statements.");
      start.apply(returnChecker);
      System.out.println("Checking return statements successful.");

      // Typechecking
      System.out.println("Initializing type checker.");
      TypeChecker typeChecker = new TypeChecker(symbolTable);
      System.out.println("Checking types.");
      start.apply(typeChecker);
      System.out.println("Checking types successful.");

      // Optimization
      System.out.println("Initializing optimization.");
      UnusedOptimizer unusedOptimizer = new UnusedOptimizer(symbolTable);
      start.apply(unusedOptimizer);
      System.out.println("Optimization successful.");
      unusedOptimizer.printResult();

    } catch (IOException e) {
      System.err.println("SABLECC IO ERROR: " + e.getMessage());
      System.exit(3);

    } catch (LexerException e) {
      System.err.println("SABLECC LEXER ERROR: " + e.getMessage());
      System.exit(3);

    } catch (ParserException e) {
      System.err.println("SABLECC PARSER ERROR: " + e.getMessage());
      System.exit(3);
    }

    System.exit(0);
  }

  public void printToken() {
    Lexer lexer = initLexer();

    System.out.println("Initializing printer.");
    TokenPrinter printer = new TokenPrinter(lexer);
    System.out.println("Printing token.");
    printer.print();
  }

  private PushbackReader initPushbackReader() {
    System.out.println("Initializing reader.");
    //System.out.println("Reading file: " + this.path + ".");
    CSharpFileReader fileReader = new CSharpFileReader(this.filePath);
    this.sourceFileName = fileReader.getFileName();
    this.className = fileReader.getClassName();
    String input = fileReader.getFileString();
    StringReader stringReader = new StringReader(input);
    PushbackReader pushbackReader = new PushbackReader(stringReader);
    System.out.println("Reading successful.");

    return pushbackReader;
  }

  private Lexer initLexer() {
    PushbackReader pushbackReader = initPushbackReader();

    System.out.println("Initializing lexer.");

    return new Lexer(pushbackReader);
  }

  private Parser initParser() {
    Lexer lexer = initLexer();

    System.out.println("Initializing parser.");

    return new Parser(lexer);
  }

  private String createJasminCodeHeader(CodeGenerator codeGenerator) {
    return  ".bytecode 50.0\n" +
            ".source " + this.sourceFileName +"\n" +
            ".class public " + this.className +"\n" +
            ".super java/lang/Object\n" +
            ".method public <init>()V\n" +
            "\t.limit stack 1\n" +
            "\t.limit locals 1\n" +
            "\taload_0\n" +
            "\tinvokespecial java/lang/Object/<init>()V\n"+
            "\treturn\n" +
            ".end method\n" +
            codeGenerator.getCode();
  }
}