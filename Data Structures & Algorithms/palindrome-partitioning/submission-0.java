class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(s, 0, ans, temp);
        return ans;
    }

    private void helper(String s, int start, List<List<String>> ans, List<String> temp){
        int n = s.length();
        if (start == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < n; i++) {
            if (checkPalindrome(s.substring(start,i+1))) {
                temp.add(s.substring(start, i+1));
                helper(s, i+1, ans, temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean checkPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
