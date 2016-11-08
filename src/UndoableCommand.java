/**
 * Created by nanasemaru on 6/11/2016.
 */
public interface UndoableCommand extends Command {
    void execute();
    //TODO void undo();
}
