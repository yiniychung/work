import Portfolio.Bond;
import Portfolio.Security;
import Portfolio.Stock;

import java.util.Vector;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class DisplayCommand implements Command {
    private Vector record;
    private String code;

    public DisplayCommand(Vector record, String code) {
        this.record = record;
        this.code = code;
    }

    public void execute() {
        if (code.equals("##")) {
            allPrint();
        } else {
            singlePrint(code);
        }
    }

    public void singlePrint(String code) {
        for (int i=0;i<record.size();i++) {
            Security security = (Security)record.elementAt(i);
            if (code.equals(security.getCode())) {
                System.out.println("Security information");
                System.out.println("Code: " + security.getCode());
                System.out.println("Name: " + security.getName());
                System.out.println("Quantity: " + security.getQuantity());
                System.out.println(security.toString());
            } else {
                System.out.println("No such code");
            }
        }
    }

    public void allPrint() {
        System.out.println("Security information");
        System.out.printf("%-10s %-30s %-10s %-20s\n", "Code", "Name", "Quantity", "Other Info");
        for (int i = 0; i < record.size(); i++) {
            Security security = (Security) record.elementAt(i);
            String code = security.getCode();
            String name = security.getName();
            int quantity = security.getQuantity();
            String other = security.toString();
            System.out.printf("%-10s %-30s %-10s %-20s\n", code, name, quantity, other);
        }
    }
}
