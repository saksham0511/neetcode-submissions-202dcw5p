class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Chara> pq = new PriorityQueue<>((x, y) -> y.count - x.count);
        if (a > 0) {
            Chara ac = new Chara('a', a);
            pq.offer(ac);
        }
        if (b > 0) {
            Chara bc = new Chara('b', b);
            pq.offer(bc);
        }
        if (c > 0) {
            Chara cc = new Chara('c', c);
            pq.offer(cc);
        }  
        StringBuilder ans = new StringBuilder();
        int count = 0;
        Character last = null;
        while (pq.size() > 0) {
            Chara temp = null;
            Chara curr = pq.poll();
            if (curr.ch == last && count == 2) {
                count = 0;
                temp = curr;
                curr = pq.size() > 0 ? pq.poll() : null;
            }
            if (curr == null) {
                break;
            }
            if (last == curr.ch) {
                count += 1;
            } else {
                last = curr.ch;
                count = 1;
            }
            curr.count -= 1;
            ans.append(curr.ch);
            if (temp != null) {
                pq.offer(temp);
            }
            if (curr.count > 0) {
                pq.offer(curr);
            }
        }
        return ans.toString();
    }

    class Chara {
        Character ch;
        int count;
        public Chara(Character ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}