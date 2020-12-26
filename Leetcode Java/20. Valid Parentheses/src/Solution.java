public class Solution {
    public static void main(String[] args) {
        String s = "(]";
        System.out.println(new Solution().isValid(s));
    }
    
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack stack = new Stack(s.length());
        for (int i = 0; i < s.length(); ++i) {
            if (stack.top == -1) {
                if (isleft(s.charAt(i))) {
                    stack.push(s.charAt(i));
                }
                else {
                    return false;
                }
            }
            else {
                if (matches(stack.peek(), s.charAt(i))) {
                    stack.pop();
                }
                else {
                    stack.push(s.charAt(i));
                }
            }
        }
        
        if (stack.top == -1) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean matches(char c1, char c2) {
        if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isleft(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        } else {
            return false;
        }
    }
}

class Stack {
    private char[] arr;
    public int top;
    Stack(int n) {
        arr = new char[n];
        top = -1;
    }
    public char peek() {
        return arr[top];
    }
    public void pop() {
        top--;
    }
    public void push(char c) {
        arr[++top] = c;
    }
}