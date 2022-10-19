package OOAD_LAB.command.commands;

import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.bookmark.BookmarkTest;
import OOAD_LAB.treeView.TreeViewer;
import OOAD_LAB.treeView.bookmarkTree.BookmarkCP;
import OOAD_LAB.treeView.bookmarkTree.BookmarkNP;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShowTreeCommandTest {
    //we need to chech the print ability of the treeViewer
    //thus we mock a tree structure to test the print ability
    @Test
    public void showTreeCommandTest() {
        Bookmark bookmark = BookmarkTest.initOpenBookmarkCommandTest();
        TreeViewer treeViewer = new TreeViewer(new BookmarkCP(), new BookmarkNP());
        ArrayList<Boolean> ifLastList = new ArrayList<>();
        ifLastList.add(true);
        ArrayList<String> printRes = treeViewer.printTree(bookmark,true,ifLastList);
//

//└──个人收藏
//    ├──课程
//    │   └──"elearning"
//    ├──参考资料
//    │   ├──"Markdown-Guide"
//    │   ├──函数式
//    │   │   └──"JFP"
//    │   └──面向对象
//    └──待阅读
//        └──"Category-Theory"

        ArrayList<String> expectRes = new ArrayList<>();
        expectRes.add("");
        expectRes.add("└──个人收藏");
        expectRes.add("    ├──课程");
        expectRes.add("    │   └──\"elearning\"");
        expectRes.add("    ├──参考资料");
        expectRes.add("    │   ├──\"Markdown-Guide\"");
        expectRes.add("    │   ├──函数式");
        expectRes.add("    │   │   └──\"JFP\"");
        expectRes.add("    │   └──面向对象");
        expectRes.add("    └──待阅读");
        expectRes.add("        └──\"Category-Theory\"");

        assert expectRes.equals(printRes);
    }
}
