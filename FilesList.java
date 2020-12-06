import java.io.File;

public class FilesList{
  public static void listFiles(String startDir){
    File dir = new File(startDir);
    File[] files = dir.listFiles();

    if(files.length > 0 && files != null){
      for(File file : files){
        if(file.isDirectory()){
          listFiles(file.getAbsolutePath());
        }else{
          System.out.println(file.getName());
        }
      }
    }
  }

  public static void main(String[] args){
    String filePath = args[0];
    listFiles(filePath);
  }
}
