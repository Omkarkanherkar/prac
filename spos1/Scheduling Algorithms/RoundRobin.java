import java.util.Scanner;

public class RoundRobin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of Process:");
        int n = sc.nextInt();
        System.out.println("Enter Quantum time:");
        int q = sc.nextInt();

        int pid[] = new int[n];  // Process IDs
        int at[] = new int[n];   // Arrival times
        int bt[] = new int[n];   // Burst times
        int ct[] = new int[n];   // Completion times
        int tat[] = new int[n];  // Turnaround times
        int wt[] = new int[n];   // Waiting times
        int rbt[] = new int[n];  // Remaining burst times
        int f[] = new int[n];    // Finished flag (0 = not finished, 1 = finished)

        float avgwt = 0;
        float avgtat = 0;

        // Input process details
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process ID, arrival time, and burst time for Process " + (i + 1) + ":");
            pid[i] = sc.nextInt();
            at[i] = sc.nextInt();
            bt[i] = sc.nextInt();
            rbt[i] = bt[i];  // Remaining burst time is initially the burst time
            f[i] = 0;        // Process is not finished initially
        }

        int st = 0;  // System time or current time
        int tot = 0; // Number of completed processes

        while (tot < n) {
            boolean processExecuted = false;

            // Iterate over each process to simulate Round Robin execution
            for (int i = 0; i < n; i++) {
                if (at[i] <= st && f[i] == 0) {  // Process is ready to execute
                    processExecuted = true;
                    
                    if (rbt[i] > q) {  // If remaining burst time is more than quantum
                        st += q;
                        rbt[i] -= q;  // Reduce remaining burst time
                    } else {  // Process can complete in this round
                        st += rbt[i];
                        ct[i] = st;   // Set completion time
                        rbt[i] = 0;
                        f[i] = 1;     // Mark process as finished
                        tot++;        // Increase the number of finished processes
                    }
                }
            }

            // If no process was executed, move time forward (to handle idle time)
            if (!processExecuted) {
                st++;
            }
        }

        // Calculate Turnaround Time (TAT) and Waiting Time (WT)
        for (int i = 0; i < n; i++) {
            tat[i] = ct[i] - at[i];  // Turnaround time = Completion time - Arrival time
            wt[i] = tat[i] - bt[i];  // Waiting time = Turnaround time - Burst time
            avgtat += tat[i];
            avgwt += wt[i];
        }

        // Output results
        System.out.println("P_id \t at \tbt \t ct \t tat \t wt ");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }

        // Display average waiting time and turnaround time
        System.out.println("Average Turnaround Time: " + (avgtat / n));
        System.out.println("Average Waiting Time: " + (avgwt / n));
    }
}
