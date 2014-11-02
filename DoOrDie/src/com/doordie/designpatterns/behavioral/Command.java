package com.doordie.designpatterns.behavioral;

import java.util.LinkedList;
import java.util.List;

/**
 * COMMAND pattern, encapsulate a request as an object, thereby letting
 * you parameterize clients with different requests, queue or log requests,
 * and support undo operations.
 * 
 * Below is an example of simple Stock trading scenario. Buying and Selling
 * (commands) of stocks are parameterized by the StockBroker (Invoker) to
 * carry operations of the StockTrade (Receiver)
 *
 */
public class Command {

	//Receiver 
	public class StockTrade {
		public void buy() {
			System.out.println("Buy stocks");
		}
		
		public void sell() {
			System.out.println("Sell stocks");
		}
	}

	
	//Abstract Command
	public abstract class StockOrder {
		protected StockTrade stockTrader;
		
		public StockOrder(StockTrade stockTrader) {
			this.stockTrader = stockTrader;
		}
		
		public abstract void execute();
	}
	
	//Concrete commands
	public class BuyStock extends StockOrder {
		
		public BuyStock(StockTrade stockTrader) {
			super(stockTrader);
		}

		@Override
		public void execute() {
			stockTrader.buy();
		}
	}
	
	public class SellStock extends StockOrder {

		public SellStock(StockTrade stockTrader) {
			super(stockTrader);
		}

		@Override
		public void execute() {
			stockTrader.sell();
		}
	}
	
	//Invoker
	public class StockBroker {
		private List<StockOrder> orders = new LinkedList<StockOrder>();
		
		public void placeOrder(StockOrder newOrder) {
			this.orders.add(newOrder);
			newOrder.execute();
		}
	}
	
	//Command tester - Client
	public static void main(String[] args) {
		StockBroker broker = new Command().new StockBroker();
		StockTrade trader = new Command().new StockTrade();
		
		broker.placeOrder(new Command().new BuyStock(trader));
		broker.placeOrder(new Command().new BuyStock(trader));
		broker.placeOrder(new Command().new SellStock(trader));
		broker.placeOrder(new Command().new SellStock(trader));
	}

}
