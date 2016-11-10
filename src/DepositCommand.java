import Portfolio.Security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 3/11/2016.
 */
public class DepositCommand implements UndoableCommand {
    private Security security;
    private int quantity;
    private Memento memento;

    public DepositCommand(Security security, int quantity) {
        this.security = security;
        this.quantity = quantity;
        memento = new Memento();
    }

    public void execute() {
        try {
            memento.setQuantity(quantity);
            int newQuantity = security.getQuantity() + quantity;
            security.setQuantity(newQuantity);
            System.out.println("Deposited " + quantity + " to " + security.getCode() +
                                ". Current quantity is " + newQuantity + ".\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void undo() {
        this.quantity = memento.getQuantity();
        security.setQuantity(security.getQuantity() - quantity);
    }

    public String toString() {
        return "Deposit " + quantity;
    }
}
