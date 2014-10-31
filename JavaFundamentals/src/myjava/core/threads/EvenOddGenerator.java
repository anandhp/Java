package myjava.core.threads;

public class EvenOddGenerator implements Runnable {

	public enum Type {
		Odd, Even 
	}

	private Type type;
	private static boolean evenTurn = false;
	private Object lock;
	
	public EvenOddGenerator(Type type, Object lock) {
		this.type = type;
		this.lock = lock;
	}
	
	public void run() {
		int counter = type == Type.Odd ? 1 : 2;
		
		while (counter < 30) {
			if (type == Type.Odd) {
				printOdd(counter);
			}
			else {
				printEven(counter);
			}
			counter += 2;
		} 
	}
	
	private void printOdd(int number) {
		synchronized (lock) {
			while(evenTurn) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("Odd " + number);
			evenTurn = true;
			lock.notify();
		}
	}

	private synchronized void printEven(int number) {
		synchronized (lock) {
			while(!evenTurn) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Even " + number);
			evenTurn = false;
			lock.notify();
		}
	}
	
	public static void main(String[] args) {
		Object lock = new Object();
		new Thread(new EvenOddGenerator(Type.Odd, lock)).start();
		new Thread(new EvenOddGenerator(Type.Even, lock)).start();
	}
	
}
