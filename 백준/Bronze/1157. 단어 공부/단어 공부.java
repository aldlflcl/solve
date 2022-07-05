import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
     public static void main(String[] args) throws IOException {
        
        int[] arr = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        char[] cArr = s.toCharArray();

        for (char c : cArr) {
            arr[c - 65]++;
        }

        int max = 0;
        int second = 0;
        char result = ' ';

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                result = (char) (i + 65);
                max = arr[i];
            } else if (arr[i] > second) {
                second = arr[i];
            }
        }

        if (max == second) System.out.println('?');
        else System.out.println(result);
    }
}