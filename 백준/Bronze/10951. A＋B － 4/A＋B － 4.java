import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            String[] arr = input.split(" ");
            System.out.println(Integer.valueOf(arr[0]) + Integer.valueOf(arr[1]));
        }
    }
}
