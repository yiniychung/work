import Portfolio.Bond;
import Portfolio.Security;
import Portfolio.Stock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class CreateCommand implements Command {
    Vector record;
    Security security;
    String type;
    SecurityFactory securityFactory;

    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);

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
            }
            record.add(security);
            System.out.println("New security record created.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
