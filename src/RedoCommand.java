/**
 * Created by nanasemaru on 10/11/2016.
 */
public class RedoCommand implements Command {
    Caretaker caretaker;

    public RedoCommand(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public void execute() {
        if (caretaker.getRedoList().size()!=0) {
            caretaker.redo();
            System.out.println("Redo completed");
        } else
            System.out.println("Cannot Redo");

    }
}
