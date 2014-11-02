package com.doordie.designpatterns.structural;

/**
 * PROXY pattern provide a surrogate or place-holder for 
 * another object to control access/references to it.
 * 
 * Below explained an example of Image creation in typical
 * graphic system. ImageProxy acts as a place-holder for
 * accessing actual object HighResolutionImage until its
 * absolutely necessary
 *
 */

public class Proxy {

	//Interface
	public interface Image {
		public void show();
	}
	
	//Proxy class
	public class ImageProxy implements Image {
		private String path;
		private HighResolutionImage realImage = null;
		
		public ImageProxy(String path) {
			this.path = path;
		}

		@Override
		public void show() {
			if (realImage == null)
				realImage = new HighResolutionImage(path);
			realImage.show();
		}
	}
	
	//Actual class
	public class HighResolutionImage implements Image {
		private String path;
		
		public HighResolutionImage(String path) {
			this.path = path;
		}
		
		@Override
		public void show() {
			System.out.println("Drawing HighResolutionImage from path " + path);
		}
	}
	
	//Proxy tester
	public static void main(String[] args) {
		Image image = new Proxy().new ImageProxy("/abc/xyz");
		image.show();
	}

}
