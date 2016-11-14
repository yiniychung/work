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
    private boolean isSuccess = false;

    public DepositCommand(Security security, int quantity) {
        this.security = security;
        this.quantity = quantity;
    }

    public void execute() {
        try {
            memento = new Memento(security);
            int newQuantity = security.getQuantity() + quantity;
            security.setQuantity(newQuantity);
            if (!isSuccess)
                System.out.println("Deposited " + quantity + " to " + security.getCode() +
                                ". Current quantity is " + newQuantity + ".\n");
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void undo() {
        memento.restore();
    }

    @Override
    public boolean commandSuccess() {
        return isSuccess;
    }

    public String toString() {
        return "Deposit " + quantity + " " + security.getCode();
    }
}
