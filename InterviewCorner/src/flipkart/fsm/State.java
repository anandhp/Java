package flipkart.fsm;

import java.util.HashMap;
import java.util.Map;

public class State {
	Map<String, Transition> transitions;
	Runnable entryCode;
	Runnable exitCode;
	Runnable alwaysRunCode;
	
	public State(Runnable entryCode, Runnable exitCode, Runnable alwaysRunCode) {
		transitions = new HashMap<String, Transition>();
		this.entryCode = entryCode;
		this.exitCode = exitCode;
		this.alwaysRunCode = alwaysRunCode;
	}
	
	public void addTransition(Transition transition) {
		this.transitions.put(transition.eventName, transition);
	}
	
	public void runEntryCode() {
		if (entryCode != null) {
			entryCode.run();
		}
	}

	public void runExitCode() {
		if (exitCode != null) {
			exitCode.run();
		}
	}
	public void runAlwaysRunCode() {
		if (alwaysRunCode != null) {
			alwaysRunCode.run();
		}
	}
}
