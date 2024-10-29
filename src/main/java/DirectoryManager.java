import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class DirectoryManager {

  private static final String ROOT = "data";

  public static void main(String[] args) throws IOException {

    Path dataPath = Paths.get(ROOT);
    System.out.println("Create root/data");
    if(Files.notExists(dataPath)){
    Files.createDirectory(dataPath);
    }

    Path subdir1Path = dataPath.resolve("subdir1");
    Path subdir2Path = dataPath.resolve("subdir2");
    Path subdir3Path = dataPath.resolve("subdir3");
    Path subsubdirPath = dataPath.resolve("subdir3/subsubdir");

    System.out.println("Create root/data/subdir1");
    if(Files.notExists(subdir1Path)){
      Files.createDirectory(subdir1Path);
    }
    System.out.println("Create root/data/subdir2");
    if(Files.notExists(subdir2Path)){
      Files.createDirectory(subdir2Path);
    }
    System.out.println("Create root/data/subdir3");
    System.out.println("Create root/data/subdir3/subsubdir");
    if(Files.notExists(subdir3Path) && Files.notExists(subsubdirPath)){
      Files.createDirectories(subsubdirPath);
    }

    System.out.println("Create root/data/subdir3/subsubdir/myfile.txt");
    Path myFilePath = subsubdirPath.resolve("myfile.txt");
    if(Files.notExists(myFilePath)) {
      Files.createFile(myFilePath);
    }

    System.out.println("Create a copy of myfile.txt to root/data/subdir1/myfile-copy.txt");
    Path myFileCopyPath = subdir1Path.resolve("myfile-copy.txt");
      Files.copy(myFilePath, myFileCopyPath, StandardCopyOption.REPLACE_EXISTING);

    System.out.println("Create a copy of myfile.txt to root/data/subdir3/myfile-copy2.txt");
    Path myFileCopy2Path = subdir3Path.resolve("myfile-copy2.txt");
    if(Files.notExists(myFileCopy2Path)){
      Files.copy(myFilePath, myFileCopy2Path, StandardCopyOption.REPLACE_EXISTING);
    }
    System.out.println("Move nyfile-copy2.txt to root/data/subdir2/myfile-copy2.txt");
    Files.move(myFileCopy2Path, subdir2Path.resolve(myFileCopy2Path.getFileName()), StandardCopyOption.REPLACE_EXISTING);

    System.out.println("Delete myfile.txt");
    Files.deleteIfExists(myFilePath);

  }
}
