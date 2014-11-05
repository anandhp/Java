package com.doordie.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * MEMENTO pattern captures and externalize an object's internal 
 * state allowing the object (called Originator) to be restored 
 * to this state later without violating encapsulation. The object 
 * holding the captured information is called Memento which itself
 * is stored in CareTaker object
 * 
 * Below is a sample example
 *
 */

public class Memento {
	
	//Originator
	public static class Originator {
		//state of originator
		private String state;
		
		public void setState(String newState) {
			System.out.println("Originator SET state " + newState);
			state = newState;
		}
		
		public MementoClass storeInMomento() {
			System.out.println("Originator CREATE momento " + state);
			return new MementoClass(state);
		}
		
		public void restoreFromMemento(MementoClass memento) {
			this.state = memento.getState();
			System.out.println("Originator RESTORE momento " + state);
		}
	
		//Memento object holding the originator info
		public static class MementoClass {
			//state of originator saved in Memento
			private String state;
			
			//New state set to memento
			public MementoClass(String state) { this.state = state; }
			
			//return the store state from this memento
			public String getState() { return state; }
		}
		
	
	}
	
	//Caretaker
	public static class CareTaker {
		List<Originator.MementoClass> savedStates = new ArrayList<Originator.MementoClass>();
		
		public void addMemento(Originator.MementoClass memento) { savedStates.add(memento); }
		public Originator.MementoClass getMomento(int index) { return savedStates.get(index); }
	}
	
	//Memento tester
	public static void main(String[] args) {
		Originator originator = new Originator();
		CareTaker caretaker = new CareTaker();
		int numberOfBackups = 0;
		
		//set the state
		originator.setState("First line");
		//save the state of memento
		caretaker.addMemento(originator.storeInMomento());
		numberOfBackups++;
		
		//modify the originator
		originator.setState("Second line");
		//save the state of memento
		caretaker.addMemento(originator.storeInMomento());
		numberOfBackups++;

		//modify the originator agaiin
		originator.setState("Third line");
		//save the state of memento
		caretaker.addMemento(originator.storeInMomento());
		numberOfBackups++;

		//restore the states
		originator.restoreFromMemento(caretaker.getMomento(--numberOfBackups));
		
		//restore the states
		originator.restoreFromMemento(caretaker.getMomento(--numberOfBackups));

		//restore the states
		originator.restoreFromMemento(caretaker.getMomento(--numberOfBackups));
	}

}
