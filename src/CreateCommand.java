import Portfolio.Bond;
import Portfolio.Security;
import Portfolio.Stock;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class CreateCommand implements Command {
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Security security;

    public void execute() {
        try {
            System.out.println("Enter security type(bo=bond/st=stock):");
            String type = br.readLine();
            if (type=="bo") {
                security = new Bond(br.readLine(), br.readLine(), Integer.parseInt(br.readLine()));
            } else if (type=="st") {
                security = new Stock(br.readLine(), br.readLine(), br.readLine());
            }
            System.out.println("New security record created.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
