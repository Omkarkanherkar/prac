import java.util.*;
public class Optimal {
    
   
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            int ref_length, frames, ptr = 0, hit = 0, fault = 0;
            boolean isFull = false;
            double hitRatio, faultRatio;
            
            // Input reference length and frame count
            System.out.print("Enter the reference length (number of pages in reference string): ");
            ref_length = sc.nextInt();
            int pages[] = new int[ref_length];
            
            System.out.println("Enter the pages in the reference string: ");
            for (int i = 0; i < ref_length; i++) {
                pages[i] = sc.nextInt();
            }
            
            System.out.print("Enter the number of frames: ");
            frames = sc.nextInt();
            int frame[] = new int[frames];
            int table[][] = new int[ref_length][frames];
            
            for (int i = 0; i < frames; i++) {
                frame[i] = -1;
            }
            
            System.out.println("----------------------------------------------------------------------");
            for (int i = 0; i < ref_length; i++) {
                int search = -1;
                for (int j = 0; j < frames; j++) {
                    if (frame[j] == pages[i]) {
                        search = j;
                        hit++;
                        System.out.printf("%4s", "H");
                        break;
                    }
                }
                
                if (search == -1) {
                    if (isFull) {
                        int[] index = new int[frames];
                        boolean[] index_flag = new boolean[frames];
                        
                        for (int j = i + 1; j < ref_length; j++) {
                            for (int k = 0; k < frames; k++) {
                                if (pages[j] == frame[k] && !index_flag[k]) {
                                    index[k] = j;
                                    index_flag[k] = true;
                                    break;
                                }
                            }
                        }
                        
                        int max = index[0];
                        ptr = 0;
                        if (max == 0) max = 200;
                        for (int j = 0; j < frames; j++) {
                            if (index[j] == 0) index[j] = 200;
                            if (index[j] > max) {
                                max = index[j];
                                ptr = j;
                            }
                        }
                    }
                    
                    frame[ptr] = pages[i];
                    fault++;
                    System.out.printf("%4s", "F");
                    
                    if (!isFull) {
                        ptr++;
                        if (ptr == frames) {
                            ptr = 0;
                            isFull = true;
                        }
                    }
                }
                
                System.arraycopy(frame, 0, table[i], 0, frames);
            }
            
            System.out.println("\n----------------------------------------------------------------------");
            for (int i = 0; i < frames; i++) {
                for (int j = 0; j < ref_length; j++)
                    System.out.printf("%3d ", table[j][i]);
                System.out.println();
            }
            
            System.out.println("----------------------------------------------------------------------");
            hitRatio = ((double) hit / ref_length) * 100;
            faultRatio = ((double) fault / ref_length) * 100;
            System.out.println("Page Fault: " + fault + "\nPage Hit: " + hit);
            
            
            sc.close();
        }
    }
    
    