class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        queue.offer(beginWord);
        vis.add(beginWord);
        int ans = 1;
        while (queue.size() != 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return ans;
                }
                for (String word : wordList) {
                    if (!vis.contains(word) && isValid(curr, word)) {
                        vis.add(word);
                        queue.offer(word);
                    }
                }
            }
            ans += 1;
        }

        return 0;
    }

    private boolean isValid(String first, String second) {
        int count = 0;
        if (first.length() != second.length()) {
            return false;
        }
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count += 1;
                if (count >= 2) {
                    return false;
                }
            }
        }
        if (count == 0) {
            return false;
        }
        return true;
    }
}
