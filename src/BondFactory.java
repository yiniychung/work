import Portfolio.Bond;
import Portfolio.Security;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by nanasemaru on 8/11/2016.
 */
public class BondFactory extends SecurityFactory {
    public Security create() {
        Security security = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter code, name and yield:");
            security = new Bond(br.readLine(), br.readLine(), Float.valueOf(br.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return security;
    }
}
