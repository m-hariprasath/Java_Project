package threads;

import serviceImpl.ReservationServiceImpl;

public class BookingStatus extends Thread {
	ReservationServiceImpl r1;
	
	public BookingStatus(ReservationServiceImpl r1) {
		this.r1 = r1;
	}
	@Override
	public void run()
	{
		r1.bookTickets();
	}
}
