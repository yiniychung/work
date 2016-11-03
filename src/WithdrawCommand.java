import Portfolio.Security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 3/11/2016.
 */
public class WithdrawCommand implements Command {
    Vector record;
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);

    public WithdrawCommand(Vector record) {
        this.record = record;
    }

    public void execute() {
        try {
            System.out.println("Enter code:");
            String code = br.readLine();
            for (int i=0;i<record.size();i++) {
                Security security = (Security) record.elementAt(i);
                if (code.equals(security.getCode())) {
                    System.out.println("Quantity to withdraw:");
                    int input = Integer.parseInt(br.readLine());
                    int quantity = security.getQuantity();
                    if ((quantity - input)>0)
                        quantity = security.getQuantity() - input;
                    else {
                        System.out.println("Invalid quantity (current quantity < withdrawal quantity).");
                        break;
                    }
                    security.setQuantity(quantity);
                    System.out.println("Deposited " + input + " to " + code +
                            ". Current quantity is " + quantity + ".\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
