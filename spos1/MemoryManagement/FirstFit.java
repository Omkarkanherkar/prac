import java.util.Scanner;
public class FirstFit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter the Number of job :");
		int n = sc.nextInt();
		
		System.out.println("Enter the Number of block :");
		int m = sc.nextInt();
		
		int job[] = new int[n];
		int block[] = new int[m];
		
		int flag[] = new int[m];
		
		int allocation[] = new int[m];
		
		System.out.println("Enter the Size of job :");
		for(int i = 0; i< n; i++) {
			job[i]= sc.nextInt();
			allocation[i]=-1;
		}
		
		System.out.println("Enter the Size of block :");
		for(int i = 0; i< m; i++) {
			block[i]= sc.nextInt();
			flag[i]=0;
		}
		
		for(int i = 0; i < job.length; i++) {
			for(int j = 0; j < block.length; j++) {
				
				if(job[i] <= block[j] && flag[j]==0) {
					System.out.println(i +" job is allocated to "+ j +" Block" );
					flag[j]=1;
					allocation[i]=j;
					break;
				}
			}
			if(allocation[i] == -1) {
				System.out.println(i +" job is not allocated " );
			}
		}
		

	}

}
