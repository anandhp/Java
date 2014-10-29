package com.doordie.designpatterns.behavioral;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Observer {
	private static int observerIDTracer = 0;

	//Subject interface
	public interface Subject {
		public void register(IObserver newObserver);
		public void unregister(IObserver observer);
		public void notifyObservers();
	}

	//Observer interface
	public interface IObserver {
		public void update(double aaplPrice, double googPrice);
	}
	
	//Concrete Subject
	public class StockGrabber implements Subject {
		private double aaplPrice = 0;
		private double googPrice = 0;
		
		private List<IObserver> observers = new ArrayList<IObserver>();
		
		public void setAAPLPrice(double newPrice) {
			this.aaplPrice = newPrice;
			notifyObservers();
		}
		
		public void setGOOGPrice(double newPrice) {
			this.googPrice = newPrice;
			notifyObservers();
		}
		
		@Override
		public void register(IObserver newObserver) {
			observers.add(newObserver);
		}

		@Override
		public void unregister(IObserver observerToRemove) {
			int observerIndex = observers.indexOf(observerToRemove);
			observers.remove(observerToRemove);
			
			System.out.println("Observer ID " + (observerIndex + 1) + " is removed.\n");
		}

		@Override
		public void notifyObservers() {
			for (IObserver observer : observers) {
				observer.update(aaplPrice, googPrice);
			}
		}
	}
	
	//Concrete observer
	public class StockObserver implements IObserver {
		private int observerId;
		private Subject stackGrabber;
		
		
		public StockObserver(Subject stackGrabber) {
			observerId = ++observerIDTracer;
			this.stackGrabber = stackGrabber;
			this.stackGrabber.register(this);
		}

		@Override
		public void update(double aaplPrice, double googPrice) {
			System.out.println("Observer ID: " + observerId 
					+ "\n\t APPL Price: " + aaplPrice
					+ "\n\t GOOG Price: " + googPrice + "\n");
		}
	}
	
	//Periodic Subject updater
	public class StackUpdater implements Runnable {
		
		private Subject stackGrabber;
		private double basePrice;
		private String stockSymbol;
		
		public StackUpdater(Subject stackGrabber, double basePrice, String stockSymbol) {
			this.stackGrabber = stackGrabber;
			this.basePrice = basePrice;
			this.stockSymbol = stockSymbol;
		}
		
		@Override
		public void run() {
			for(int i = 1; i <= 20; i++){
	
				try {
					
					Thread.sleep(2000);

					DecimalFormat foramt = new DecimalFormat("#.##");
					double randNum = (Math.random() * (.06)) - .03;
					double price = Double.valueOf(foramt.format(basePrice + randNum));

					if ("APPL".equals(stockSymbol)) {
						((StockGrabber)stackGrabber).setAAPLPrice(price);
					} else if ("GOOG".equals(stockSymbol)) {					
						((StockGrabber)stackGrabber).setGOOGPrice(price);
					}
					
				} catch(InterruptedException e) {
					
				}
			}
		}
		
	}
	
	
	//Observer tester
	public static void main(String[] args) {
		StockGrabber stackGrabber = new Observer().new StockGrabber();

		IObserver observer1 = new Observer().new StockObserver(stackGrabber);
		stackGrabber.setAAPLPrice(197.00);
		stackGrabber.setGOOGPrice(450.00);

		IObserver observer2 = new Observer().new StockObserver(stackGrabber);
		stackGrabber.setAAPLPrice(457.00);

		stackGrabber.unregister(observer1);
		
		stackGrabber.setAAPLPrice(347.00);
		
		new Thread(new Observer().new StackUpdater(stackGrabber,450, "APPL")).start();
		new Thread(new Observer().new StackUpdater(stackGrabber,600, "GOOG")).start();
	}

}
