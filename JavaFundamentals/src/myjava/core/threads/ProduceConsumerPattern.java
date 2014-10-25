/**
 * An example of Producer-Consumer design pattern using blocking queue
 */
package myjava.core.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProduceConsumerPattern {

	/**
	 * Producer Thread object
	 */
	public class Producer implements Runnable {
	private final BlockingQueue<String> sharedQueue;

		public Producer(BlockingQueue<String> sharedQueue) {
			this.sharedQueue = sharedQueue;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("Producing Item :" + i);
					this.sharedQueue.put("Item number " + i);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	/**
	 * Cosumer thread
	 */
	public class Consumer implements Runnable {
		private final BlockingQueue<String> sharedQueue;
		
		public Consumer(BlockingQueue<String> sharedQueue) {
			this.sharedQueue = sharedQueue;
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("Consuming " + sharedQueue.take());
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
	}

	/**
	 * Testing function
	 */
	public static void main(String[] args) {
		BlockingQueue<String> sharedQueue = new LinkedBlockingQueue<String>();
		
		Thread producer  = new Thread(new ProduceConsumerPattern().new Producer(sharedQueue));
		Thread consumer  = new Thread(new ProduceConsumerPattern().new Consumer(sharedQueue));
		
		producer.start();
		consumer.start();
	}

}
