import Portfolio.Security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class CreateCommand implements UndoableCommand {
    Vector record;
    Security security = null;
    String type;
    SecurityFactory securityFactory;
    Caretaker caretaker;

    public CreateCommand(Vector record, String type, Caretaker caretaker) {
        this.record = record;
        this.type = type;
        this.caretaker = caretaker;
    }

    public void execute() {
        try {
            if (security==null) {
                if (type.equals("bo")) {
                    securityFactory = new BondFactory();
                    security = securityFactory.create();
                } else if (type.equals("st")) {
                    securityFactory = new StockFactory();
                    security = securityFactory.create();
                } else {
                    System.out.println("No such type");
                }
            }
            if (security!=null) {
                record.add(security);
                //caretaker.add(this);
                System.out.println("New security record created.\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void undo() {
        record.remove(security);
    }

    public String toString() {
        return "Create " + security.getCode();
    }
}
