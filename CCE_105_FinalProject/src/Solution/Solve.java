package Solution;
import GUI_LAyout.Gui;
import Final_Prod_Problem.Problem;

public class Solve {


	public String rob(int[] nums) {
		
		String Total = "0";
		
        // Get the number of houses
        int n = nums.length;

        // If there are no houses, return 0
        if (n == 0) {
            return Total;
        }

        // If there is only one house, return the amount in that house
        if (n == 1) {
        	Total = String.valueOf(nums[0]);
            return Total;
        }


        int[] dp = new int[2];

        // Base cases:
        dp[0] = nums[0];
        dp[1] = nums[1]; 

        // Iterate through the remaining houses
        for (int i = 2; i < n; i++) {
        	
            int X = Math.max(dp[1], dp[0] + nums[i]);
            dp[0] = dp[1];
            dp[1] = X;
         
        }
        
        Total = String.valueOf(dp[1]);
 
        return Total;
    }

	
}
