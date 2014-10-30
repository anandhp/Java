package flipkart.fsm;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class FSM {
	
	Map<String, State> states;
	String currentState;
	
	public FSM() {
		this.states = new HashMap<String, State>();
		this.currentState = null;
	}
	
	public void addState(String state, Runnable entryCode, Runnable exitCode, Runnable alwaysRunCode) {
		boolean initState = this.states.size() == 0;
		
		if (!this.states.containsKey(state))
			this.states.put(state, new State(entryCode, exitCode, alwaysRunCode));
		
		if (initState)
			currentState = state;
	}
	
	public void setEntryCode(String state, Runnable entryCode) {
		if(this.states.containsKey(state))
			this.states.get(state).entryCode = entryCode;
	}

	public void setExitCode(String state, Runnable exitCode) {
		if(this.states.containsKey(state))
			this.states.get(state).exitCode = exitCode;
	}
	
	public void setAlwaysRunCode(String state, Runnable alwaysRunCode) {
		if(this.states.containsKey(state))
			this.states.get(state).alwaysRunCode = alwaysRunCode;
	}
	
	public void triggerEvent(String eventName) {
		State state = this.states.get(currentState);
		if (state.transitions.containsKey(eventName)) {
			Transition transition = state.transitions.get(eventName);
			transition.doBeforeTransition();
			setState(transition.endState);
			transition.doAfterTransition();
		}
	}

	public  void setState(String newState) {
		if (currentState != null && !currentState.equals(newState)) {
			states.get(currentState).runExitCode();
		}
		
		currentState = newState;
		states.get(currentState).runAlwaysRunCode();
		
		states.get(currentState).runEntryCode();
	}	
	
	public void addTransition(Transition transition) {
		State state = this.states.get(transition.startState);
		if (state == null)
			throw new NoSuchElementException("No such State" + transition.startState);
		state.addTransition(transition);
	}
}
