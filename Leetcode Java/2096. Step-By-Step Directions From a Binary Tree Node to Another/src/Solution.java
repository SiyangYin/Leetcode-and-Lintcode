import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private String firstHalf;
    private String secondHalf;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        findStart(root, startValue, new StringBuilder());
        findDest(root, destValue, new StringBuilder());
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < firstHalf.length() && i < secondHalf.length() && firstHalf.charAt(i) == secondHalf.charAt(i)) {
            i++;
        }
        for (int j = i; j < firstHalf.length(); j++) {
            res.append("U");
        }
        for (int j = i; j < secondHalf.length(); j++) {
            res.append(secondHalf.charAt(j));
        }
        return res.toString();
    }

    public void findStart(TreeNode node, int startValue, StringBuilder sb) {
        if (node != null) {
            if (node.val == startValue) {
                firstHalf = sb.toString();
                return;
            }
            sb.append("L");
            findStart(node.left, startValue, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append("R");
            findStart(node.right, startValue, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public void findDest(TreeNode node, int destValue, StringBuilder sb) {
        if (node != null) {
            if (node.val == destValue) {
                secondHalf = sb.toString();
                return;
            }
            sb.append("L");
            findDest(node.left, destValue, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append("R");
            findDest(node.right, destValue, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}