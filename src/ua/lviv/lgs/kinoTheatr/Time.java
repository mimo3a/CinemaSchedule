package ua.lviv.lgs.kinoTheatr;

public class Time {
	double min;
	double hour;
	public Time(double hour, double min) {
		super();
		this.min = min;
		this.hour = hour;
	}
	
	public void addPause() {
		min += 15;
		
	}
	public double getMin() {
		return min;
	}
	public double getHour() {
		return hour;
	}
	
	public void setHour(double hour) {
		this.hour = hour;
	}
	
	public void setMin(double min) {
		this.min = min;
	}
	@Override
	public String toString() {
		return (int)hour + ":" + (int)min;
	}
	
}
