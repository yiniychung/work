import Portfolio.Bond;
import Portfolio.Security;
import Portfolio.Stock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 8/11/2016.
 */
public class StockFactory extends SecurityFactory {
    Vector record;

    public StockFactory(Vector record) {
        this.record = record;
    }

    public Security create() {
        Security security = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter code, name and yield:");
            String [] inputs = br.readLine().split(",");
            for (int i=0;i<record.size();i++) {
                security = (Security) record.elementAt(i);
                if (inputs[0].equals(security.getCode())) {
                    System.out.println("Code already exist");
                    return null;
                }
            }
            if (inputs.length==3)
                security = new Stock(inputs[0], inputs[1], inputs[2]);
            else
                System.out.println("Invalid input format\n");
        } catch (Exception e) {
            System.out.println("Invalid input\n");
            e.printStackTrace();
        }
        return security;
    }
}