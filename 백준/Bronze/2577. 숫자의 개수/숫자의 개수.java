import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int result = 1;
        for (int i = 0; i < 3; i++) {
            int n = Integer.valueOf(br.readLine());
            result *= n;
        }
        while (result > 0) {
            arr[result % 10]++;
            result /= 10;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
