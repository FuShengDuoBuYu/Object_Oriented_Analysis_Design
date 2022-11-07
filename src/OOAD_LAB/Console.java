package OOAD_LAB;

import java.util.Scanner;

import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.command.CommandStack;
import OOAD_LAB.command.commands.AddCommand;
import OOAD_LAB.command.commands.DeleteCommand;
import OOAD_LAB.command.commands.LsTreeCommand;
import OOAD_LAB.command.commands.OpenCommand;
import OOAD_LAB.command.commands.ReadBookmarkCommand;
import OOAD_LAB.command.commands.SaveCommand;
import OOAD_LAB.command.commands.ShowTreeCommand;

public class Console {

    private String currentFileName;

    public Console() {

    }

    //get the user input OOAD_LAB.command
    public void getUserCommand() {
        System.out.println("Welcome to the bookmark system!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String commandString = scanner.nextLine();
            //split the OOAD_LAB.command by space
            String[] commandItems = commandString.split(" ");
            //each case is the same as the UI button
            //add OOAD_LAB.command
            if (commandItems[0].contains("add")) {
                String[] commands = cutTheItem(commandItems.length==2?makeArrayToFour(commandItems):commandItems);
                CommandStack.execute(new AddCommand(commands));
            }
            //delete OOAD_LAB.command
            if (commandItems[0].contains("delete")) {
                CommandStack.execute(new DeleteCommand(cutTheItem(commandItems)));
            }
            //undo
            if (commandItems[0].equals("undo")) {
                CommandStack.undo();
            }
            //redo
            if (commandItems[0].equals("redo")) {
                CommandStack.redo();
            }
            //save
            if (commandItems[0].equals("save")) {
                String fileName = commandItems.length!=1?commandItems[1]:currentFileName;
                CommandStack.execute(new SaveCommand(fileName));
            }
            //open
            if (commandItems[0].equals("open")||commandItems[0].equals("bookmark")) {
                currentFileName = commandItems[1].substring(1, commandItems[1].length() - 1);
                CommandStack.execute(new OpenCommand(currentFileName));
            }
            //show-tree
            if (commandItems[0].equals("show-tree")) {
                CommandStack.execute(new ShowTreeCommand(Bookmark.getInstance()));
            }
            //ls-tree
            if (commandItems[0].equals("ls-tree")) {
                CommandStack.execute(new LsTreeCommand("./bookmark"));
            }
            //read OOAD_LAB.bookmark
            if(commandItems[0].equals("read-bookmark")) {
                CommandStack.execute(new ReadBookmarkCommand(cutTheItem(commandItems)[1]));
            }
            if (commandItems[0].contains("exit")) {
                break;
            }
        }
        scanner.close();
    }

    //cut the "" in each item
    private String[] cutTheItem(String[] items) {

        for (int i = 0; i < items.length; i++) {
            items[i] = items[i].contains("\"") ? items[i].substring(1, items[i].length() - 1) : items[i];
        }
        return items;
    }

    //make the array to 4 size
    private String[] makeArrayToFour(String[] items) {
        String[] res = new String[4];
        res[0] = items[0];
        res[1] = items[1];
        res[2] = "at";
        res[3] = "";
        return res;
    }

}
