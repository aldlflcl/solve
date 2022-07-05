import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        if (s.length() == 0) {
            System.out.println(0);
            return;
        }
        int count = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == ' ') {
                count++;
            }
        }
        System.out.println(++count);
    }
}