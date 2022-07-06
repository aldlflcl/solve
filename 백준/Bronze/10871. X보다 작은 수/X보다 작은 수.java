import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.valueOf(br.readLine().split(" ")[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            if (Integer.valueOf(s) < x) {
                sb.append(s + " ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
