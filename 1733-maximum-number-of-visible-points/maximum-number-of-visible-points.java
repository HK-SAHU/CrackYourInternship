class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameLocationPoints = 0;
        List<Double> angles = new ArrayList<>();

        int locationX = location.get(0);
        int locationY = location.get(1);

        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);

            if (x == locationX && y == locationY) {
                sameLocationPoints++;
                continue;
            }

            double theta = Math.atan2(y - locationY, x - locationX) * (180 / Math.PI);
            angles.add(theta);
        }

        Collections.sort(angles);

        List<Double> duplicateAngles = new ArrayList<>(angles);
        for (double a : angles) {
            duplicateAngles.add(a + 360);
        }

        int maxVisiblePoints = 0;
        int left = 0;

        for (int right = 0; right < duplicateAngles.size(); right++) {
            while (duplicateAngles.get(right) - duplicateAngles.get(left) > angle) {
                left++;
            }
            maxVisiblePoints = Math.max(maxVisiblePoints, right - left + 1);
        }

        return maxVisiblePoints + sameLocationPoints;
    }
}