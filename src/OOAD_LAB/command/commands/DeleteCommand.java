package OOAD_LAB.command.commands;

import java.util.Map;

import OOAD_LAB.Model;
import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.bookmark.MarkInfo;
import OOAD_LAB.bookmark.OperationParentNode;
import OOAD_LAB.command.Command;

public class DeleteCommand extends Command{
    private Model model;
    private String[] deleteCommand;
    private Map<OperationParentNode, ?> deleteRecord;

    public void execute() {
        deleteRecord = model.deleteCommand(deleteCommand);
    }

    public DeleteCommand(String[] deleteCommand) {
        model = new Model(Bookmark.getInstance());
        this.deleteCommand = deleteCommand;
    }

    public DeleteCommand(String[] deleteCommand, Model model) {
        this.model = model;
        this.deleteCommand = deleteCommand;
    }

    public void undo() {
        //recovery title
        if (deleteCommand[0].contains("title")) {
            Map<OperationParentNode, Bookmark> recoverRecord = (Map<OperationParentNode, Bookmark>) deleteRecord;
            for(OperationParentNode node : recoverRecord.keySet()) {
                model.undoFromDeleteTitle(node, recoverRecord.get(node));
            }
        }
        //recovery OOAD_LAB.bookmark
        if (deleteCommand[0].contains("bookmark")) {
            Map<OperationParentNode, MarkInfo> recoverRecord = (Map<OperationParentNode, MarkInfo>) deleteRecord;
            for(OperationParentNode node : recoverRecord.keySet()) {
                model.undoFromDeleteMark(node, recoverRecord.get(node));
            }
        }
    }
}
