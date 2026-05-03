class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.dist - a.dist);
        for (int i = 0; i < k; i++) {
            pq.offer(new Node(points[i][0], points[i][1]));
        }
        for (int i = k; i < points.length; i++) {
            Node node = new Node(points[i][0], points[i][1]);
            if (node.dist < pq.peek().dist) {
                pq.poll();
                pq.offer(node);
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Node node = pq.poll();
            ans[i][0] = node.x;
            ans[i][1] = node.y;
        }
        return ans;
    }

    class Node {
        int x;
        int y;
        int dist;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = x*x + y*y;
        }
    }
}
