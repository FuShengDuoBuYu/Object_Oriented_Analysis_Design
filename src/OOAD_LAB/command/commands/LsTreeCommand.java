package OOAD_LAB.command.commands;

import OOAD_LAB.command.Command;
import OOAD_LAB.treeView.TreeViewer;
import OOAD_LAB.treeView.fileTree.FileSystemCP;
import OOAD_LAB.treeView.fileTree.FileSystemNP;

import java.util.ArrayList;

public class LsTreeCommand extends Command{
    public void execute() {
        TreeViewer fileSystemTreeViewer = new TreeViewer(new FileSystemCP(), new FileSystemNP());
        ArrayList<Boolean> ifLastList = new ArrayList<>();
        ifLastList.add(false);
        fileSystemTreeViewer.printTree(".",true,ifLastList);
    }
}
