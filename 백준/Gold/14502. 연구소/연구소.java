import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Virus {
        private final int[][] map;
        private final int[][] tmp;

        private int count = 0;
        // 상 하 좌 우
        private static int[] dx = {-1, 1, 0, 0};
        private static int[] dy = {0, 0, -1, 1};

        public Virus(int[][] map) {
            this.map = map;
            tmp = new int[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    tmp[i][j] = map[i][j];
                }
            }
        }

        private void count() {
            int result = 0;
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < tmp[i].length; j++) {
                    if (tmp[i][j] == 0) result++;
                }
            }
            count = Math.max(count, result);
        }

        public int getResult(int level) {
           calc(level);
           return this.count;
        }

        private void calc(int level) {
           if (level == 0) {
               for (int i = 0; i < tmp.length; i++) {
                   for (int j = 0; j < tmp[i].length; j++) {
                       tmp[i][j] = map[i][j];
                   }
               }

               for (int i = 0; i < tmp.length; i++) {
                   for (int j = 0; j < tmp[i].length; j++) {
                       if (tmp[i][j] == 2) {
                           diffusion(i, j);
                       }
                   }
               }
               count();
               return;
           }

           for (int i = 0; i < tmp.length; i++) {
               for (int j = 0; j < tmp[i].length; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        calc(level - 1);
                        map[i][j] = 0;
                    }
               }
           }
        }

        private void diffusion(int x, int y) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[nx].length) continue;
                if (tmp[nx][ny] == 0) {
                    tmp[nx][ny] = 2;
                    diffusion(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        Virus virus = new Virus(arr);
        int result = virus.getResult(3);
        System.out.println(result);
    }
}
