import java.util.*;

class State {
    int jug1;
    int jug2;
    List<String> path;

    State(int jug1, int jug2, List<String> path) {
        this.jug1 = jug1;
        this.jug2 = jug2;
        this.path = new ArrayList<>(path);
    }
}

public class WaterJugProblem {
    public static List<String> solve(int jug1Capacity, int jug2Capacity, int target) {
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        State initialState = new State(0, 0, new ArrayList<>());
        queue.offer(initialState);

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            int x = currentState.jug1;
            int y = currentState.jug2;

            if (x == target || y == target) {
                currentState.path.add("(" + x + ", " + y + ")");
                return currentState.path;
            }

            String stateKey = x + "," + y;
            if (visited.contains(stateKey)) {
                continue;
            }

            visited.add(stateKey);
            currentState.path.add("(" + x + ", " + y + ")");

            // Fill jug1
            if (x < jug1Capacity) {
                queue.offer(new State(jug1Capacity, y, currentState.path));
            }

            // Fill jug2
            if (y < jug2Capacity) {
                queue.offer(new State(x, jug2Capacity, currentState.path));
            }

            // Empty jug1
            if (x > 0) {
                queue.offer(new State(0, y, currentState.path));
            }

            // Empty jug2
            if (y > 0) {
                queue.offer(new State(x, 0, currentState.path));
            }

            // Pour from jug1 to jug2
            int pour = Math.min(x, jug2Capacity - y);
            if (pour > 0) {
                queue.offer(new State(x - pour, y + pour, currentState.path));
            }

            // Pour from jug2 to jug1
            pour = Math.min(y, jug1Capacity - x);
            if (pour > 0) {
                queue.offer(new State(x + pour, y - pour, currentState.path));
            }
        }

        return new ArrayList<>(); // No solution found
    }

    public static void main(String[] args) {
        int jug1Capacity = 4;
        int jug2Capacity = 3;
        int target = 2;

        List<String> solution = solve(jug1Capacity, jug2Capacity, target);

        if (solution.isEmpty()) {
            System.out.println("No solution found.");
        } else {
            System.out.println("Solution:");
            for (String step : solution) {
                System.out.println(step);
            }
        }
    }
}