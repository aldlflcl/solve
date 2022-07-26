import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Teacher {
        private final int x;
        private final int y;

        public Teacher(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean monitor(char[][] map) {
            int nx = x;
            int ny = y;
            while (nx != 0) {
                nx--;
                if (map[nx][ny] == 'O') break;
                if (map[nx][ny] == 'S') return true;
            }
            nx = x;
            while (nx < map.length - 1) {
                nx++;
                if (map[nx][ny] == 'O') break;
                if (map[nx][ny] == 'S') return true;
            }
            nx = x;
            while (ny != 0) {
                ny--;
                if (map[nx][ny] == 'O') break;
                if (map[nx][ny] == 'S') return true;
            }
            ny = y;
            while (ny < map.length - 1) {
                ny++;
                if (map[nx][ny] == 'O') break;
                if (map[nx][ny] == 'S') return true;
            }
            return false;
        }
    }

    static class Solution {
        private final List<Teacher> list;
        private final char[][] map;
        private final char[][] tmp;

        private boolean result = false;

        public Solution(List<Teacher> list, char[][] map) {
            this.list = list;
            this.map = map;
            this.tmp = new char[map.length][map.length];
        }

        public boolean solution() {
            dfs(0);
            return result;
        }

        public void dfs(int level) {
            if (level == 3) {
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map.length; j++) {
                        tmp[i][j] = map[i][j];
                    }
                }
                boolean monitor = true;
                for (Teacher t : list) {
                    if (t.monitor(map)) {
                       monitor = false;
                    };
                }
                if (monitor) result = true;
                return;
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if (map[i][j] == 'X') {
                        map[i][j] = 'O';
                        dfs(level + 1);
                        map[i][j] = 'X';
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        char[][] map = new char[n][n];
        List<Teacher> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') list.add(new Teacher(i, j));
            }
        }
        Solution solution = new Solution(list, map);
        boolean result = solution.solution();
        if (result) System.out.println("YES");
        else System.out.println("NO");;
    }

}
