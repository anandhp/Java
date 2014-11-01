package com.doordie.designpatterns.behavioral;

public class TemplateMethod {
	
	//Abstract class having Template method
	//And abstract primitive methods 
	public abstract class ConsolePrinter {
		//template method
		public final void print() {
			//read data to be printed
			String data = readData();
			
			//format data
			String formattedData = formatData(data);
			
			//write to console
			System.out.println(formattedData);
		}
		
		public abstract String readData();
		public abstract String formatData(String data);
	}
	
	//Concrete classes implementing primitive methods
	public class CSVPrinter extends ConsolePrinter {
		
		private String data = null;
		
		@Override
		public String readData() {
			data = "One,Two,Three";
			return data;
		}

		@Override
		public String formatData(String data) {
			return data.replaceAll("\\,", "\t");
		}
	}
	
	
	public class CustomSeparatorPrinter extends ConsolePrinter {
		
		private String data = null;
		
		@Override
		public String readData() {
			data = "One|Two|Three";
			return data;
		}

		@Override
		public String formatData(String dataToFormat) {
			return dataToFormat.replaceAll("\\|", "\t");
		}
	}
	
	
	public static void main(String[] args) {
		ConsolePrinter printer = new TemplateMethod().new CSVPrinter();
		printer.print();
		
		printer = new TemplateMethod().new CustomSeparatorPrinter();
		printer.print();
	}
}
