import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.valueOf(st.nextToken());
            if (a > max) max = a;
            if (a < min) min = a;
        }
        System.out.print(min + " " + max);
    }
}
