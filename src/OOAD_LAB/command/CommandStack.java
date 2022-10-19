package OOAD_LAB.command;

import OOAD_LAB.command.commands.AddCommand;
import OOAD_LAB.command.commands.DeleteCommand;

import java.util.Stack;


public class CommandStack{
    //undo stack ,use for executing
    private static Stack<Command> unStack = new Stack<>();
    //redo stack ,use for undo
    private static Stack<Command> reStack = new Stack<>();

    public static int getUnStackSize(){
        return unStack.size();
    }

    public static int getReStackSize(){
        return reStack.size();
    }

    public static void execute(Command command) {
        command.execute();
        //if the OOAD_LAB.command is add or delete ,we need to suport OOAD_LAB.command redo and undo
        if (command instanceof AddCommand || command instanceof DeleteCommand) {
            reStack.push(command);
            //if can still redo,we need to clear the redo stack
            if (unStack.size() > 0) {
                unStack.clear();
            }
        }
    }

    public static void undo() {
        if(!reStack.isEmpty()) {
            Command command = reStack.pop();
            command.undo();
            unStack.push(command);
        }
        else{
            System.out.println("Can not undo");
        }
    }

    public static void redo() {
        if(!unStack.isEmpty()) {
            Command command = unStack.pop();
            command.execute();
            reStack.push(command);
        }
        else{
            System.out.println("Can not redo");
        }
    }
}
