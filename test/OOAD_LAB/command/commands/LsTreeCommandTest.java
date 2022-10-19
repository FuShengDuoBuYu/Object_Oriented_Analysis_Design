package OOAD_LAB.command.commands;

import OOAD_LAB.treeView.TreeViewer;
import OOAD_LAB.treeView.fileTree.FileSystemCP;
import OOAD_LAB.treeView.fileTree.FileSystemNP;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LsTreeCommandTest {

    //we need to chech the print ability of the treeViewer of ls
    @Test
    public void lsTreeCommandTest() {
//        TreeViewer fileSystemTreeViewer = new TreeViewer(new FileSystemCP(), new FileSystemNP());
//        ArrayList<Boolean> ifLastList = new ArrayList<>();
//        ifLastList.add(false);
//        ArrayList<String> printRes = fileSystemTreeViewer.printTree("\\test\\command",true,ifLastList);
        TreeViewer fileSystemTreeViewer = new TreeViewer(new FileSystemCP(), new FileSystemNP());
        ArrayList<Boolean> ifLastList = new ArrayList<>();
        ifLastList.add(false);
        ArrayList<String> printRes = fileSystemTreeViewer.printTree("test",true,ifLastList);
        ArrayList<String> expectRes = new ArrayList<>();
//        test
//└──OOAD_LAB
//    ├──bookmark
//    │   └──"BookmarkTest.java"
//    ├──command
//    │   ├──commands
//    │   │   ├──"AddCommandTest.java"
//    │   │   ├──"DeleteCommandTest.java"
//    │   │   ├──"LsTreeCommandTest.java"
//    │   │   ├──"OpenCommandTest.java"
//    │   │   ├──"ReadBookmarkCommandTest.java"
//    │   │   ├──"ShowTreeCommandTest.java"
//    │   │   └──"test.bmk"
//    │   └──"CommandStackTest.java"
//    └──"ConsoleTest.java"
        expectRes.add("test");
        expectRes.add("└──OOAD_LAB");
        expectRes.add("    ├──bookmark");
        expectRes.add("    │   └──\"BookmarkTest.java\"");
        expectRes.add("    ├──command");
        expectRes.add("    │   ├──commands");
        expectRes.add("    │   │   ├──\"AddCommandTest.java\"");
        expectRes.add("    │   │   ├──\"DeleteCommandTest.java\"");
        expectRes.add("    │   │   ├──\"LsTreeCommandTest.java\"");
        expectRes.add("    │   │   ├──\"OpenCommandTest.java\"");
        expectRes.add("    │   │   ├──\"ReadBookmarkCommandTest.java\"");
        expectRes.add("    │   │   ├──\"ShowTreeCommandTest.java\"");
        expectRes.add("    │   │   └──\"test.bmk\"");
        expectRes.add("    │   └──\"CommandStackTest.java\"");
        expectRes.add("    └──\"ConsoleTest.java\"");

        assert printRes.equals(expectRes);
    }
}
