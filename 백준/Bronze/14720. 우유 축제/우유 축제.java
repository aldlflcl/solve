import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
           arr[i] = Integer.valueOf(st.nextToken());
        }

        int[] c = new int[]{0, 1, 2};
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == c[count % 3]) {
               count++;
            }
        }
        System.out.print(count);
    }
}
