package symboltable;

import java.util.*;

public class SymbolTable {
  // standard scopes
  public static String MAIN_SCOPE = "Main";
  public static String METHODS_SCOPE = "Methods";

  // function parameters
  private final HashMap<String, FunctionParameterType> methodParameters = new HashMap<>();

  // symbol table
  private final LinkedHashMap<String, Type> methodScope = new LinkedHashMap<>();
  private final LinkedHashMap<String, Type> mainScope = new LinkedHashMap<>();
  private final HashMap<String, LinkedHashMap<String, Type>> symbolTable = new HashMap<>();

  // initialized variables table
  private final HashMap<String, HashMap<String, Boolean>> initializedTable = new HashMap<>();
  private final HashMap<String, Boolean> mainInitialized = new HashMap<>();

  public SymbolTable() {
    symbolTable.put(MAIN_SCOPE, mainScope);
    symbolTable.put(METHODS_SCOPE, methodScope);
    putMethod("Main", Type.VOID);

    initializedTable.put(MAIN_SCOPE, mainInitialized);
  }

  public int getVariableIndex(String scope, String identifier) {
    Set<String> tmp = symbolTable.get(scope).keySet();
    List<String> listKeys = new ArrayList<>(tmp);
    int index = listKeys.indexOf(identifier);

    // fixes indices, double count for 2 indices
    // example: int, double, int -> indices = 0, 1, 3
    int doubleCount = 0;
    for (int i = 0; i < index; i++) {
      if (getType(scope, listKeys.get(i)) == Type.DOUBLE) {
        doubleCount++;
      }
    }

    return index + doubleCount;
  }

  public Type getType(String scope, String identifier) {
    return symbolTable.get(scope).get(identifier);
  }

  public void addParameterType(String function, Type type) {
    methodParameters.get(function).addParameterType(type);
  }

  public Type getParameterType(String function, int index) {
    return methodParameters.get(function).getParameters().get(index);
  }

  public int getParameterSize(String function) {
    return methodParameters.get(function).getSize();
  }

  public boolean containsMethod(String method) {
    return symbolTable.containsKey(method);
  }

  public void putVariable(String scope, String identifier, Type type) {
    symbolTable.get(scope).put(identifier, type);
    initializedTable.get(scope).put(identifier, false);
  }

  public void putInitializedVariable(String scope, String identifier, Type type) {
    symbolTable.get(scope).put(identifier, type);
    initializedTable.get(scope).put(identifier, true);
  }

  public void initializeVariable(String scope, String identifier) {
    initializedTable.get(scope).replace(identifier, true);
  }

  public boolean isVariableInitialized(String scope, String identifier) {
    if (initializedTable.get(scope).get(identifier) == null) {
      System.err.println(("ERROR: Variable '" + identifier + "' does not exist in the function '" + scope + "'."));
      System.exit(6);
    }

    return initializedTable.get(scope).get(identifier);
  }

  public void putMethod(String identifier, Type type) {
    symbolTable.get(METHODS_SCOPE).put(identifier, type);
    addNewScope(identifier);
  }

  private void addNewScope(String identifier) {
    LinkedHashMap<String, Type> mapScope = new LinkedHashMap<>();
    HashMap<String, Boolean> mapInitialized = new HashMap<>();
    methodParameters.put(identifier, new FunctionParameterType());
    symbolTable.put(identifier, mapScope);
    initializedTable.put(identifier, mapInitialized);
  }

  public Set<String> getMainScopeKeySet() {
    return this.symbolTable.get(MAIN_SCOPE).keySet();
  }

  public int getMethodCount() {
    return this.symbolTable.get("Methods").size();
  }

  public boolean contains(String scope, String identifier) {
    return symbolTable.get(scope).containsKey(identifier);
  }

  public void print() {
    System.out.println("/* SYMBOL TABLE */");
    for (var letterEntry : symbolTable.entrySet()) {
      String letter = letterEntry.getKey();
      System.out.println(letter);
      System.out.println("-------------");
      for (var nameEntry : letterEntry.getValue().entrySet()) {
        System.out.println(nameEntry);
      }
      System.out.println();
    }

    System.out.println("/* INITIALIZED TABLE */");
    for (var letterEntry : initializedTable.entrySet()) {
      String letter = letterEntry.getKey();
      System.out.println(letter);
      System.out.println("-------------");
      for (var nameEntry : letterEntry.getValue().entrySet()) {
        System.out.println(nameEntry);
      }
      System.out.println();
    }

    System.out.println("/* METHOD PARAMETERS TABLE */");
    for (var letterEntry : methodParameters.entrySet()) {
      String letter = letterEntry.getKey();
      System.out.println(letter + ":" + letterEntry.getValue().getParameters().toString());
    }
  }
}
