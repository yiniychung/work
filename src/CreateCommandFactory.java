import Portfolio.Bond;
import Portfolio.Stock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class CreateCommandFactory extends CommandFactory {
    Vector record;
    Caretaker caretaker;

    public void setRecord(Vector record) {
        this.record = record;
    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public Command create() {
        String type = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter security type(bo=bond/st=stock):");
            type = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CreateCommand(record, type, caretaker);
    }
}
