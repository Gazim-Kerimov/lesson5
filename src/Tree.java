import java.io.File;

public class Tree {
    public static void print (File file, String indent, boolean isLast){
        System.out.print(indent);
        if(isLast){
            System.out.print("└ ");
            indent += "  ";
        }
        else{
            System.out.print("├ ");
            indent += "│  ";
        }
        System.out.println(file.getName());
        File[] files = file.listFiles();
        if(files == null){
            return;
        }

        int subDirTotal = 0;
        int fileTotal = 0;
        for(int i = 0; i < files.length; i++){
            if(files[i].isDirectory()){
                subDirTotal++;
            }
            fileTotal++;
        }
        int dirCount = 0;
        int fileCount = 0;
        for (int i = 0; i < files.length; i++){
            if(files[i].isDirectory()){
                print(files[i], indent, dirCount == subDirTotal -1);
                dirCount++;
                fileCount++;
            }
            else{
                print(files[i], indent, fileCount == fileTotal -1);
                fileCount++;
            }
        }
    }
}
