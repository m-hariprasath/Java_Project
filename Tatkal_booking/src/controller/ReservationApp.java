package controller;

import java.util.Scanner;
import entity.Customer;
import service.ReservationService;
import serviceImpl.ReservationServiceImpl;
import threads.BookingStatus;

public class ReservationApp {
	public static Customer c;
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		ReservationService r = new ReservationServiceImpl();
		System.out.println("======> 2306 KA-TN express <======");
		while (true) {
			System.out.println("------> Facilities available<------");
			System.out.println(
					"1.Check seats avilability\n2.Book Tickets\n3.Check ticket status\n4.CancelTicket\n5.Exit");
			System.out.println("Enter the option");
			int n = ip.nextInt();
			switch (n) {
			case 1:
				r.checkAvailability();
				break;
			case 2:{
				ReservationServiceImpl rr=new ReservationServiceImpl();
				String seat=rr.seats();
				c=rr.customer(seat);
				BookingStatus book = new BookingStatus((ReservationServiceImpl) r);
				book.start();
			}
				break;
			case 3:
				r.checkTktStatus();
				break;
			case 4:
				r.cancelTicket();
				break;
			case 5:
				System.out.println("Thanks for visting us :)");
				System.exit(0);
				break;
			default:
				System.err.println("-->Invalid option<--");
				break;
				
			}
		}
	}
}
