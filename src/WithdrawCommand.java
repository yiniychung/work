import Portfolio.Security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 3/11/2016.
 */
public class WithdrawCommand implements UndoableCommand {
    String code;
    int quantity;
    Security security;
    Memento memento;

    public WithdrawCommand(Security security, String code, int quantity) {
        this.security = security;
        this.code = code;
        this.quantity = quantity;
        memento = new Memento();
    }

    public void execute() {
        int newQuantity;
        if ((security.getQuantity() - quantity)>0) {
            memento.setQuantity(quantity);
            newQuantity = security.getQuantity() - quantity;
            security.setQuantity(newQuantity);
            System.out.println("Deposited " + quantity + " to " + code +
                    ". Current quantity is " + newQuantity + ".\n");
        }
        else {
            System.out.println("Invalid quantity (current quantity < withdrawal quantity).");
        }
    }

    public void undo() {
        this.quantity = memento.getQuantity();
        security.setQuantity(security.getQuantity() + quantity);
    }

    public String toString() {
        return "Withdraw " + quantity;
    }
}
