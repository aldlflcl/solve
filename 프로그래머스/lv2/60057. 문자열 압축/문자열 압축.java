class Solution {
            public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String prev = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int j = i; j <= s.length(); j += i) {
                String target = s.substring(j, Math.min(j + i, s.length()));
                if (prev.equals(target)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    prev = target;
                    count = 1;
                }
            }
            if (count >= 2) {
                sb.append(count).append(prev);
            } else sb.append(prev);
            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }



}