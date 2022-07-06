import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        for (String s : arr) {
            int a = Character.getNumericValue(s.charAt(0));
            int b = Character.getNumericValue(s.charAt(2));
            System.out.println(a + b);
        }
    }
}