package symboltable;

import java.util.ArrayList;
import java.util.List;

public class FunctionParameterType {
  private final List<Type> parameters = new ArrayList<>();

  public void addParameterType(Type type) {
    parameters.add(type);
  }

  public List<Type> getParameters() {
    return parameters;
  }

  public int getSize() {
    return parameters.size();
  }
}
