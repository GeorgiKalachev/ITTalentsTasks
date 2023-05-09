package Files;

import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {


        File file = new File("joro.txt");
        //relative path
        File file2 = new File(".." + File.separator + "Module03" + File.separator + "src", "joro2");
        // absolute path
        File file3 = new File("C:" + File.separator + "Users" + File.separator +
                "User" + File.separator + "Desktop" + File.separator +
                "IdeaProjects" + File.separator + "Module03");

        boolean exists = file.exists();
        boolean exists2 = file2.exists();
        System.out.println(exists);
        System.out.println(exists2);

        //create files
        file.createNewFile();
        file2.createNewFile();


        boolean isFile = file.isFile();
        System.out.println(isFile);

        if (file3.isDirectory()) {
            File[] children = file3.listFiles();
            for (int i = 0; i < children.length; i++) {
                System.out.println(children[i].getName());
            }
        }

        System.out.println(searchFileInDir("", "joro2.txt"));

    }
    public static boolean searchFileInDir(String dirName, String fileName) {
        File dir = new File(dirName);

        if (!dir.exists()) {
            return false;
        }
        if (dir.isFile()) {
            return dir.getName().equals(fileName);
        }

        File[] files = dir.listFiles();
        if (files != null) {
            System.out.println("------ enter : " + dirName + " ------------");
            for (File file : files) {
                System.out.println(file.getName());
                if (file.isFile() && file.getName().equals(fileName)) {
                    return true;
                } else if (file.isDirectory()) {
                    if (searchFileInDir(file.getAbsolutePath(), fileName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
