import Portfolio.Bond;
import Portfolio.Security;
import Portfolio.Stock;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by nanasemaru on 8/11/2016.
 */
public class StockFactory extends SecurityFactory {
    public Security create() {
        Security security = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter code, name and yield:");
            security = new Stock(br.readLine(), br.readLine(), br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return security;
    }
}