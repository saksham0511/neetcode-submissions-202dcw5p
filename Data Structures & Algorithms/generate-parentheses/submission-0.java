class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        List<String> temp = new ArrayList();
        helper(n, 0, 0, ans, temp);
        return ans;
    }

    private void helper(int n, int open, int close, List<String> ans, List<String> temp) {
        if (close == n) {
            ans.add(String.join("", temp));
            return;
        }
        if (open < n) {
            temp.add("(");
            helper(n, open+1, close, ans, temp);
            temp.remove(temp.size()-1);
        }
        if (open > close) {
            temp.add(")");
            helper(n, open, close+1, ans, temp);
            temp.remove(temp.size()-1);
        }
    }
}
