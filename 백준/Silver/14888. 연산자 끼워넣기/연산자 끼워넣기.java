import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] op = new int[4];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.valueOf(st.nextToken());
        }
        Calc solution = new Calc(op, arr);
        solution.solution(arr[0], 1);
        System.out.println(solution.max);
        System.out.println(solution.min);
    }

    static class Calc {
        private final int[] op;

        private final int[] arr;

        private int max = Integer.MIN_VALUE;
        private int min = Integer.MAX_VALUE;

        public Calc(int[] op, int[] arr) {
            this.op = op;
            this.arr = arr;
        }

        public void solution(int result, int level) {
            if (level == arr.length) {
                max = Math.max(result, max);
                min = Math.min(result, min);
                return;
            }
            for (int i = 0; i < 4; i++) {
               if (op[i] == 0) continue;
               op[i]--;
               int next;
               if (i == 0) next = result + arr[level];
               else if (i == 1) next = result - arr[level];
               else if (i == 2) next = result * arr[level];
               else next = result / arr[level];
               solution(next, level + 1);
               op[i]++;
            }
        }
    }
}
