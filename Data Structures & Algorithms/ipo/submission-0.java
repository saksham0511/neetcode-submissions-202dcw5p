class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < n && arr[j][0] <= w) {
                pq.offer(arr[j][1]);
                j += 1;
            }
            if (pq.isEmpty()) {
                break;
            }
            w += pq.poll();
        }
        return w;
    }
}