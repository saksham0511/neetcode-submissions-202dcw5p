class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        if (deads.contains("0000")) {
            return -1;
        }
        int count = 0;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        Set<String> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String curr = q.poll();
                if (curr.equals(target)) {
                    return count;
                }
                for (int j = 0; j < curr.length(); j++) {
                    char ch = curr.charAt(j);
                    for (int diff : new int[]{1, -1}) {
                        char newChar = (char) ((ch-'0'+10+diff)%10+'0');
                        StringBuilder s = new StringBuilder(curr);
                        s.setCharAt(j, newChar);
                        if (!deads.contains(s.toString()) && !visited.contains(s.toString())) {
                            q.offer(s.toString());
                            visited.add(s.toString());
                        }
                    }
                }
            }
            count += 1;
        }
        return -1;
    }
}