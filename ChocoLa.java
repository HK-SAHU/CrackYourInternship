import java.util.*;

public class ChocoLa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = Integer.parseInt(scanner.nextLine());
        scanner.nextLine(); // Skip the blank line after test cases count
        
        for (int t = 0; t < testCases; t++) {
            if (t > 0) {
                scanner.nextLine(); // Skip the blank line between test cases
            }
            
            String[] dimensions = scanner.nextLine().split(" ");
            int m = Integer.parseInt(dimensions[0]);
            int n = Integer.parseInt(dimensions[1]);
            
            int[] verticalCuts = new int[m - 1];
            int[] horizontalCuts = new int[n - 1];
            
            for (int i = 0; i < m - 1; i++) {
                verticalCuts[i] = Integer.parseInt(scanner.nextLine());
            }
            
            for (int i = 0; i < n - 1; i++) {
                horizontalCuts[i] = Integer.parseInt(scanner.nextLine());
            }
            
            System.out.println(minimalChocolateBreakCost(m, n, verticalCuts, horizontalCuts));
        }
        
        scanner.close();
    }
    
    public static int minimalChocolateBreakCost(int m, int n, int[] verticalCuts, int[] horizontalCuts) {
        Arrays.sort(verticalCuts);
        Arrays.sort(horizontalCuts);
        
        int i = verticalCuts.length - 1;
        int j = horizontalCuts.length - 1;
        
        int horizontalSegments = 1;
        int verticalSegments = 1;
        
        int totalCost = 0;
        
        while (i >= 0 && j >= 0) {
            if (verticalCuts[i] >= horizontalCuts[j]) {
                totalCost += verticalCuts[i] * horizontalSegments;
                verticalSegments++;
                i--;
            } else {
                totalCost += horizontalCuts[j] * verticalSegments;
                horizontalSegments++;
                j--;
            }
        }
        
        while (i >= 0) {
            totalCost += verticalCuts[i] * horizontalSegments;
            i--;
        }
        
        while (j >= 0) {
            totalCost += horizontalCuts[j] * verticalSegments;
            j--;
        }
        
        return totalCost;
    }
}

