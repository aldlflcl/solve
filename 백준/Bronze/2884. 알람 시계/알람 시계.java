import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.valueOf(st.nextToken());
        int min = Integer.valueOf(st.nextToken());

        if (min - 45 < 0) {
            min = 60 - 45 + min;
            hour--;
        } else min -= 45;

        if (hour < 0) {
            hour = 23;
        }
        System.out.print(hour + " " + min);
    }
}
