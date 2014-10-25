package myjava.core.threads;

public class RunnableClass implements Runnable {

	private String threadName = null;
	
	public RunnableClass(String name) {
		this.threadName = name;
	}
			
	@Override
	public void run() {
		System.out.println("Running the thread " + this.threadName);
		
		try {
			for (int i = 0; i < 4; i++) {
				System.out.println("Sleeping count no : " +  this.threadName + i);
				Thread.sleep(500);
			}
		}
		catch (InterruptedException e) {
			System.out.println(e);
		}

		System.out.println("Exiting the thread " + this.threadName);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread first= new Thread(new RunnableClass("First"));
		Thread second = new Thread(new RunnableClass("Second"));
		
		first.start();
		second.start();
		
	}

}
