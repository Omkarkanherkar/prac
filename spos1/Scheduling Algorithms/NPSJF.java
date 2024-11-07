import java.util.Scanner;

public class NPSJF {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of Processes:");
        int n = sc.nextInt();

        int pid[] = new int[n];  // Process IDs
        int at[] = new int[n];   // Arrival times
        int bt[] = new int[n];   // Burst times
        int ct[] = new int[n];   // Completion times
        int tat[] = new int[n];  // Turnaround times
        int wt[] = new int[n];   // Waiting times
        int f[] = new int[n];    // Finished flag (0 = not finished, 1 = finished)

        float avgwt = 0;
        float avgtat = 0;

        // Input process details
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process ID, arrival time, and burst time for Process " + (i + 1) + ":");
            pid[i] = sc.nextInt();
            at[i] = sc.nextInt();
            bt[i] = sc.nextInt();
            f[i] = 0; // Process is not finished initially
        }

        int st = 0;  // System time or current time
        int tot = 0; // Number of completed processes

        while (tot < n) {
            int min_bt = Integer.MAX_VALUE;  // Minimum burst time among available processes
            int index = -1;  // Index of the process with minimum burst time

            // Find the process with the shortest burst time that has already arrived and is not finished
            for (int i = 0; i < n; i++) {
                if (at[i] <= st && f[i] == 0 && bt[i] < min_bt) {
                    min_bt = bt[i];
                    index = i;
                }
            }

            // If a process was found that can be executed
            if (index != -1) {
                st += bt[index];  // Increment system time by the burst time of the selected process
                ct[index] = st;   // Set completion time for the process
                tat[index] = ct[index] - at[index];  // Turnaround time = Completion time - Arrival time
                wt[index] = tat[index] - bt[index];  // Waiting time = Turnaround time - Burst time
                f[index] = 1;     // Mark the process as finished
                tot++;            // Increase the number of finished processes
            } else {
                st++;  // If no process is ready, increment system time (idle time)
            }
        }

        // Calculate average Turnaround Time and Waiting Time
        for (int i = 0; i < n; i++) {
            avgtat += tat[i];
            avgwt += wt[i];
        }

        // Output the results
        System.out.println("P_id \t at \t bt \t ct \t tat \t wt ");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }

        // Display average waiting time and turnaround time
        System.out.println("Average Turnaround Time: " + (avgtat / n));
        System.out.println("Average Waiting Time: " + (avgwt / n));
    }
}
