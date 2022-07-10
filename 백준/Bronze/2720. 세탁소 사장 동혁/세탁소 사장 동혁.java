import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }
        int[] currency = new int[]{25, 10, 5};
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            for (int j = 0; j < 3; j++) {
                System.out.print(num / currency[j] + " ");
                num %= currency[j];
            }
            System.out.println(num);
        }
    }
}
