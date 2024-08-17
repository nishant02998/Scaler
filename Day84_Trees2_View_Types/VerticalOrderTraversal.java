package Day84_Trees2_View_Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

/*
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
 */

/*
 * /**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode() {}
*     TreeNode(int val) { this.val = val; }
*     TreeNode(int val, TreeNode left, TreeNode right) {
*         this.val = val;
*         this.left = left;
*         this.right = right;
*     }
* }
*/

/*
____Using Preorder_____________
class Solution {
   public List<List<Integer>> verticalTraversal(TreeNode root) {
       //Using Preorder
       HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
       traversal(root,0,map);
       List<Integer> keys = new ArrayList<>(map.keySet());
       Collections.sort(keys);
       List<List<Integer>> ans = new ArrayList<>();
       for(int key : keys) {
           ArrayList<Integer> al = new ArrayList<>();
           al = map.get(key);
           Collections.sort(al);
           ans.add(al);
       }
       return ans;
   }

   public void traversal(TreeNode node,int hd,HashMap<Integer,ArrayList<Integer>> map) {
       if(node == null) {
           return;
       }
       if(map.containsKey(hd)) {
           ArrayList<Integer> arr = map.get(hd);
           arr.add(node.val);
       }else {
           ArrayList<Integer> arr = new ArrayList<>();
           arr.add(node.val);
           map.put(hd,arr);
       }
       traversal(node.left,hd-1,map);
       traversal(node.right,hd+1,map);
   }
} 
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class pair {
    TreeNode node;
    int hd;
    int depth;

    pair(TreeNode node, int hd, int depth) {
        this.node = node;
        this.hd = hd;
        this.depth = depth;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<pair> qu = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        qu.offer(new pair(root, 0, 0));
        while (!qu.isEmpty()) {
            pair current = qu.poll();
            TreeNode node = current.node;
            int hd = current.hd;
            int depth = current.depth;
            if (!map.containsKey(hd)) {
                map.put(hd, new TreeMap<>());
            }
            if (!map.get(hd).containsKey(depth)) {
                map.get(hd).put(depth, new PriorityQueue<>());
            }
            map.get(hd).get(depth).offer(node.val);
            if (node.left != null) {
                qu.offer(new pair(node.left, hd - 1, depth + 1));
            }
            if (node.right != null) {
                qu.offer(new pair(node.right, hd + 1, depth + 1));
            }
        }
        for (TreeMap<Integer, PriorityQueue<Integer>> subMap : map.values()) {
            List<Integer> vertical = new ArrayList<>();
            for (PriorityQueue<Integer> pq : subMap.values()) {
                while (!pq.isEmpty()) {
                    vertical.add(pq.poll());
                }
            }
            ans.add(vertical);
        }
        return ans;
    }
}
