package OOAD_LAB.command.commands;

import OOAD_LAB.command.Command;
import OOAD_LAB.treeView.TreeViewer;
import OOAD_LAB.treeView.fileTree.FileSystemCP;
import OOAD_LAB.treeView.fileTree.FileSystemNP;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LsTreeCommand extends Command{

    String path = null;
    public void execute() {
        TreeViewer fileSystemTreeViewer = new TreeViewer(new FileSystemCP(), new FileSystemNP());
        ArrayList<Boolean> ifLastList = new ArrayList<>();
        ifLastList.add(false);
        ifLastList.add(true);
        fileSystemTreeViewer.printTree(path,true,ifLastList);
    }

    public LsTreeCommand(String path){
        this.path = path;
    }

    public ArrayList<String> execute(ArrayList<String> printRes){
        TreeViewer fileSystemTreeViewer = new TreeViewer(new FileSystemCP(), new FileSystemNP());
        ArrayList<Boolean> ifLastList = new ArrayList<>();
        ifLastList.add(false);
        printRes = fileSystemTreeViewer.printTree(path,true,ifLastList);
        return printRes;
    }
}
