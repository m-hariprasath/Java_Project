package service;

public interface ReservationService {
	void checkAvailability();
	void bookTickets();
	void checkTktStatus();
	void cancelTicket();
}
