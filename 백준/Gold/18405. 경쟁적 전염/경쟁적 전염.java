import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    
    static class Virus implements Comparable<Virus> {
        
        public int getLevel() {
            return level;
        }

        public int getSec() {
            return sec;
        }

        private int[] dx = {-1, 1, 0, 0};
        private int[] dy = {0, 0, -1, 1};
        private int level;
        private int x;
        private int y;
        private int sec;

        public Virus(int level, int x, int y, int sec) {
            this.level = level;
            this.x = x;
            this.y = y;
            this.sec = sec;
        }

        @Override
        public int compareTo(Virus o) {
            return this.level - o.level;
        }

        public List<Virus> diffusion(int[][] map) {
            List<Virus> list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[nx].length) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = level;
                        list.add(new Virus(level, nx, ny, sec + 1));
                    }
                }
            }
            return list;
        }

    }

    static class Solution {
        private final int[][] map;

        private final int targetX;
        private final int targetY;

        private final List<Virus> list;

        public Solution(int[][] map, int targetX, int targetY, List<Virus> list) {
            this.map = map;
            this.targetX = targetX;
            this.targetY = targetY;
            this.list = list;
        }

        public int calc(int second) {
            Collections.sort(list);
            Queue<Virus> q = new LinkedList<>(list);

            while (!q.isEmpty()) {
                Virus virus = q.poll();
                if (virus.getSec() == second) break;
                if (virus.getLevel() == 0) continue;
                List<Virus> diffusion = virus.diffusion(map);
                diffusion.stream().forEach(q::offer);
            }

            return map[targetX - 1][targetY - 1];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        List<Virus> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int level = Integer.valueOf(st.nextToken());
                Virus virus = new Virus(level, i, j, 0);
                map[i][j] = level;
                list.add(virus);
            }
        }
        st = new StringTokenizer(br.readLine());
        int second = Integer.valueOf(st.nextToken());
        int targetX = Integer.valueOf(st.nextToken());
        int targetY = Integer.valueOf(st.nextToken());
        Solution solution = new Solution(map, targetX, targetY, list);
        int result = solution.calc(second);
        System.out.println(result);
    }

}
