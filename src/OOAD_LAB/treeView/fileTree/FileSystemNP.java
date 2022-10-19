package OOAD_LAB.treeView.fileTree;

import OOAD_LAB.treeView.INameProvider;

import java.io.File;

public class FileSystemNP implements INameProvider {
    public String getName(Object o) {
        String path = (String) o;
        //get the last file name from the path
        String fileName = path.substring(path.lastIndexOf("\\") < 0 ? 0 : path.lastIndexOf("\\") + 1, path.length());
        String res = "";
        //if the file is a directory, do not add ""
        if (new File(path).isDirectory()) {
            res = res+fileName;
        }
        else {
            res = res+"\"" +fileName+"\"";

        }
        //add level
        res = res + " " + String.valueOf(path.split("\\\\").length-1);
        return res;
    }
}
