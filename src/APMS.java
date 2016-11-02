/**
 * Created by nanasemaru on 2/11/2016.
 */
import java.util.*;
import java.io.*;

public class APMS {
    public static void main(String[]args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println("Advanced Security Management System");
        System.out.println("Please enter command: [n | s | d | w | c | u | r | l | q]");
        System.out.println("n = create security, s = show security, d = deposit security, " +
                            "w = withdraw security, u = undo, r = redo, l = list undo/redo, " +
                            "q = exit system\n");
        String command = br.readLine();
    }
}
