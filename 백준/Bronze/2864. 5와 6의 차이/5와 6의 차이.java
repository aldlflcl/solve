import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        System.out.print(calc(a, false) + calc(b, false) + " " + (calc(a, true) + calc(b, true)));
    }

    private static int calc(String s, boolean max) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (max) {
                if (s.charAt(i) == '5') sb.append('6');
                else sb.append(s.charAt(i));
            } else {
                if (s.charAt(i) == '6') sb.append('5');
                else sb.append(s.charAt(i));
            }
        }
        return Integer.valueOf(sb.toString());
    }
}
