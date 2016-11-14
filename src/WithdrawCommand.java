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
    private boolean isSuccess = false;

    public WithdrawCommand(Security security, String code, int quantity) {
        this.security = security;
        this.code = code;
        this.quantity = quantity;

    }

    public void execute() {
        int newQuantity;
        if ((security.getQuantity() - quantity)>0) {
            memento = new Memento(security);
            newQuantity = security.getQuantity() - quantity;
            security.setQuantity(newQuantity);
            if (!isSuccess)
                System.out.println("Deposited " + quantity + " to " + code +
                    ". Current quantity is " + newQuantity + ".\n");
            isSuccess = true;
        }
        else {
            System.out.println("Invalid quantity (current quantity < withdrawal quantity).\n");
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
        return "Withdraw " + quantity  + " " + security.getCode();
    }
}