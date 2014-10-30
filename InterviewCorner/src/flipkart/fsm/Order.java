package flipkart.fsm;

public class Order extends FSM {

	public static class Created implements Runnable {
		@Override
		public void run() {
			System.out.println("Order created");
		}
	}
	
	public static class Cancelled implements Runnable {
		@Override
		public void run() {
			System.out.println("Order cancelled");
		}
	}
	
	public static class Activated implements Runnable {
		@Override
		public void run() {
			System.out.println("Order activated");
		}
	}
	
	public static void main(String[] args) {
		
		Order order = new Order();
		
		order.addState("Created", new Created(), null, null);
		order.addState("Activated", new Activated(), null, null);
		order.addState("Cancelled", new Cancelled(), null, null);
		order.addState("InProgress", null, null, null);
		order.addState("Completed", null, null, null);
		
		order.addTransition(new Transition("Activate", "Created", "Activated"));
		order.addTransition(new Transition("Cancel", "Created", "Cancelled"));
		order.addTransition(new Transition("Cancel", "Activated", "Cancelled"));
		order.addTransition(new Transition("Make Progress", "Activated", "InProgress"));
		order.addTransition(new Transition("Cancel", "InProgress", "Cancelled"));
		order.addTransition(new Transition("Complete", "InProgress", "Completed"));
		
		order.triggerEvent("Activate");
		order.triggerEvent("Cancel");
		order.triggerEvent("MakeProgress");
		
	}

}
