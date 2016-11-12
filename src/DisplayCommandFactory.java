import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class DisplayCommandFactory extends CommandFactory {
    Vector record;

    public void setRecord(Vector record) {
        this.record = record;
    }

    @Override
    public void setCaretaker(Caretaker caretaker) {

    }

    public Command create() {
        String code = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            if (record.size()==0) {
                System.out.println("No security record\n");
                return null;
            }
            System.out.println("Enter code(## to show all)");
            code = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DisplayCommand(record, code);
    }
}
