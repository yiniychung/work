import Portfolio.Security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class CreateCommand implements UndoableCommand {
    Vector record;
    Security security;
    String type;
    SecurityFactory securityFactory;

    public CreateCommand(Vector record, String type) {
        this.record = record;
        this.type = type;
    }

    public void execute() {
        try {
            if (type.equals("bo")) {
                securityFactory = new BondFactory();
                security = securityFactory.create();
            } else if (type.equals("st")) {
                securityFactory = new StockFactory();
                security = securityFactory.create();
            } else {
                security = null;
            }
            record.add(security);
            System.out.println("New security record created.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Memento save() {
        return null;
    }

    public void restore() {

    }

    public String toString() {
        return "Create " + security.getCode();
    }
}
