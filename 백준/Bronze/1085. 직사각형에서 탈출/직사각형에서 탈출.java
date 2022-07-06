import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int x = Integer.valueOf(arr[0]);
        int y = Integer.valueOf(arr[1]);
        int w = Integer.valueOf(arr[2]);
        int h = Integer.valueOf(arr[3]);

        int cx = x;
        int cy = y;
        if (x > w - x) {
            cx = w - x;
        }
        if (y > h - y) {
            cy = h - y;
        }
        if (cx < cy) System.out.print(cx);
        else System.out.println(cy);
    }
}
