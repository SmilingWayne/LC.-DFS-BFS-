/*

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    HashSet<TreeNode> visited = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        int k = K;
        buildMap(root, target);
        dfs(target, K, 0);
        return res;

        
    }
    public void dfs(TreeNode root, int K ,int n){
        if(n > K || root == null || visited.contains(root)){
            return ;
        }
        visited.add(root);
        if(n == K){
            res.add(root.val);
        }
        dfs(root.left, K, n + 1);
        dfs(root.right, K , n + 1);
        dfs(map.get(root), K , n + 1);
    }
    
    public void buildMap(TreeNode root, TreeNode target){
        if(root == target){
            return ;
        }
        if(root.left != null){
            map.put(root.left, root);
            buildMap(root.left , target);
        }
        if(root.right != null){
            map.put(root.right, root);
            buildMap(root.right, target);
        }
    }

}
