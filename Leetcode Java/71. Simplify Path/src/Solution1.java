import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("/");
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (stack.isEmpty() || !stack.peek().equals("/")) {
                    stack.push("/");
                }
                continue;
            }
            else if (path.charAt(i) == '.') {
                if (i + 1 < path.length()) {
                    if (path.charAt(i + 1) == '/') {
                        continue;
                    }
                    else if (path.charAt(i + 1) == '.') {
                        if (i + 2 < path.length()) {
                            if (path.charAt(i + 2) == '/') {
                                pop2(stack);
                                i += 2;
                            }
                            else {
                                i = pushN(path, i, stack);
                            }
                        }
                        else {
                            pop2(stack);
                            i++;
                        }
                    }
                    else {
                        i = pushN(path, i, stack);
                    }
                }
            }
            else {
                i = pushN(path, i, stack);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '/') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public int pushN(String path, int i, Deque<String> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append(path.charAt(i));
        while (i + 1 < path.length() && path.charAt(i + 1) != '/') {
            sb.append(path.charAt(i + 1));
            i++;
        }
        stack.push(sb.toString());
        return i;
    }

    public void pop2(Deque<String> stack) {
        if (stack.size() > 2) {
            stack.pop();
            stack.pop();
        }
    }

    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        path = "/home//foo/";
        // path = "/home/";
        // path = "/a//b////c/d//././/..";
        // path = "/../";
        System.out.println(new Solution1().simplifyPath(path));
    }
}
