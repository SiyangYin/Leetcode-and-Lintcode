import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String serialize(ArrayList<DirectedGraphNode> nodes) {
        if (nodes.isEmpty()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        dfs(nodes.get(0), sb);
        return sb.toString();
    }
    
    private void dfs(DirectedGraphNode node, StringBuilder sb) {
        sb.append(node.label).append(',');
        if (node.neighbors.isEmpty()) {
            return;
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setLength(sb.length() - 1);
        }
        sb.append('(');
        for (DirectedGraphNode neighbor : node.neighbors) {
            dfs(neighbor, sb);
        }
        
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setLength(sb.length() - 1);
        }
        sb.append(')');
    }
    
    public DirectedGraphNode deserialize(String s) {
        if (s.isEmpty()) {
            return null;
        }
        
        Deque<DirectedGraphNode> stack = new LinkedList<>();
        DirectedGraphNode root = null;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ArrayList<DirectedGraphNode> neighbors = stack.peek().neighbors;
                if (!neighbors.isEmpty()) {
                    stack.push(neighbors.get(neighbors.size() - 1));
                }
            } else if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                
                DirectedGraphNode node = new DirectedGraphNode(Integer.parseInt(s.substring(i, j)));
                i = j - 1;
                
                if (!stack.isEmpty()) {
                    stack.peek().neighbors.add(node);
                } else {
                    stack.push(node);
                }
            } else if (s.charAt(i) == ')') {
                root = stack.pop();
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        // DirectedGraphNode root = new DirectedGraphNode(1);
        // root.neighbors.add(new DirectedGraphNode(3));
        // root.neighbors.add(new DirectedGraphNode(2));
        // root.neighbors.add(new DirectedGraphNode(4));
        // root.neighbors.get(0).neighbors.add(new DirectedGraphNode(5));
        // root.neighbors.get(0).neighbors.add(new DirectedGraphNode(6));
        
        DirectedGraphNode root = new DirectedGraphNode(1);
        root.neighbors.add(new DirectedGraphNode(2));
        root.neighbors.add(new DirectedGraphNode(3));
        root.neighbors.add(new DirectedGraphNode(4));
        root.neighbors.add(new DirectedGraphNode(5));
        // root.neighbors.get(0).neighbors.add(new DirectedGraphNode(6));
        root.neighbors.get(0).neighbors.add(new DirectedGraphNode(7));
        root.neighbors.get(1).neighbors.add(new DirectedGraphNode(8));
        root.neighbors.get(1).neighbors.add(new DirectedGraphNode(9));
        // root.neighbors.get(2).neighbors.add(new DirectedGraphNode(11));
        // root.neighbors.get(2).neighbors.add(new DirectedGraphNode(12));
        root.neighbors.get(3).neighbors.add(new DirectedGraphNode(10));
        
        ArrayList<DirectedGraphNode> list = new ArrayList<>();
        list.add(root);
        String s = new Solution().serialize(list);
    
        System.out.println(s);
    
        DirectedGraphNode rot = new Solution().deserialize(s);
        System.out.println();
    }
}

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    
    public DirectedGraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }
}