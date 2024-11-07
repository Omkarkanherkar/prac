import java.util.Scanner;

public class PSJF {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of Processes:");
        int n = sc.nextInt();

        int pid[] = new int[n];  // Process IDs
        int at[] = new int[n];   // Arrival times
        int bt[] = new int[n];   // Burst times
        int rbt[] = new int[n];  // Remaining burst times
        int ct[] = new int[n];   // Completion times
        int tat[] = new int[n];  // Turnaround times
        int wt[] = new int[n];   // Waiting times
        boolean isCompleted[] = new boolean[n]; // Completion status of processes

        float avgwt = 0;
        float avgtat = 0;

        // Input process details
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process ID, arrival time, and burst time for Process " + (i + 1) + ":");
            pid[i] = sc.nextInt();
            at[i] = sc.nextInt();
            bt[i] = sc.nextInt();
            rbt[i] = bt[i];  // Initially, the remaining burst time is equal to burst time
            isCompleted[i] = false;  // All processes are initially incomplete
        }

        int st = 0;   // Current time
        int tot = 0;  // Number of completed processes

        while (tot < n) {
            int shortestJob = -1;
            int minRbt = Integer.MAX_VALUE; // Min remaining burst time to find the next process to run

            // Find the process with the shortest remaining burst time that has arrived
            for (int i = 0; i < n; i++) {
                if (at[i] <= st && !isCompleted[i] && rbt[i] < minRbt) {
                    shortestJob = i;
                    minRbt = rbt[i];
                }
            }

            // If a process is found
            if (shortestJob != -1) {
                rbt[shortestJob]--;  // Decrease the remaining burst time
                st++;  // Increase system time

                // If the process is completed
                if (rbt[shortestJob] == 0) {
                    ct[shortestJob] = st;  // Set completion time
                    tat[shortestJob] = ct[shortestJob] - at[shortestJob];  // Turnaround time = Completion time - Arrival time
                    wt[shortestJob] = tat[shortestJob] - bt[shortestJob];  // Waiting time = Turnaround time - Burst time
                    isCompleted[shortestJob] = true;  // Mark the process as completed
                    tot++;  // Increment completed processes count
                }
            } else {
                // If no process is available, increment the system time (idle)
                st++;
            }
        }

        // Calculate average turnaround time and waiting time
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
