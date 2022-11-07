package OOAD_LAB.command;

import OOAD_LAB.command.commands.AddCommand;
import OOAD_LAB.command.commands.DeleteCommand;
import OOAD_LAB.command.commands.LsTreeCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandStackTest {

    @Test
    public void executeTest(){
        //we need to see after add / delete command executed,if the reStack grow
        Command addCommand = new AddCommand(new String[]{"add-title","OOAD","at",""});
        int initReStackSize = CommandStack.getReStackSize();
        CommandStack.execute(addCommand);
        assertEquals(++initReStackSize,CommandStack.getReStackSize());
        Command deleteCommand = new DeleteCommand(new String[]{"delete-title","OOAD","at",""});
        CommandStack.execute(deleteCommand);
        assertEquals(++initReStackSize,CommandStack.getReStackSize());
        //we need to see after not add/delete command executed,if the reStack not grow
        Command lsCommand = new LsTreeCommand("./bookmark");
        CommandStack.execute(lsCommand);
        assertEquals(initReStackSize,CommandStack.getReStackSize());
    }

    @Test
    public void undoAndRedoTest(){
        //we need to check the stack status
        Command addCommand = new AddCommand(new String[]{"add-title","OOAD","at",""});
        CommandStack.execute(addCommand);
        int reStackSize = CommandStack.getReStackSize();
        int unStackSize = CommandStack.getUnStackSize();
        //check undo
        CommandStack.undo();
        assertEquals(--reStackSize,CommandStack.getReStackSize());
        assertEquals(++unStackSize,CommandStack.getUnStackSize());
        //check redo
        CommandStack.redo();
        assertEquals(++reStackSize,CommandStack.getReStackSize());
        assertEquals(--unStackSize,CommandStack.getUnStackSize());
    }
}
