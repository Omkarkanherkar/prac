import java.util.*;
public class P_Priority {
    
    
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            System.out.println("Enter number of Processes:");
            int n = sc.nextInt();
    
            int pid[] = new int[n];  // Process IDs
            int at[] = new int[n];   // Arrival times
            int bt[] = new int[n];   // Burst times
            int rbt[] = new int[n];  // Remaining burst times
            int priority[] = new int[n]; // Priority of each process
            int ct[] = new int[n];   // Completion times
            int tat[] = new int[n];  // Turnaround times
            int wt[] = new int[n];   // Waiting times
            boolean isCompleted[] = new boolean[n]; // Completion status of processes
    
            float avgwt = 0;
            float avgtat = 0;
    
            // Input process details
            for (int i = 0; i < n; i++) {
                System.out.println("Enter process ID, arrival time, burst time, and priority for Process " + (i + 1) + ":");
                pid[i] = sc.nextInt();
                at[i] = sc.nextInt();
                bt[i] = sc.nextInt();
                priority[i] = sc.nextInt();  // Priority of the process (lower number means higher priority)
                rbt[i] = bt[i];  // Initially, the remaining burst time is equal to burst time
                isCompleted[i] = false;  // All processes are initially incomplete
            }
    
            int st = 0;   // Current time
            int tot = 0;  // Number of completed processes
    
            while (tot < n) {
                int highestPriority = Integer.MAX_VALUE; // Highest priority process (lower number = higher priority)
                int processIndex = -1;  // Index of the process to run
    
                // Find the process with the highest priority that has arrived and is not yet completed
                for (int i = 0; i < n; i++) {
                    if (at[i] <= st && !isCompleted[i] && priority[i] < highestPriority) {
                        highestPriority = priority[i];
                        processIndex = i;
                    }
                }
    
                // If a process is found with the highest priority
                if (processIndex != -1) {
                    rbt[processIndex]--;  // Decrease the remaining burst time
                    st++;  // Increment system time
    
                    // If the process is completed
                    if (rbt[processIndex] == 0) {
                        ct[processIndex] = st;  // Set completion time
                        tat[processIndex] = ct[processIndex] - at[processIndex];  // Turnaround time = Completion time - Arrival time
                        wt[processIndex] = tat[processIndex] - bt[processIndex];  // Waiting time = Turnaround time - Burst time
                        isCompleted[processIndex] = true;  // Mark the process as completed
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
            System.out.println("P_id \t at \t bt \t priority \t ct \t tat \t wt ");
            for (int i = 0; i < n; i++) {
                System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + priority[i] + "\t\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
            }
    
            // Display average waiting time and turnaround time
            System.out.println("Average Turnaround Time: " + (avgtat / n));
            System.out.println("Average Waiting Time: " + (avgwt / n));
        }
    }
    