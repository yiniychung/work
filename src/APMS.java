/**
 * Created by nanasemaru on 2/11/2016.
 */
import java.util.*;
import java.io.*;

public class APMS {
    public static void main(String[]args) {
        String [] factoryName = {"CreateCommandFactory"};
        Factory [] factories = new Factory[factoryName.length];
        Command command = null;
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        try {
            for (int i=0;i<factories.length;i++) {
                factories[i] = (Factory)Class.forName(factoryName[i]).newInstance();
            }
            System.out.println("Advanced Security Management System");
            System.out.println("Please enter command: [n | s | d | w | c | u | r | l | q]");
            System.out.println("n = create security, s = show security, d = deposit security, " +
                    "w = withdraw security, u = undo, r = redo, l = list undo/redo, " +
                    "q = exit system\n");
            String input = br.readLine();
            switch (input) {
                case "n":
                    command = factories[0].create();
            }
            command.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
