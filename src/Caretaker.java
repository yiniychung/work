import java.util.Vector;

/**
 * Created by nanasemaru on 3/11/2016.
 */
public class Caretaker {
    private Vector undoList, redoList;

    public Caretaker() {
        undoList = new Vector();
        redoList = new Vector();
    }

    public void add(UndoableCommand command) {
        undoList.add(command);
    }

    public void undo() {
        redoList.add(undoList.lastElement());
        undoList.removeElement(undoList.lastElement());
    }

    public void redo() {
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