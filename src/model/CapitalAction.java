package model;

public class CapitalAction {
	
	private String date;
	private double price;
	private double open;
	private double high;
	private double low;
	private String vol;
	private double change;
	
	public CapitalAction(String date, double price, double open, double high, double low, String vol, double change ) {
		
		this.date = date;
		this.price = price;
		this.open = open;
		this.high = high;
		this.low = low;
		this.vol = vol;
		this.change = change;
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public String getVol() {
		return vol;
	}

	public void setVol(String vol) {
		this.vol = vol;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}
	
	public String toString() {
		
		String toS = " ";
		toS = "The information of the action is: \nDate: "+date+"\nPrice: "+price+"\nOpen: " +open+"\nHigh: "+high+"\nLow: "+low+"\nVol: "+vol+"\nChange: "+change+"%";
		
		return toS;
	}

}
