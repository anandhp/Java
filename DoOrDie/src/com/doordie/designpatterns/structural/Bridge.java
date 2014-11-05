package com.doordie.designpatterns.structural;

/**
 * Bridge pattern decouples an abstraction from its implementation
 * allowing the two to vary independently.
 * 
 * Below is an example of Device and Remote classes where classes 
 * are organized using bride pattern
 */

public class Bridge {

	//Implementor
	public static abstract class Device {
		private int volumeLevel = 0;

		public abstract void buttonLeftPressed();
		public abstract void buttonRightPressed();
		public abstract void deviceState();
		
		public void buttonUpPressed() {
			volumeLevel++;
			System.out.println("Volume : " + volumeLevel);
		}

		public void buttonDownPressed() {
			volumeLevel--;
			System.out.println("Volume : " + volumeLevel);
		}
	}	
	
	//Concrete Implementor
	public static class TV extends Device {
		private int channelNumber  = 0;
		private int maxChannelNumber;
		
		public TV(int maxChannelNumber) {
			this.maxChannelNumber = maxChannelNumber;
		}

		@Override
		public void buttonLeftPressed() {
			channelNumber--;
			channelNumber = (channelNumber + maxChannelNumber) % maxChannelNumber;
		}
		
		@Override
		public void buttonRightPressed() {
			channelNumber++;
			channelNumber = (channelNumber + maxChannelNumber) % maxChannelNumber;
		}

		@Override
		public void deviceState() {
			System.out.println("TV: At Channel " + channelNumber);
		}
	}
	
	//Concrete Implementor
	public static class DVDPlayer extends Device {
		private int trackNumber  = 0;
		private int maxTrackNumber;
		
		public DVDPlayer(int maxTrackNumber) {
			this.maxTrackNumber = maxTrackNumber;
		}

		@Override
		public void buttonLeftPressed() {
			trackNumber--;
			trackNumber =(trackNumber + maxTrackNumber) % maxTrackNumber;
		}
		
		@Override
		public void buttonRightPressed() {
			trackNumber++;
			trackNumber = (trackNumber + maxTrackNumber) % maxTrackNumber;
		}

		@Override
		public void deviceState() {
			System.out.println("DVD Player: Playing " + trackNumber);
		}
	}
	
	//Abstraction
	public static abstract class Remote {
		private Device theDevice;
		
		public Remote(Device device) {
			theDevice = device;
		}
		
		public void buttonLeftPressed() {
			theDevice.buttonLeftPressed();
			theDevice.deviceState();
		}

		public void buttonRightPressed() {
			theDevice.buttonRightPressed();
			theDevice.deviceState();
		}
	}
	
	//Refined Abstraction
	public static class TVRemote extends Remote{

		public TVRemote(Device device) {
			super(device);
		}
	}

	public static class DVDPlayerRemote extends Remote{

		public DVDPlayerRemote(Device device) {
			super(device);
		}
	}
	
	//Bridge pattern tester
	public static void main(String[] args) {
		Remote tvRemote = new TVRemote(new TV(100));
		Remote dvdRemote = new DVDPlayerRemote(new DVDPlayer(30));
		
		System.out.println("Playing with TV Remote");
		tvRemote.buttonLeftPressed();
		tvRemote.buttonRightPressed();
		tvRemote.buttonLeftPressed();
		tvRemote.buttonLeftPressed();
		tvRemote.buttonLeftPressed();
		
		System.out.println("\nPlaying with TV Remote");
		dvdRemote.buttonLeftPressed();
		dvdRemote.buttonRightPressed();
		dvdRemote.buttonLeftPressed();
		dvdRemote.buttonLeftPressed();
		dvdRemote.buttonLeftPressed();
	}
}
