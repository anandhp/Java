package myjava.core.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * An example of thread pool using Executor
 */

public class ThreadPool {

	public class WorkerThread implements Runnable {
		private String command = null;
		
		public WorkerThread(String command) {
			this.command = command;
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " Processing command " + this.command);
				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName() + " Done with " + this.command);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public String toString() {
			return this.command;
		}
	}
	

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Added task " + i);
			service.execute(new ThreadPool().new WorkerThread("" + i));
		}
		
		service.shutdown();
		while (!service.isTerminated());
		
        System.out.println("Finished all threads");
	}

}
