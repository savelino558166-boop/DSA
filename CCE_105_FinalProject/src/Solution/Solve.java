package Solution;
import java.util.*;

public class Solve {

	public int rob(int[] Num) {
		
		int n = Num.length;
		
		
		if (n == 0) {	return 0;}
		
		if (n == 1) {	return Num[0];}
		
		Stack<Integer> dp = new Stack<>();
		int[] Checker = new int[n];
		
		if (Num[0]>Num[1]) {
			Checker[0] = 1;
			Checker[1] = 0;
			dp.push(Num[0]);
		} else {
			Checker[1] = 1;
			Checker[0] = 0;
			dp.push(Num[1]);
		}
		
		
		for (int i = 2; i < n; i+= 2 ) {
			
			if ((i+1)< n) {
				//Pass
			} else if (n%2 != 0 && (n - i == 2)){
				// if the length of the numbers of houses is odd, the last one will break;
				break;
			} else {
				break;
			}
			
			Checker[i] =  (Num[i] > Num[i+1] ? 1 : 0);
			Checker[i+1] =  (Num[i+1] > Num[i] ? 1 : 0);
			
			if (Checker[i-1] != 1) {
				
				dp.push(dp.peek() + Math.max(Num[i],Num[i+1]));
			} else {
				dp.push(dp.peek() + Num[i+1]);
				Checker[i] = 0;
				Checker[i+1] = 1;
			}
			
			
			
		}
		
		
		if (Checker[n-2] == 0 && n%2 != 0) {
			dp.push(dp.peek() + Num[n-1]);
			Checker[n-1] = 1;
		}
			

		
		return dp.peek();
		
	}
	
	
	public static void main(String[] args) {
		Solve Robbing = new Solve();
		int[] Houses = {4,1,2,6,8,1,3,9};
		
		
		
		int Max = Robbing.rob(Houses);
		System.out.println(Max);
		
	}
}
