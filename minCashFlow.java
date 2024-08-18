import java.util.*;

public class minCashFlow {
    static final int N = 4;

    // Function to find the index of the person with maximum cash
    int getMax(int[] arr) {
        int maxInd = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[maxInd]) {
                maxInd = i;
            }
        }
        return maxInd;
    }

    // Function to find the index of the person with minimum cash
    int getMin(int[] arr) {
        int minInd = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[minInd]) {
                minInd = i;
            }
        }
        return minInd;
    }

    // A utility function to return minimum of 2 values
    int minOf2(int x, int y) {
        return (x < y) ? x : y;
    }

    // Function to settle all debts
    void minCashFlowRec(int[] amount) {
        // Find the index of the person with maximum credit
        int mxCredit = getMax(amount);
        // Find the index of the person with maximum debit
        int mxDebit = getMin(amount);

        // If both amounts are 0, then all amounts are settled
        if (amount[mxCredit] == 0 && amount[mxDebit] == 0) {
            return;
        }

        // Find the minimum of amount to be credited and debited
        int min = minOf2(-amount[mxDebit], amount[mxCredit]);
        amount[mxCredit] -= min;
        amount[mxDebit] += min;

        // Print the transaction
        System.out.println("Person " + mxDebit + " pays " + min + " to Person " + mxCredit);

        // Recur for the remaining amount
        minCashFlowRec(amount);
    }

    // Function to calculate the minimum cash flow to settle all debts
    void minCashFlow(int[][] graph) {
        int[] amount = new int[N];

        // Calculate the net amount to be paid to each person
        for (int p = 0; p < N; p++) {
            for (int i = 0; i < N; i++) {
                amount[p] += (graph[i][p] - graph[p][i]);
            }
        }

        minCashFlowRec(amount);
    }

    public static void main(String[] args) {
        CashFlow cashFlow = new CashFlow();

        // graph[i][j] indicates the amount that person i needs to pay to person j
        int[][] graph = { {0, 50, 30, 0},
                          {0, 0, 0, 40},
                          {0, 0, 0, 20},
                          {0, 0, 0, 0} };

        // Calculate the minimum cash flow to settle all debts
        cashFlow.minCashFlow(graph);
    }
}
