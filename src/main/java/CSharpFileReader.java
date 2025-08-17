import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 * The c# file reader.
 * Checks if the file is found and end with .cs.
 */
public class CSharpFileReader {

  private final Path path;

  public CSharpFileReader(String fileName) {
    checkFileExtension(fileName);
    this.path = Path.of(fileName);
  }

  public String getFileString() {
    String string = "";
    try {
      string = Files.readString(this.path);

    } catch (NoSuchFileException e) {
      System.err.println("ERROR: File " + this.path + " not found");
      System.exit(2);

    } catch (IOException e) {
      System.err.println("ERROR: " + e.getClass().getSimpleName());
      System.exit(2);
    }

    return string;
  }

  public String getFileName() {
    return path.getFileName().toString();
  }

  public String getClassName() {
    return path.getFileName().toString().replaceFirst("[.][^.]+$", "");
  }

  private void checkFileExtension(String fileName) {
    if (!fileName.endsWith(".cs")) {
      System.err.println("ERROR: Wrong file extension use '.cs'.");
      System.exit(2);
    }
  }
}
