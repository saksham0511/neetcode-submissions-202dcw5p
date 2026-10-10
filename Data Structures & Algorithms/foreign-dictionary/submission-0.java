class Solution {
    public String foreignDictionary(String[] words) {
        int[] present = new int[26];
        int[] recur = new int[26];
        Map<Character, List<Character>> graph = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        if (words.length == 1) {
            return words[0];
        }
        for (int i = 0; i < words.length-1; i++) {
            if (createEdge(words[i], words[i+1], graph, present) == false) {
                return "";
            }
        }
        for (int i = 0; i < 26; i++) {
            if (present[i] == 1) {
                present[i] -= 1;
                recur[i] = 1;
                if (dfs(graph, (char) (i+'a'), recur, present, ans) == false) {
                    return "";
                }
                ans.append((char) ('a'+i));
                recur[i] = 0;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (present[i] == 1) {
                ans.append((char) ('a'+i));
            }
        }
        return ans.toString();
    }

    private boolean createEdge(String a, String b, Map<Character, List<Character>> graph, int[] present) {
        int n = a.length();
        int m = b.length();
        for (int i = 0; i < n; i++) {
            present[a.charAt(i)-'a'] = 1;
        }
        for (int i = 0; i < m; i++) {
            present[b.charAt(i)-'a'] = 1;
        }
        n = Math.min(m, n);
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                graph.putIfAbsent(b.charAt(i), new ArrayList<>());
                graph.get(b.charAt(i)).add(a.charAt(i));
                return true;
            }
        }
        if (a.length() > b.length()) {
            return false;
        }
        return true;
    }

    private boolean dfs(Map<Character,List<Character>> graph, Character curr, int[] recur, int[] present, StringBuilder ans) {
        if (graph.get(curr) == null) {
            return true;
        }
        for (Character ch : graph.get(curr)) {
            if (recur[ch-'a'] == 1) {
                return false;
            }
            recur[ch-'a'] = 1;
            if (present[ch-'a'] == 1) {
                present[ch-'a'] = 0;
                if (dfs(graph, ch, recur, present, ans) == false) {
                    return false;
                }
                ans.append(ch);
            }
            recur[ch-'a'] = 0;
        }
        return true;
    }
}
