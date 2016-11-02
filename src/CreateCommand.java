import Portfolio.Bond;
import Portfolio.Security;
import Portfolio.Stock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class CreateCommand implements Command {
    Vector record;
    Security security;
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);

    public CreateCommand(Vector record) {
        this.record = record;
    }

    public void execute() {
        try {
            System.out.println("Enter security type(bo=bond/st=stock):");
            String type = br.readLine();
            if (type.equals("bo")) {
                System.out.println("Enter code, name and yield:");
                security = new Bond(br.readLine(), br.readLine(), Integer.parseInt(br.readLine()));
            } else if (type.equals("st")) {
                System.out.println("Enter code, name and stock exchange:");
                security = new Stock(br.readLine(), br.readLine(), br.readLine());
            }
            record.add(security);
            System.out.println("New security record created.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
