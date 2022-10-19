package OOAD_LAB.command.commands;

import OOAD_LAB.Model;
import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.command.Command;

public class OpenCommand extends Command{
    private Model model;
    private String fileName;
    public void execute() {
        model.loadBookmarkFromFile(fileName);
    }

    public OpenCommand(String fileName) {
        this.fileName = fileName;
        model = new Model(Bookmark.getInstance());
    }

    public OpenCommand(String fileName, Model model) {
        this.fileName = fileName;
        this.model = model;
    }
}
