class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        cars.sort((a, b) -> a.pos - b.pos);
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            double time = (double) (target-cars.get(i).pos) / cars.get(i).speed;
            while (!stack.isEmpty() && stack.peek() <= time) {
                stack.pop();
            }
            stack.push(time);
        }
        int ans = 0;
        while(!stack.isEmpty()) {
            stack.pop();
            ans += 1;
        }
        return ans;
    }
}

class Car {
    public int pos;
    public int speed;
    public Car(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
    }
}
