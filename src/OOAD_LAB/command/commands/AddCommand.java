package OOAD_LAB.command.commands;

import java.util.Map;

import OOAD_LAB.Model;
import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.bookmark.MarkInfo;
import OOAD_LAB.bookmark.OperationParentNode;
import OOAD_LAB.command.Command;

public class AddCommand extends Command {

    private final Model model;
    private final String[] addCommand;
    private Map<OperationParentNode, ?> addRecord;

    public AddCommand(String[] addCommand) {
        this.addCommand = addCommand;
        this.model = new Model(Bookmark.getInstance());
    }

    public AddCommand(String[] addCommand, Model model) {
        this.addCommand = addCommand;
        this.model = model;
    }

    public void execute() {
        addRecord = model.addCommand(addCommand);
    }

    public void undo() {
        //to do the reverse operation
        if (addCommand[0].contains("title")) {
            Map<OperationParentNode, Bookmark> recoverRecord = (Map<OperationParentNode, Bookmark>) addRecord;
            for(OperationParentNode node : recoverRecord.keySet()) {
                model.undoFromAddTitle(node, recoverRecord.get(node));
            }
        }
        else {
            Map<OperationParentNode, MarkInfo> recoverRecord = (Map<OperationParentNode, MarkInfo>) addRecord;
            for(OperationParentNode node : recoverRecord.keySet()) {
                model.undoFromAddMark(node, recoverRecord.get(node));
            }
        }
    }
}
