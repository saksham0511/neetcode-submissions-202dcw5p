class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        int n = word.length();
        Node node = root;
        for (int i = 0; i < n; i++) {
            Node next = node.map.get(word.charAt(i));
            if (next == null) {
                next = new Node();
            }
            node.map.put(word.charAt(i), next);
            node = next;
            if (i == n-1) {
                next.isTerminal = true;
            }
        }
    }

    public boolean search(String word) {
        int n = word.length();
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int i, Node node) {
        int n = word.length();
        if (i == n && node != null && node.isTerminal == true) {
            return true;
        }
        if (i == n || node == null) {
            return false;
        }

        if (word.charAt(i) == '.') {
            for (int x = 0; x<26 ; x++) {
                if (dfs(word,i+1,node.map.get((char) ('a'+x)))) {
                    return true;
                }
            }
        } else {
            Node next = node.map.get(word.charAt(i));
            return dfs(word,i+1,next);
        }   
        return false;
    }

    class Node {
        Map<Character, Node> map;
        boolean isTerminal;
        public Node() {
            map = new HashMap<>();
            isTerminal = false;
        }
    }
}
