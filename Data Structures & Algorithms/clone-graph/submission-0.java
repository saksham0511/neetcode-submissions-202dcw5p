/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node newRoot = new Node(node.val);
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, newRoot);
        clone(node, newRoot, map);
        return newRoot;
    }

    public void clone(Node node, Node newNode, Map<Integer, Node> map) {
        for (Node child : node.neighbors) {
            if (map.get(child.val) == null) {
                map.put(child.val, new Node(child.val));
                clone(child, map.get(child.val), map);
            }
            newNode.neighbors.add(map.get(child.val));
        }
    }
}