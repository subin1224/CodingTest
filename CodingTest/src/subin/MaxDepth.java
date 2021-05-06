package subin;

public class MaxDepth {
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	
	public int maxDepth(TreeNode root) {
        /*
        https://leetcode.com/problems/maximum-depth-of-binary-tree/
        Easy - Tree
        return depth
        
        => Tree 문제는 웬만하면 재귀함수를 쓴다.
        */
		if(root == null) return 0;
		
		return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
