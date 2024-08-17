package Day84_Trees2_View_Types;

//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> qu = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        qu.offer(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            Node ele = qu.peek();
            ans.add(ele.data);
            for (int i = 0; i < size; i++) {
                Node node = qu.poll();
                if (node.left != null) {
                    qu.add(node.left);
                }
                if (node.right != null) {
                    qu.add(node.right);
                }
            }
        }
        return ans;
    }
}
