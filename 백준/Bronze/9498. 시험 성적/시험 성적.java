import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        char c = ' ';
        if (n >= 90) c = 'A';
        else if (n >= 80) c = 'B';
        else if (n >= 70) c = 'C';
        else if (n >= 60) c = 'D';
        else c = 'F';
        System.out.print(c);
    }
}
