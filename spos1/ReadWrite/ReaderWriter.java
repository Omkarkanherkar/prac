import java.util.concurrent.*;
import java.util.*;
public class ReaderWriter {
	static Semaphore mutex = new Semaphore(1);
	static Semaphore wrt = new Semaphore(1);
	static int readCount = 0;
	static String message = "Hello";
	static Scanner sc  = new Scanner(System.in);
	
	static  class Reader implements Runnable{
		public void run() {
			try {
				mutex.acquire();
				readCount++;
				
				if(readCount == 1) {
					wrt.acquire();
				}
				mutex.release();
				System.out.println("Thread "+ Thread.currentThread().getName()+" is Reading : "+ message);
				Thread.sleep(1500);
				System.out.println("Thread "+ Thread.currentThread().getName()+" is Finished Reading ");
				
				mutex.acquire();
				readCount--;
				if(readCount == 0) {
					wrt.release();
				}
				mutex.release();
			}
			catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
	}
	static class Writer implements Runnable{
		public void run() {
			try {
				wrt.acquire();
				
				message = "Good Morning";
				System.out.println("Thread " + Thread.currentThread().getName()+" is WRITING :"+ message);
				
				Thread.sleep(1500);
				System.out.println("Thread "+Thread.currentThread().getName()+" has finished WRITING");
				wrt.release();
			}
			catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
	}
	public static void main(String[] args) throws Exception{
		Reader read = new Reader();
		Writer write = new Writer();
		
		Thread t1 = new Thread(read);
		t1.setName("Reader1");
		
		Thread t2 = new Thread(read);
		t2.setName("Reader2");
		
		Thread t3 = new Thread(read);
		t3.setName("Reader3");
		
		Thread w1 = new Thread(write);
		w1.setName("Writer1");
		
		Thread w2 = new Thread(write);
		w2.setName("Writer2");
		
		Thread w3 = new Thread(write);
		w3.setName("Writer3");
		
		w1.start();
		t1.start();
		
		w2.start();
		t2.start();
		
		w3.start();
		t3.start();
		
	}
}

