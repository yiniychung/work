import Portfolio.Security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 3/11/2016.
 */
public class WithdrawCommandFactory extends CommandFactory {
    Vector record;


    public void setRecord(Vector record) {
        this.record = record;
    }

    @Override
    public void setCareTaker(Caretaker careTaker) {

    }

    public Command create() {
        Security security = null;
        String code = null;
        int quantity = 0;
        boolean getCode = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter code:");
            code = br.readLine();
            for (int i=0;i<record.size();i++) {
                security = (Security) record.elementAt(i);
                if (code.equals(security.getCode())) {
                    System.out.println("Quantity to withdraw:");
                    quantity = Integer.parseInt(br.readLine());
                    getCode = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getCode)
            return new WithdrawCommand(security, code, quantity);
        else {
            return null;
        }
    }
}
