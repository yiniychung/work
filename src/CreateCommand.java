import Portfolio.Security;

import java.util.Vector;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class CreateCommand implements UndoableCommand {
    Vector record;
    Security security = null;
    String type;
    SecurityFactory securityFactory;
    Caretaker caretaker; //del
    boolean isSuccess = false;

    public CreateCommand(Vector record, String type, Caretaker caretaker) {
        this.record = record;
        this.type = type;
        this.caretaker = caretaker;
    }

    public void execute() {
        try {
            if (security==null) {
                if (type.equals("bo")) {
                    securityFactory = new BondFactory(record);
                    security = securityFactory.create();
                } else if (type.equals("st")) {
                    securityFactory = new StockFactory(record);
                    security = securityFactory.create();
                } else {
                    System.out.println("No such type\n");
                    return;
                }
            }
            if (security!=null) {
                record.add(security);
                if (!isSuccess)
                    System.out.println("New security record created.\n");
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void undo() {
        record.remove(security);
    }

    @Override
    public boolean commandSuccess() {
        return isSuccess;
    }

    public String toString() {
        return "Create " + security.getCode();
    }
}
