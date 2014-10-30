package flipkart.fsm;

public class Transition {
	String eventName;
	String startState;
	String endState;
	
	public Transition(String eventName, String startState, String endState) {
		this.eventName = eventName;
		this.startState = startState;
		this.endState = endState;
	}
	
	public void doBeforeTransition() {
	}

	public void doAfterTransition() {
	}
}
