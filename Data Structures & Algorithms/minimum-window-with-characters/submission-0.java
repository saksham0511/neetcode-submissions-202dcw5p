class Solution {
    public String minWindow(String s, String t) {
        int count = 0;
        Map<Character, Integer> countm = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            countm.putIfAbsent(t.charAt(i), 0);
            countm.put(t.charAt(i), countm.get(t.charAt(i))+1);
            count += 1;
        }
        int i = -1;
        int j = 0;
        int x = -1;
        int y = -1;
        while (j < s.length()) {
            countMap.putIfAbsent(s.charAt(j), 0);
            countMap.put(s.charAt(j), countMap.get(s.charAt(j)) + 1);
            if (countm.get(s.charAt(j)) != null && countMap.get(s.charAt(j)) <= countm.get(s.charAt(j))) {
                count -= 1;
            }
            while (count == 0) {
                if (x == -1 || j-i < y-x) {
                    x = i;
                    y = j;
                }
                i += 1;
                countMap.put(s.charAt(i), countMap.get(s.charAt(i)) - 1);
                if (countm.get(s.charAt(i)) != null && countMap.get(s.charAt(i)) < countm.get(s.charAt(i))) {
                    count += 1;
                }
            }
            j += 1;
        }
        if (y == -1) {
            return "";
        }
        return s.substring(x+1, y+1);
    }
}
