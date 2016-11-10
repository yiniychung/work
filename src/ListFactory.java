import java.util.Vector;

/**
 * Created by nanasemaru on 9/11/2016.
 */
public class ListFactory extends CommandFactory {
    Caretaker caretaker;

    public void setRecord(Vector record) {

    }

    public void setCareTaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public Command create() {
        return new ListCommand(caretaker.getUndoList(), caretaker.getRedoList());
    }
}
