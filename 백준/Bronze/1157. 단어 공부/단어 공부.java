import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chArr = br.readLine().toUpperCase().toCharArray();
        int[] arr = new int[26];
        for (char c : chArr) {
            arr[c - 65]++;
        }

        int max = Integer.MIN_VALUE;
        int c = '?';

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                c = i + 65;
            } else if (max == arr[i]) {
                c = '?';
            }
        }
        System.out.print((char)c);
    }

}