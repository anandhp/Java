package com.doordie.designpatterns.structural;

/**
 * Proxy Pattern example 
 * 
 * The intent of this pattern is to provide a placeholder
 * for an object to control references to it.
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
