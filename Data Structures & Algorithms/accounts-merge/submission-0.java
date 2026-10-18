class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<Integer, Set<String>> ans = new HashMap<>();
        List<List<String>> finalAns = new ArrayList<>();
        Map<String, Integer> accountMap = new HashMap<>();
        int[] par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (accountMap.get(accounts.get(i).get(j)) != null) {
                    union(accountMap.get(accounts.get(i).get(j)), i, par);
                } else {
                    accountMap.put(accounts.get(i).get(j), i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int parent = findPar(i, par);
            if (ans.get(parent) == null) {
                ans.put(parent, new HashSet<>());
            }
            ans.get(parent).addAll(accounts.get(i).subList(1, accounts.get(i).size()));
        }

        for (Map.Entry<Integer,Set<String>> entry : ans.entrySet()) {
            List<String> toAdd = new ArrayList<>();
            toAdd.add(accounts.get(entry.getKey()).get(0));
            toAdd.addAll(entry.getValue());
            finalAns.add(toAdd);
        }

        return finalAns;
    }

    private int findPar(int node, int[] par) {
        if (node == par[node]) {
            return node;
        }
        par[node] = findPar(par[node], par);
        return par[node];
    }

    private void union(int x, int y, int[] par) {
        int parX = findPar(x, par);
        int parY = findPar(y, par);
        par[parY] = parX;
    }
}