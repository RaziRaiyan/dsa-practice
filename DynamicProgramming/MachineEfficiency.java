package DynamicProgramming;

public class MachineEfficiency {
    public static void main(String[] args) {
        int[] machines1 = {5, 2, 2, 0}; // Should return 2 (only keep 5 and 0)
        int[] machines2 = {5, 4, 0, 3, 3, 1}; // Should return 4
        int[] machines3 = {1, 2, 2, 1, 1}; // Should return 3

        System.out.println(minMachines(machines1)); // 2
        System.out.println(minMachines(machines2)); // 4
        System.out.println(minMachines(machines3)); // 3
    }

    public static int minMachines(int[] machines) {
        int n = machines.length;
        if (n <= 2) return n; // cannot remove anything

        int required = 2; // first and last are always required

        for (int i = 1; i < n - 1; i++) {
            int a = machines[i - 1];
            int b = machines[i];
            int c = machines[i + 1];

            // Check if removing b preserves efficiency
            if (Math.abs(b - a) + Math.abs(c - b) != Math.abs(c - a)) {
                required++; // we must keep b
            }
        }

        return required;
    }

}
