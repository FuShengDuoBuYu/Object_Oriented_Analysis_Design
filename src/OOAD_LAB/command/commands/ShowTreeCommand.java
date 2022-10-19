package OOAD_LAB.command.commands;

import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.command.Command;
import OOAD_LAB.treeView.TreeViewer;
import OOAD_LAB.treeView.bookmarkTree.BookmarkNP;
import OOAD_LAB.treeView.bookmarkTree.BookmarkCP;

import java.util.ArrayList;

public class ShowTreeCommand extends Command{

    private Bookmark bookmark;

    public void execute() {
        TreeViewer bookmarkTree = new TreeViewer(new BookmarkCP(), new BookmarkNP());
        ArrayList<Boolean> ifLastList = new ArrayList<>();
        ifLastList.add(true);
        bookmarkTree.printTree(bookmark,true,ifLastList);
    }

    public ShowTreeCommand(Bookmark bookmark) {
        this.bookmark = bookmark;
    }

}
