package ua.lviv.lgs.kinoTheatr;

public class Seance implements Comparable<Seance>{
	Movie movie;
	Time startTime;
	Time endTime;
	public Seance(Movie movie, Time startTime) {
		super();
		this.movie = movie;
		this.startTime = startTime;
				
		double startmin = startTime.getHour()*60+startTime.getMin();
		double endmin = startmin + (movie.duration.getHour()*60 + movie.duration.getMin());		
		double hourRound = Math.floor(endmin/60);				
		
		this.endTime = new Time(hourRound,endmin%60);
		

	}
	public Movie getMovie() {
		return movie;
	}
	public Time getStartTime() {
		return startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return "Seance [movie=" + movie + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	@Override
	public int compareTo(Seance s) {
		// TODO Auto-generated method stub
		 if(this.startTime.getHour() < s.startTime.getHour()) {
			 return -1;
		 }else if (this.startTime.getHour() > s.startTime.getHour()) {
			 return 1;
		 } else {
			 return 0;
		 }
	}
	
	

}
