import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int front = 0;
        int back = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            front += Integer.valueOf(s.charAt(i));
            back += Integer.valueOf(s.charAt(s.length() - i - 1));
        }
        if (front == back) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
