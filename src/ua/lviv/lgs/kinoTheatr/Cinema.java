package ua.lviv.lgs.kinoTheatr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cinema {

	ArrayList<Movie> moviesLibrary = new ArrayList<>();
	Time open = new Time(9, 0);
	Time close = new Time(23, 30);

	TreeMap<Days, Schedule> schedules = new TreeMap<Days, Schedule>();
//	array with days
	Days[] mas = Days.values();

	public Cinema() {
		super();
//		full TreeMap with dayKeys
		for (int i = 0; i < mas.length; i++) {
			this.schedules.put(mas[i], new Schedule());
		}
	}

	public void schowCinema() {
		Set<Entry<Days, Schedule>> entrySet = schedules.entrySet();
		entrySet.stream().forEach(a -> {
			System.out.println("День недели - " + a.getKey());
			if (!(a.getValue() == null)) {
				a.getValue().shawSchedule();
			} else {
				System.out.println("Пока нет сеансов");
			}
		});
	}

	public void showOneDay() {
		System.out.println("Введите день недели");
		Scanner sc = new Scanner(System.in);
		String day = sc.next();
		Stream<Entry<Days, Schedule>> filterFromDay = schedules.entrySet().stream()
				.filter(f -> f.getKey().name().equalsIgnoreCase(day));
		filterFromDay.forEach(a -> a.getValue().shawSchedule());
	}

	public void addDaySchedule() {

		System.out.println("enter day : monday, tuesday, wednesday, thursday, friday, saturday, sunday");
		Scanner sc = new Scanner(System.in);
		String enterday = sc.next().toUpperCase();
		Days day = Days.valueOf(enterday);

		Schedule daySchedule = schedules.get(day);
		daySchedule.addSeance();
		schedules.put(day, daySchedule);

//		add movie to library

		Stream<Entry<Days, Schedule>> schedulesStream = schedules.entrySet().stream();
		schedulesStream.forEach(a -> {
			Schedule value = a.getValue();
			if (!(value == null)) {
				value.seances.stream().forEach(s -> {
					Movie movie = s.getMovie();					
					moviesLibrary.add(movie);					
				});
			}
		});
	};

	public void removeSeance() {
		System.out.println("Введите день недели удаляемого сеанса");
		Scanner sc1 = new Scanner(System.in);
		String day = sc1.next();
		System.out.println("Введите название удаляемого фильма");
		Scanner sc2 = new Scanner(System.in);
		String title = sc2.next();

		Iterator<Entry<Days, Schedule>> iterator = schedules.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Days, Schedule> nextDay = iterator.next();
			if (nextDay.getKey().name().equalsIgnoreCase(day)) {
				Iterator<Seance> iteratorSeances = nextDay.getValue().seances.iterator();
				while (iteratorSeances.hasNext()) {
					if (iteratorSeances.next().movie.getTitle().equalsIgnoreCase(title)) {
						iteratorSeances.remove();
					}
				}
			}
		}
	}

	public void removeAllSeance() {
		System.out.println("Введите день недели");
		Scanner sc = new Scanner(System.in);
		String day = sc.next();
		Stream<Entry<Days, Schedule>> filterByDay = schedules.entrySet().stream()
				.filter(f -> f.getKey().name().equalsIgnoreCase(day));
		filterByDay.peek(p -> p.getValue().cleanSchedule()).collect(Collectors.toSet());
	}

	public void showLibrary() {
		System.out.println("MOVIESLIBRARY");
		moviesLibrary.stream().distinct().forEach(a -> System.out.println(a));

	}

	public void removeMovie() {
		System.out.println("Введите название фильма");
		Scanner sc = new Scanner(System.in);
		String title = sc.next();

		// remove from library
		Stream<Movie> filter = moviesLibrary.stream().filter(f -> (!f.getTitle().equalsIgnoreCase(title)));
		moviesLibrary = (ArrayList<Movie>) filter.collect(Collectors.toList());

		//	remove from schedules

		Iterator<Entry<Days, Schedule>> schedulesIterator = schedules.entrySet().iterator();
		while (schedulesIterator.hasNext()) {
			Schedule value = schedulesIterator.next().getValue();
			Iterator<Seance> seanveIterator = value.seances.iterator();
			while (seanveIterator.hasNext()) {
				String movieTitle = seanveIterator.next().movie.title;
				if (movieTitle.equalsIgnoreCase(title)) {
					seanveIterator.remove();
				}
			}
		}

	}

}
