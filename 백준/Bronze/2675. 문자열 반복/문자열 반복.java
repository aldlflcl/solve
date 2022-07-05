import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        StringBuilder[] arr = new StringBuilder[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.valueOf(st.nextToken());
            String s = st.nextToken();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < c; k++) {
                    sb.append(s.charAt(j));
                }
            }
            arr[i] = sb;
        }
        for (StringBuilder sb : arr) {
            System.out.println(sb);
        }
    }
}
