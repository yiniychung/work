import java.util.Vector;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class DisplayCommandFactory extends Factory {
    Vector record;

    public void setRecord(Vector record) {
        this.record = record;
    }

    public Command create() {
        return new DisplayCommand(record);
    }
}
