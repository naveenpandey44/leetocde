class Solution {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTree(postorder, 0, inorder.length - 1);
    }

    TreeNode buildTree(int[] postorder, int left, int right) {
        if (left > right) return null;
        
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);
        
        int inorderIndex = inorderMap.get(rootVal);
        
        root.right = buildTree(postorder, inorderIndex + 1, right);
        root.left = buildTree(postorder, left, inorderIndex - 1);
        
        return root;
    }        
}