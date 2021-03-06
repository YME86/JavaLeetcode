import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (53.92%)
 * Likes:    168
 * Dislikes: 0
 * Total Accepted:    40.3K
 * Total Submissions: 74.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回锯齿形层次遍历如下：
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> tempQueue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        boolean reverse = false;
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                temp = queue.poll();
                if (temp != null) {
                    tempQueue.offer(temp.left);
                    tempQueue.offer(temp.right);
                    if (reverse) {
                        list.add(0, temp.val);
                    } else {
                        list.add(temp.val);
                    }
                }
            }
            if (!list.isEmpty()) {
                lists.add(list);
            }
            queue.addAll(tempQueue);
            reverse = !reverse;
            tempQueue.clear();
        }
        return lists;
    }
}
// @lc code=end
// @lc code=end
