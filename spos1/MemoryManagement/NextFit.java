import java.util.*;
import java.util.Scanner;


public class NextFit {

    // Function to allocate memory to blocks as per Next Fit algorithm
    static void NextFit(int blockSize[], int m, int processSize[], int n) {
        // Stores block id of the block allocated to a process
        int allocation[] = new int[n], j = 0, t = m - 1;

        // Initially no block is assigned to any process
        Arrays.fill(allocation, -1);

        // Pick each process and find suitable blocks according to its size and assign to it
        for (int i = 0; i < n; i++) {
            // Do not start from beginning
            while (j < m) {
                if (blockSize[j] >= processSize[i]) {
                    // Allocate block j to process[i]
                    allocation[i] = j;
                    // Reduce available memory in this block
                    blockSize[j] -= processSize[i];
                    // Set a new endpoint
                    t = (j - 1) % m;
                    break;
                }
                if (t == j) {
                    // Set a new endpoint and break the loop after going through all memory blocks
                    t = (j - 1) % m;
                    break;
                }
                // Traverse the blocks from the starting block after reaching the end
                j = (j + 1) % m;
            }
        }

        // Display the result
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1) {
                System.out.println(allocation[i] + 1);
            } else {
                System.out.println("Not Allocated");
            }
        }
    }

    // Driver program to take input from the user
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of memory blocks:");
        int m = sc.nextInt();
        int blockSize[] = new int[m];

        System.out.println("Enter the sizes of the memory blocks:");
        for (int i = 0; i < m; i++) {
            blockSize[i] = sc.nextInt();
        }

        System.out.println("Enter the number of processes:");
        int n = sc.nextInt();
        int processSize[] = new int[n];

        System.out.println("Enter the sizes of the processes:");
        for (int i = 0; i < n; i++) {
            processSize[i] = sc.nextInt();
        }

        // Call NextFit function
        NextFit(blockSize, m, processSize, n);

        sc.close();
    }
}