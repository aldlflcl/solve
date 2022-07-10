import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int left = Integer.valueOf(st.nextToken());
            int mid = Integer.valueOf(st.nextToken());
            int right = Integer.valueOf(st.nextToken());
            System.out.println(Math.max(mid - left, right - mid) - 1);
        }
    }
}
