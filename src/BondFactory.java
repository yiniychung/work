import Portfolio.Bond;
import Portfolio.Security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 8/11/2016.
 */
public class BondFactory extends SecurityFactory {
    private Vector record;

    public BondFactory(Vector record) {
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
                    System.out.println("Code already existed");
                    return null;
                }
            }
            if (inputs.length==3)
                security = new Bond(inputs[0], inputs[1], Float.valueOf(inputs[2]));
            else
                System.out.println("Invalid input format\n");
        } catch (Exception e) {
            System.out.println("Invalid input\n");
            //e.printStackTrace();
        }
        return security;
    }
}