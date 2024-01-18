package serviceImpl;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ReservationApp;
import dao.Repo;
import entity.Customer;
import entity.TktDetails;
import service.ReservationService;

public class ReservationServiceImpl extends Thread implements ReservationService, Repo {
	
	ArrayList<Customer> WaitList = new ArrayList<Customer>();

	 Scanner in = new Scanner(System.in);
	
	static {
		for (int i = 1; i <= 10; i++) {
			h1.put("A"+ i, null);
		}
		TktDetails tkt1 = new TktDetails("A1", "KA", "HSR");
		Customer c1 = new Customer("Hari", 21, "M", 78965412, tkt1);
		TktDetails tkt2 = new TktDetails("A2", "KA", "HSR");
		Customer c2 = new Customer("Hari", 21, "M", 78965412, tkt2);
		TktDetails tkt3 = new TktDetails("A3", "KA", "HSR");
		Customer c3 = new Customer("Hari", 21, "M", 78965412, tkt3);
		TktDetails tkt4 = new TktDetails("A4", "KA", "HSR");
		Customer c4 = new Customer("Hari", 21, "M", 78965412, tkt4);
		TktDetails tkt5 = new TktDetails("A5", "KA", "HSR");
		Customer c5 = new Customer("Hari", 21, "M", 78965412, tkt5);
		TktDetails tkt6 = new TktDetails("A6", "KA", "HSR");
		Customer c6 = new Customer("Hari", 21, "M", 78965412, tkt6);
		TktDetails tkt7 = new TktDetails("A7", "KA", "HSR");
		Customer c7 = new Customer("Hari", 21, "M", 78965412, tkt7);
		TktDetails tkt8 = new TktDetails("A8", "KA", "HSR");
		Customer c8 = new Customer("Hari", 21, "M", 78965412, tkt8);
		TktDetails tkt9 = new TktDetails("A9", "KA", "HSR");
		Customer c9 = new Customer("Hari", 21, "M", 78965412, tkt9);
		TktDetails tkt10 = new TktDetails("A10", "KA", "HSR");
		Customer c10 = new Customer("Hari", 21, "M", 78965412, tkt10);

		h1.put("A1", c1);
		h1.put("A2", c2);
		h1.put("A3", c3);
		h1.put("A4", c4);
		h1.put("A5", c5);
		h1.put("A6", c6);
		h1.put("A7", c7);
		h1.put("A8", c8);
		h1.put("A9", c9);
		h1.put("A10", c10);
	}

	@Override
	public void checkAvailability() {
		System.out.println("===Seat Available===");
		boolean flag = false;
		for (String h : h1.keySet()) {
			if (h1.get(h) == null) {
				System.out.print(h + " ,");
				flag = true;
			}
		}
		System.out.println();
		if (!flag) {
			System.out.println("Seats are full");
		}
	}

	public Customer customer(String seat) {
		System.out.println("=======Enter the Customer Detatils========");
		System.out.println("Enter the customer name");
		String name = in.next();
		System.out.println("Enter the customer age");
		int age = in.nextInt();
		System.out.println("Enter the gender");
		String gender = in.next();
		System.out.println("Enter the phone number");
		long phno = in.nextLong();
		System.out.println("Enter the starting point");
		String from = in.next();
		System.out.println("Enter the destination");
		String to = in.next();
		TktDetails tktDetails = new TktDetails(seat, from, to);
		return new Customer(name, age, gender, phno, tktDetails);
	}

	public String seats() {
		String seat = null;
		for (String key : h1.keySet()) {
			if (h1.get(key) == null) {
				seat = key;
				break;
			}
		}
		return seat;
	}

	@Override
	synchronized public void bookTickets() {
		String seat = seats();
		Customer c = ReservationApp.c;
		Thread.currentThread().setName(c.getName());
		String th_name = Thread.currentThread().getName();
		if (seat == null) {
			try {
				System.err.println(th_name + " In Waiting state");
				WaitList.add(c);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (String key : h1.keySet()) {
				if (h1.get(key) == null) {
					seat = key;
					break;
				}
			}
			h1.put(seat, c);
			WaitList.remove(0);
			System.err.println(th_name + " Your Seat is booked with seat number " + seat);
		} else {
			h1.put(seat, c);
			System.err.println(th_name + " Your Seat is booked with seat number " + seat);
		}
	}

	@Override
	synchronized public void cancelTicket() {
		System.out.println("Enter the seat number to cancel");
		String seat = in.next();
		boolean flag = false;
		for (String h : h1.keySet()) {
			if (seat.equals(h)) {
				flag = true;
				System.out.println("Ticket has been cancelled");
				break;
			}
		}
		if (flag) {
			h1.put(seat, null);
			notify();
		}
	}

	@Override
	public void checkTktStatus() {
		System.out.println("Confirmed tickets");
		for (String s : h1.keySet()) {
			if(h1.get(s)!=null) {
				System.out.println("Seat no: "+s +"\tName: "+h1.get(s).getName());
			}
		}
		System.out.println("Waiting List");
		for (Customer customer : WaitList) {
			System.out.println(customer.getName());
		}
	}

}
