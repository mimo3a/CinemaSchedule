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
		System.out.println("-1-���������� ������ �� ��� ������");
		System.out.println("-2-���������� ������ �� ���� ����");
		System.out.println("-3-�������� ����� ");
		System.out.println("-4-������� ����� ");
		System.out.println("-5-������� ��� ������ �� ����");
		System.out.println("-6-���������� ���������� ");
		System.out.println("-7-������� ����� �� ���������� ");
		
		
	}

}
