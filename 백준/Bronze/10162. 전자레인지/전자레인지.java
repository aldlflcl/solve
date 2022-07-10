import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        int ten = 0;
        int minute = 0;
        int fiveM = 0;
        if (t >= 300) {
            fiveM += t / 300;
            t = t % 300;
        }
        if (t >= 60) {
            minute += t / 60;
            t = t % 60;
        }
        if (t >= 10) {
            ten += t / 10;
            t = t % 10;
        }
        if (t != 0) System.out.print(-1);
        else System.out.print(fiveM + " " + minute + " " + ten);
    }
}
