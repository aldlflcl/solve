import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int result = 0;
        for (char c : arr) {
            result += Character.getNumericValue(c);
        }
        System.out.println(result);
    }
}
