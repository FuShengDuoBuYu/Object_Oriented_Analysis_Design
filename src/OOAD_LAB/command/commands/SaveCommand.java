package OOAD_LAB.command.commands;

import OOAD_LAB.Model;
import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.command.Command;

public class SaveCommand extends Command{
    private Model model;
    private String fileName;
    public void execute() {
        model.saveBookmarkToFile(fileName);
    }

    public SaveCommand(String fileName) {
        this.fileName = fileName;
        model = new Model(Bookmark.getInstance());
    }
}
