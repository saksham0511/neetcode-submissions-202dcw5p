class PrefixTree {
    private Node root;

    public PrefixTree() {
         this.root = new Node();
    }

    public void insert(String word) {
        int n = word.length();
        Node temp = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (temp.nodes[c-'a'] == null) {
                temp.nodes[c-'a'] = new Node();
            }
            temp = temp.nodes[c-'a'];
            if (i == n-1) {
                temp.isLeaf = true;
            }
        }
    }

    public boolean search(String word) {
        return check(word, true);
    }

    public boolean startsWith(String prefix) {
        return check(prefix, false);
    }

    private boolean check(String word, boolean complete) {
        int n = word.length();
        Node temp = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (temp.nodes[c-'a'] != null) {
                temp = temp.nodes[c-'a'];
                if (i == n-1 && complete) {
                    return temp.isLeaf;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private class Node {
        Node[] nodes;
        boolean isLeaf;
        public Node() {
            nodes = new Node[26];
        }
    }
}
