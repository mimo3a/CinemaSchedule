package ua.lviv.lgs.kinoTheatr;

import java.util.Scanner;

public class ApplicationCinema {
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		while(true) {
			mainMenu();
			Scanner sc = new Scanner(System.in);
			String number = sc.next();
			switch(number) {
			case"1" : cinema.schowCinema();
			break;
			case"2" : cinema.showOneDay();
			break;
			case"3" : cinema.addDaySchedule();
			break;
			case"4" : cinema.removeSeance();
			break;
			case"5" : cinema.removeAllSeance();
			break;
			case"6" :cinema.showLibrary();
			break;
			case"7" :cinema.removeMovie();
			break;
			
			
			
			} 
			
		}

		
		
		
		
		
		
	}
	static void mainMenu() {
		System.out.println("-1-Посмотреть сеансы на всю неделю");
		System.out.println("-2-Посмотреть сеансы на один день");
		System.out.println("-3-Добавить сеанс ");
		System.out.println("-4-Удалить сеанс ");
		System.out.println("-5-Удалить все сеансы на день");
		System.out.println("-6-Посмотреть фильмотеку ");
		System.out.println("-7-Удалить фильм из фильмотеки ");
		
		
	}

}
