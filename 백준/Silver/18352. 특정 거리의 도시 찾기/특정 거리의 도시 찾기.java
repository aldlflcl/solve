import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Integer>> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int k = Integer.parseInt(st.nextToken()); // 거리 정보
        int x = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
        int[] d = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            d[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        bfs(list, x, k, d);
    }

    public static void bfs(List<List<Integer>> list, int x, int k, int[] d) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        d[x] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);
                if (d[next] == -1) {
                    d[next] = d[now] + 1;
                    q.offer(next);
                }
            }
        }

        boolean flag = false;

        for (int i = 0; i < d.length; i++) {
            if (d[i] == k) {
                flag = true;
                System.out.println(i);
            }
        }

        if (!flag) System.out.print(-1);
    }
}
