/**
 * Created by nanasemaru on 10/11/2016.
 */
public class UndoCommand implements Command {
    Caretaker caretaker;

    public UndoCommand(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public void execute() {
        if (caretaker.getUndoList().size()!=0) {
            caretaker.undo();
            System.out.println("Undo completed");
        }
        else
            System.out.println("Cannot Undo");
    }
}
