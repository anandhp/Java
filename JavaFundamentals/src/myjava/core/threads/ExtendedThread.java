package myjava.core.threads;

public class ExtendedThread extends Thread {

	private String name;
	
	public ExtendedThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println("Running thread " + this.name);
		try {
			for (int i = 0; i < 4; i++) {
				System.out.println("Sleeping count " + this.name + i);
				Thread.sleep(500);
			}
		}
		catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void start() {
		System.out.println("Starting thread " + this.name);
		super.start();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExtendedThread one = new ExtendedThread("Thread - 1");
		ExtendedThread two = new ExtendedThread("Thread - 2");
		
		one.start();
		two.start();
	}

}
