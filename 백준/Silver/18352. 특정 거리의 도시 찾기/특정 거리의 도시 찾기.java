import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Graph {

        private final List<List<Integer>> list = new ArrayList<>();
        private final int[] d;

        public Graph(int initialSize) {
            for (int i = 0; i <= initialSize; i++) {
                list.add(new ArrayList<>());
            }
            d = new int[initialSize + 1];
            Arrays.fill(d, -1);
        }

        public void put(int x, int y) {
            list.get(x).add(y);
        }

        public int[] find(int start, int k) {
            d[start] = 0;
            List<Integer> result = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);

            while (!q.isEmpty()) {
                start = q.poll();
                for (int i = 0; i < list.get(start).size(); i++) {
                    int dest = list.get(start).get(i);
                    if (d[dest] == -1) {
                        d[dest] = d[start] + 1;
                        q.offer(dest);
                        if (d[dest] == k) {
                            result.add(dest);
                        }
                    }
                }
            }
            return d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()); // 도시의 개수
        int m = Integer.valueOf(st.nextToken()); // 도로의 개수
        int k = Integer.valueOf(st.nextToken()); // 거리 정보
        int x = Integer.valueOf(st.nextToken()); // 출발 도시의 번호

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int dest = Integer.valueOf(st.nextToken());
            graph.put(start, dest);
        }

        int[] result = graph.find(x, k);

        boolean flag = false;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == k) {
                flag = true;
                System.out.println(i);
            }
        }
        if (!flag) System.out.println(-1);
    }
}
