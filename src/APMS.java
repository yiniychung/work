/**
 * Created by nanasemaru on 2/11/2016.
 */
import java.util.*;
import java.io.*;

public class APMS {
    public static void main(String[]args) {
        String [] factoryName = {"CreateCommandFactory", "DisplayCommandFactory", "DepositCommandFactory", "WithdrawCommandFactory"};
        Factory [] factories = new Factory[factoryName.length];
        Command command = null;
        Vector record = new Vector();
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        try {
            for (int i=0;i<factories.length;i++) {
                factories[i] = (Factory)Class.forName(factoryName[i]).newInstance();
                factories[i].setRecord(record);
            }
            while (true) {
                System.out.println("Advanced Security Management System");
                System.out.println("Please enter command: [n | s | d | w | c | u | r | l | q]");
                System.out.println("n = create security, s = show security, d = deposit security, " +
                        "w = withdraw security, u = undo, r = redo, l = list undo/redo, " +
                        "q = exit system\n");
                String input = br.readLine();
                switch (input) {
                    case "n":
                        command = factories[0].create();
                        break;
                    case "s":
                        command = factories[1].create();
                        break;
                    case "d":
                        command = factories[2].create();
                        break;
                    case "w":
                        command = factories[3].create();
                        break;
                    case "q":
                        System.out.println("Leaving System...");
                        System.exit(0);
                        break;
                    default:
                        break;
                }
                if (command!=null)
                    command.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
