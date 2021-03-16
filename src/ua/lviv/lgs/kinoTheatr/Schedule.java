package ua.lviv.lgs.kinoTheatr;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Schedule {
	Set<Seance> seances = new TreeSet<>();

	Time close = new Time(23, 30);
	Time start = new Time(9, 0);

	public void addSeance() {
		System.out.println("Enter name of movie");
		Scanner sc = new Scanner(System.in);
		String nameMovie = sc.next();

		System.out.println("Enter duration of movie (Uhr)");
		Scanner sc1 = new Scanner(System.in);
		double durationUhr = sc1.nextDouble();

		System.out.println("Enter duraion of movie (Min)");
		Scanner sc2 = new Scanner(System.in);
		double durationMin = sc2.nextDouble();

		// how match minutes to close cinema
		// how long the movie min
		Double lastTime = (close.getHour() * 60 + close.getMin()) - (start.getHour() * 60 + start.getMin());
		Double durMinuts = durationUhr * 60 + durationMin;
//		System.out.println("lastTime = " + lastTime);
//		System.out.println("durMinuts =" + durMinuts);
		if (lastTime - durMinuts > 0) {
			Time durationTime1 = new Time(durationUhr, durationMin);
			Movie mov = new Movie(nameMovie, durationTime1);
			Seance snc = new Seance(mov, start);
			seances.add(snc);
			start = snc.getEndTime();
		} else {
			System.out.println("The Movie is too long");
		}
	}

	public void removeSeance() {
		System.out.println("Enter the name of movie");
		Scanner sc = new Scanner(System.in);
		String deletedMovie = sc.next();

		Stream<Seance> filter = seances.stream().filter(s -> !s.movie.title.equalsIgnoreCase(deletedMovie));
		seances = filter.collect(Collectors.toCollection(TreeSet::new));
		shawSchedule();
	}

	public void cleanSchedule() {
		seances.clear();
		shawSchedule();
	}

	public void shawSchedule() {
		System.out.println("SCHEDULE");
		seances.stream().forEach(s -> System.out.println(s));
	}

	@Override
	public String toString() {
		return "Schedule [seances=" + seances + "]";
	}

}
