package Final_Prod_Problem;

public class Problem {
	    // Function to solve the house robber problem
	    public int rob(int[] nums) {
	        // Get the number of houses
	        int n = nums.length;

	        // If there are no houses, return 0
	        if (n == 0) {
	            return 0;
	        }

	        // If there is only one house, return the amount in that house
	        if (n == 1) {
	            return nums[0];
	        }

	        // Create a dynamic programming array to store the maximum amount robbed up to each house
	        int[] dp = new int[n];

	        // Base cases:
	        dp[0] = nums[0]; // Maximum amount robbed up to the first house is the amount in the first house
	        dp[1] = Math.max(nums[0], nums[1]); // Maximum amount robbed up to the second house is the maximum of the first two houses

	        // Iterate through the remaining houses
	        for (int i = 2; i < n; i++) {
	            // The maximum amount robbed up to house i is the maximum of:
	            // 1. Robbing house i and adding it to the maximum amount robbed up to house i-2
	            // 2. Not robbing house i and taking the maximum amount robbed up to house i-1
	            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
	        }

	        // The maximum amount robbed is the last element of the dp array
	        return dp[n - 1];
	    }

	    // Main function to test the rob function
	    public static void main(String[] args) {
	    	Problem solution = new Problem();
	        int[] nums = {4,1,2,6,8,1,3,9};

	        int maxAmount = solution.rob(nums);
	        System.out.println("Maximum amount that can be robbed: " + maxAmount);
	    }
}
