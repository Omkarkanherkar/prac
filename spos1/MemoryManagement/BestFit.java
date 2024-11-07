import java.util.Arrays;
import java.util.Scanner;

public class BestFit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of jobs:");
        int n = sc.nextInt();

        System.out.println("Enter the number of blocks:");
        int m = sc.nextInt();

        int[] job = new int[n];
        int[] block = new int[m];
        int[] allocation = new int[n]; 

        System.out.println("Enter the size of jobs:");
        for (int i = 0; i < n; i++) {
            job[i] = sc.nextInt();
            allocation[i] = -1; 
        }

        System.out.println("Enter the size of blocks:");
        for (int i = 0; i < m; i++) {
            block[i] = sc.nextInt();
        }

        
        for (int i = 0; i < n; i++) {
            int bestIdx = -1; 
            for (int j = 0; j < m; j++) {
                
                if (job[i] <= block[j] && (bestIdx == -1 || block[bestIdx] > block[j])) {
                    bestIdx = j;
                }
            }
            
            if (bestIdx != -1) {
                allocation[i] = bestIdx;
                block[bestIdx] -= job[i]; 
                System.out.println("Job " + i + " is allocated to Block " + bestIdx);
            } else {
                System.out.println("Job " + i + " is not allocated");
            }
        }

        sc.close();
    }
}
