import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int one = 0;
        int zero = 0;
        char tmp = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != tmp) {
                if (str.charAt(i) == '0') zero++;
                else one++;
                tmp = str.charAt(i);
            }
        }
        System.out.println(Math.min(one, zero));
    }
}