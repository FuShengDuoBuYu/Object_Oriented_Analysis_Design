package OOAD_LAB;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIOUtil {
    public static final String FILE_PATH =System.getProperty("user.dir");
    public static void writeToFile(String content,String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try{
                System.out.println("File not exist,make a new one");
                System.out.println(file.getAbsolutePath());
                file.createNewFile();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println(file.getAbsolutePath());
        }
        //write the OOAD_LAB.bookmark to file
        try{
            FileWriter fw = new FileWriter(fileName, false);
            fw.write(content);
            fw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readFromFile(String fileName){
        //get the root path
        ArrayList<String> res = new ArrayList<>();
        //if not exist , make a file
        File file = new File(fileName);
        if (!file.exists()) {
            try{
                System.out.println("File not exist,make a new one");
                System.out.println(file.getAbsolutePath());
                file.createNewFile();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println(file.getAbsolutePath());
        }
        //read the OOAD_LAB.bookmark from file
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                res.add(scanner.nextLine());
            }
            scanner.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
