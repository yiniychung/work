import java.util.Vector;

/**
 * Created by nanasemaru on 3/11/2016.
 */
public class Caretaker {
    //save the undoable command
    private Vector<UndoableCommand> undoList, redoList;

    public Caretaker() {
        undoList = new Vector();
        redoList = new Vector();
    }

    public void add(UndoableCommand command) {
        undoList.add(command);
        if (redoList.size()>0)
            redoList.clear();
    }

    public void undo() {
        undoList.lastElement().undo();
        redoList.add(undoList.lastElement());
        undoList.removeElement(undoList.lastElement());
    }

    public void redo() {
        redoList.lastElement().execute();
        undoList.add(redoList.lastElement());
        redoList.removeElement(redoList.lastElement());
    }

    public Vector getUndoList() {
        return undoList;
    }

    public Vector getRedoList() {
        return redoList;
    }
}