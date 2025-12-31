package Solution;          // Proposed Java Program

public class Solve {
    public int rob(int[] houses) {
        if (houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];

        int prev2 = houses[0];
        int prev1 = Math.max(houses[0], houses[1]);

        for (int i = 2; i < houses.length; i++) {
            int current = Math.max(prev1, prev2 + houses[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Solve s = new Solve();

        int[] nums = {2, 1, 4, 6, 2, 1};  // Output = 9
        System.out.println(s.rob(nums));
    }
}