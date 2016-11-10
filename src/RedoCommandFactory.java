import java.util.Vector;

/**
 * Created by nanasemaru on 10/11/2016.
 */
public class RedoCommandFactory extends CommandFactory {
    Caretaker caretaker;

    public void setRecord(Vector record) {

    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public Command create() {
        return new RedoCommand(caretaker);
    }
}
