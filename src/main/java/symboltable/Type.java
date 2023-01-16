package symboltable;

public enum Type {
  VOID, INT, DOUBLE, STRING, BOOL;

  @Override
  public String toString() {
    return name().toLowerCase();
  }

  // TODO: use node as parameter not string to simplify usage in analysis
  public static Type findType(String node) {
    // nodes defined by the sablecc grammar
    if (node.equals("AIntType") || node.equals("AIntReturnType")) return Type.INT;
    if (node.equals("ADoubleType") || node.equals("ADoubleReturnType")) return Type.DOUBLE;
    if (node.equals("AStringType") || node.equals("AStringReturnType")) return Type.STRING;
    if (node.equals("ABoolType")|| node.equals("ABoolReturnType")) return Type.BOOL;
    return Type.VOID;
  }
}
