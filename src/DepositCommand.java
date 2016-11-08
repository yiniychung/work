import Portfolio.Security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 3/11/2016.
 */
public class DepositCommand implements Command {
    private Security security;
    private int quantity;

    public DepositCommand(Security security, int quantity) {
        this.security = security;
        this.quantity = quantity;
    }

    public void execute() {
        try {
            int newQuantity = security.getQuantity() + quantity;
            security.setQuantity(quantity);
            System.out.println("Deposited " + quantity + " to " + security.getCode() +
                                ". Current quantity is " + newQuantity + ".\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
