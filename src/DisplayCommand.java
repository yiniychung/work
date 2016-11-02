import Portfolio.Bond;
import Portfolio.Security;
import Portfolio.Stock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class DisplayCommand implements Command {
    Vector record;
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);

    public DisplayCommand(Vector record) {
        this.record = record;
    }

    public void execute() {
        try {
            System.out.println("Enter code(## to show all)");
            String code = br.readLine();
            if (code.equals("##")) {
                allPrint();
            } else {
                singlePrint(code);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void singlePrint(String code) {
        for (int i=0;i<record.size();i++) {
            Security security = (Security)record.elementAt(i);
            if (code.equals(security.getCode())) {
                System.out.println("Security information");
                System.out.println("Code: " + security.getCode());
                System.out.println("Name: " + security.getName());
                System.out.println("Quantity: " + security.getQuantity());
                if (security instanceof Bond)
                    System.out.println("Yield: " + ((Bond) security).getYield());
                else if (security instanceof Stock)
                    System.out.println("Stock exchange: " + ((Stock) security).getExchange() + "\n");
            }
        }
    }
    public void allPrint() {
        System.out.println("Security information");
        System.out.printf("%-10s %-30s %-10s %-20s\n", "Code", "Name", "Quantity", "Other Info");
        for (int i=0;i<record.size();i++) {
            Security security = (Security)record.elementAt(i);
            String code = security.getCode();
            String name = security.getName();
            int quantity = security.getQuantity();
            String other = "";
            if (security instanceof Bond)
                other = "Yield: " + String.valueOf(((Bond) security).getYield());
            else if (security instanceof Stock)
                other = "Exchange: " + ((Stock) security).getExchange();
            System.out.printf("%-10s %-30s %-10s %-20s\n", code, name, quantity, other);
        }
    }
}
