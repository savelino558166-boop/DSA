package Solution;
import java.util.*;

public class Solve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter house values (e.g., 2,3,6): ");
        String input = scanner.nextLine();
        
        String[] values = input.split(",");
        int[] houses = new int[values.length];
        
        for (int i = 0; i < values.length; i++) {
            houses[i] = Integer.parseInt(values[i].trim());
        }
        
        if (houses.length == 0) {
            System.out.println("Max: 0");
        } else if (houses.length == 1) {
            System.out.println("Max: " + houses[0]);
        } else {
            int prev2 = houses[0];
            int prev1 = Math.max(houses[0], houses[1]);
            
            for (int i = 2; i < houses.length; i++) {
                int current = Math.max(prev1, prev2 + houses[i]);
                prev2 = prev1;
                prev1 = current;
            }
            
            System.out.println("Max: " + prev1);
        }
        
        scanner.close();
    }

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

}
