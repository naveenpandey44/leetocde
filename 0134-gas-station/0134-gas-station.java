public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If tank is negative, can't start from here
            if (tank < 0) {
                start = i + 1; // Try from next station
                tank = 0; // Reset tank
            }
        }

        return totalGas >= totalCost ? start : -1;
    }
}
 