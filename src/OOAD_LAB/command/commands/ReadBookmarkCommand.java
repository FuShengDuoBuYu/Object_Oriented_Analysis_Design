package OOAD_LAB.command.commands;

import OOAD_LAB.Model;
import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.command.Command;

public class ReadBookmarkCommand extends Command{
    private Model model;
    private String bookmarkName;

    public void execute() {
        model.readBookmark(bookmarkName,model.getBookmark());
    }

    public ReadBookmarkCommand(String bookmarkName) {
        model = new Model(Bookmark.getInstance());
        this.bookmarkName = bookmarkName;
    }

    public ReadBookmarkCommand(String bookmarkName, Model model) {
//        System.out.println(bookmarkName);
        this.model = model;
        this.bookmarkName = bookmarkName;
    }
}
