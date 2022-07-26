import java.util.*;

class Solution {
    private int findIndex(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else count --;
            if (count == 0) return i;
        }
        return -1;
    }
    
    private boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(s.charAt(i));
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
    
    
    
    public String solution(String p) {
        String answer = "";
        if (p.length() == 0) return answer;
        int idx = findIndex(p);
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);
        if (isRight(u)) {
            return u + solution(v);
        } else {
            answer += "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1);
            String tmp = "";
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') tmp += ")";
                else tmp += "(";
            }
            answer += tmp;
        }
        
        return answer;
    }
}