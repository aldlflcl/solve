import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        int result = solution(n, 0, 0, 0, arr);

        if (result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);
    }

    static int solution(int n, int count, int three, int five, int[][] arr) {
        if (n < 0) return Integer.MAX_VALUE;

        if (n == 0) {
            return count;
        }

        if (arr[three][five] != Integer.MAX_VALUE) return arr[three][five];

        int a = solution(n - 3, count + 1, three + 1, five, arr);

        int b = solution(n - 5, count + 1, three, five + 1, arr);

        return arr[three][five] = min(a, b);
    }
}
