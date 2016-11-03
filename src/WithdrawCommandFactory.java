import java.util.Vector;

/**
 * Created by nanasemaru on 3/11/2016.
 */
public class WithdrawCommandFactory extends Factory {
    Vector record;

    public void setRecord(Vector record) {
        this.record = record;
    }

    public Command create() {
        return new WithdrawCommand(record);
    }
}
