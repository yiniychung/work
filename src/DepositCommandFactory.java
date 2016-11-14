import Portfolio.Security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 3/11/2016.
 */
public class DepositCommandFactory extends CommandFactory {
    Vector record;

    public void setRecord(Vector record) {
        this.record = record;
    }

    @Override
    public void setCaretaker(Caretaker caretaker) {

    }

    public Command create() {
        Security security = null;
        int quantity = 0;
        boolean getCode = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter code:");
            String code = br.readLine();

            for (int i=0;i<record.size();i++) {
                security = (Security) record.elementAt(i);
                if (code.equals(security.getCode())) {
                    getCode = true;
                    System.out.println("Quantity to deposit:");
                    quantity = Integer.parseInt(br.readLine());
                    if (quantity<=0) {
                        System.out.println("Quantity must be positive integer.\n");
                        return null;
                    }
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Quantity must be positive integer.\n");
            return null;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        if (getCode)
            return new DepositCommand(security, quantity);
        else {
            System.out.println("No such code\n");
            return null;
        }
    }
}