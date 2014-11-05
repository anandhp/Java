package com.doordie.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * MEDIATOR pattern define an object that encapsulates how a set of objects interact.
 *  
 * Mediator promotes loose coupling by keeping objects from referring to each other explicitly, 
 * and it lets you vary their interaction independently.
 * 
 * Below is an example of Mediator pattern for stock exchange model
 */

public class Mediator {
	
	//Stock class holding transaction information
	public static class StockOffer {
		private int numOfShares;
		private  String stockSymbol;
		private int brokerCode;
		
		public StockOffer(int numOfShares, String stockSymbol, int brokerCode) {
			this.numOfShares = numOfShares;
			this.stockSymbol = stockSymbol;
			this.brokerCode = brokerCode;
		}
		
		public int getNumberOfShares() { return numOfShares; }
		public String getStockSymbol() { return stockSymbol; }
		public int getBrokerCode() { return brokerCode; }	
	}
	
	//Abstract colleague
	public static abstract class StockBroker {
		private StockMediator mediator;
		private int brokerCode;
		
		public StockBroker(StockMediator mediator) {
			this.mediator = mediator;
			mediator.addBroker(this);
		}
		
		public void saleOffer(int numberOfShare, String stockSymbol) {
			this.mediator.saleOffer(numberOfShare, stockSymbol, brokerCode);
		}

		public void buyOffer(int numberOfShare, String stockSymbol) {
			this.mediator.buyOffer(numberOfShare, stockSymbol, brokerCode);
		}
		
		public void setBrokerCode(int brokerCode) {
			this.brokerCode = brokerCode;
		}
	}
	
	//Concrete colleague
	public static class JPMorman extends StockBroker {
		public JPMorman(StockMediator mediator) {
			super(mediator);
		}
	}

	public static class SharePoint extends StockBroker {
		public SharePoint(StockMediator mediator) {
			super(mediator);
		}
	}

	//Abstract mediator
	public static interface StockMediator {
		public void saleOffer(int numberOfShare, String stockSymbol,  int brokerCode);
		public void buyOffer(int numberOfShare, String stockSymbol, int brokerCode);
		public void addBroker(StockBroker broker);
	}
	
	//Concrete mediator
	public static class StockExchange implements StockMediator {
		
		private List<StockOffer> buyOffers;
		private List<StockOffer> sellOffers;
		private List<StockBroker> brokers;
		
		private int borkerCode = 0;
		
		public StockExchange() {
			buyOffers = new ArrayList<StockOffer>();
			sellOffers = new ArrayList<StockOffer>();
			brokers = new ArrayList<StockBroker>(); 
		}

		@Override
		public void saleOffer(int numberOfShare, String stockSymbol,  int brokerCode) {
			boolean offerSold = false;
			for (StockOffer offer : buyOffers) {
				if (offer.getNumberOfShares() == numberOfShare
						&& offer.getStockSymbol().equals(stockSymbol)) {
					offerSold = true;
					System.out.println(numberOfShare + " shares of " 
								+ stockSymbol + "are sold to " + offer.getBrokerCode());
					buyOffers.remove(offer);

				}
				
				if (offerSold)
					break;
			}
			
			if (!offerSold) {
				System.out.println(numberOfShare + " of  " + stockSymbol + " are added to inventory");
				sellOffers.add(new StockOffer(numberOfShare, stockSymbol, brokerCode));
			}
		}

		@Override
		public void buyOffer(int numberOfShare, String stockSymbol, int brokerCode) {
			boolean offerBought = false;
			for (StockOffer offer : sellOffers) {
				if (offer.getNumberOfShares() == numberOfShare
						&& offer.getStockSymbol().equals(stockSymbol)) {
					offerBought = true;
					System.out.println(numberOfShare + " shares of " 
								+ stockSymbol + " are bought buy " + offer.getBrokerCode());
					sellOffers.remove(offer);
				}
				
				if (offerBought)
					break;
			}
			
			if (!offerBought) {
				System.out.println(numberOfShare + " of  " + stockSymbol + " are added to inventory");
				buyOffers.add(new StockOffer(numberOfShare, stockSymbol, brokerCode));
			}			
		}
		
		public void printStockStatus() {
			System.out.println("\nShares for Sale");
			for (StockOffer offer : sellOffers) {
				System.out.println(offer.getNumberOfShares() + " of " + offer.getStockSymbol());
			}

			System.out.println("\nShares for Buy offers");
			for (StockOffer offer : buyOffers) {
				System.out.println(offer.getNumberOfShares() + " of " + offer.getStockSymbol());
			}
		}

		@Override
		public void addBroker(StockBroker broker) {
			this.brokers.add(broker);
			broker.setBrokerCode(++borkerCode);
		}
		
	}
	
	//Mediator tester
	public static void main(String[] args) {
		StockExchange bse = new StockExchange();
		
		StockBroker brokerOne = new JPMorman(bse);
		StockBroker brokerTwo = new SharePoint(bse);
		
		brokerOne.saleOffer(100, "MSFT");
		brokerOne.saleOffer(50, "GOOG");

		brokerTwo.buyOffer(100, "MSFT");
		brokerTwo.saleOffer(10, "NOK");

		brokerOne.buyOffer(10, "NOK");
		brokerOne.buyOffer(100, "MSFT");


		bse.printStockStatus();
	}

}
