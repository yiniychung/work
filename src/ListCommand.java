import Portfolio.Security;

import java.util.Vector;

/**
 * Created by nanasemaru on 9/11/2016.
 */
public class ListCommand implements Command {
    Vector undoList, redoList; //save command

    public ListCommand(Vector undoList, Vector redoList) {
        this.undoList = undoList;
        this.redoList = redoList;
    }

    public void execute() {
        System.out.println("Undo List:");
        if (undoList != null) {
            for (int i = 0; i < undoList.size(); i++) {
                UndoableCommand command = (UndoableCommand) undoList.elementAt(i);
                System.out.println(command.toString());
            }
        } else {
            System.out.println("Empty");
        }
        System.out.println("\nRedo List:");
        if (redoList != null) {
            for (int i = 0; i < redoList.size(); i++) {
                UndoableCommand command = (UndoableCommand) redoList.elementAt(i);
                System.out.println(command.toString());
            }
        } else
            System.out.println("Empty");
    }
}
