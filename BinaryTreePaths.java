import java.util.*;

public class BinaryTreePaths {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        findPaths(root, "", result);

        return result;
    }

    private static void findPaths(TreeNode node, String path, List<String> result) {

        if (node == null) {
            return;
        }

        if (path.equals("")) {
            path = String.valueOf(node.val);
        } else {
            path = path + "->" + node.val;
        }

        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        findPaths(node.left, path, result);
        findPaths(node.right, path, result);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);

        List<String> result = binaryTreePaths(root);

        System.out.println(result);
    }
}