import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(count(arr[i]));
        }
    }

    private static int count(String str) {
        char[] arr = str.toCharArray();
        int acc = 0;
        int count = 0;
        for (char c : arr) {
            if (c == 'O') {
                count += (acc++ + 1);
            } else {
                acc = 0;
            }
        }
        return count;
    }
}
