import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        File existingDir = new File(AbsolutePath.getDirectoryPath());
        File backupDir = new File("/Users/gazimkerimov/IdeaProjects/lesson5/backup");
        backupDir.mkdir();
        ArrayList<File> fileList = new ArrayList<>();
        for(File perm : existingDir.listFiles()){
            if(perm.isFile()) fileList.add(perm);
        }
        for(File ex : fileList){
            File backupFile = new File(backupDir.getAbsolutePath()+"/"+ex.getName());
            Files.copy(ex.toPath(),backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        Tree.print(existingDir,"",true);


    }
}
