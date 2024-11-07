import java.util.Scanner;
public class BankersAlgorithm{
    private int need[][],allocate[][],max[][],avail[][],n,m;
     
    private void input(){
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter no. of processes: ");
     n=sc.nextInt();  //no. of process
     System.out.print("Enter no. of Resources : ");
     m=sc.nextInt();  //no. of resources
     need=new int[n][m];  //initializing arrays
     max=new int[n][m];
     allocate=new int[n][m];
     avail=new int[1][m];
      
     System.out.println("Enter allocation matrix :");
     for(int i=0;i<n;i++)
          for(int j=0;j<m;j++)
         allocate[i][j]=sc.nextInt();  //allocation matrix
       
     System.out.println("Enter max matrix :");
     for(int i=0;i<n;i++)
          for(int j=0;j<m;j++)
         max[i][j]=sc.nextInt();  //max matrix
       
        System.out.println("Enter available matrix :");
        for(int j=0;j<m;j++)
         avail[0][j]=sc.nextInt();  //available matrix
         
        sc.close();
    }
     
    private int[][] calc_need(){
       for(int i=0;i<n;i++)
         for(int j=0;j<m;j++)  //calculating need matrix
          need[i][j]=max[i][j]-allocate[i][j];
        
       return need;
    }
  
    private boolean check(int i){
       //checking if all resources for ith process can be allocated
       for(int j=0;j<m;j++) 
       if(avail[0][j]<need[i][j])
          return false;
    
    return true;
    }
 
    public void isSafe(){
       input();
       calc_need();
       boolean done[]=new boolean[n];
       int j=0;
 
       while(j<n)
      {  
//until all process allocated
       boolean allocated=false;
       for(int i=0;i<n;i++)
        if(!done[i] && check(i)){ 
 //trying to allocate
            for(int k=0;k<m;k++)
            avail[0][k]=avail[0][k]-need[i][k]+max[i][k];
         System.out.println("Allocated process : "+i);
         allocated=done[i]=true;
               j++;
             }
          if(!allocated) break;  //if no allocation
       }
       if(j==n)  
        System.out.println("\nSafely allocated!!!");
       else
        System.out.println("All proceess cant be allocated safely");
    }
     
    public static void main(String[] args) {
       new BankersAlgorithm().isSafe();
    }
}
