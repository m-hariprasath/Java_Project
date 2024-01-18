package entity;

public class TktDetails {
	private String tktNo="TKT";
	static int tktgenerator=1000;
	private String seatNo;
	private String from;
	private String to;
	private double price;
	private String bookDate;
	public TktDetails(String seatNo, String from, String to) {
		this.tktNo = tktNo+tktgenerator++;
		this.seatNo = seatNo;
		this.from = from;
		this.to = to;
		this.price = 200;
		this.bookDate = "23-Nov-23";
	}
	
	public String getTktNo() {
		return tktNo;
	}

	public void setTktNo(String tktNo) {
		this.tktNo = tktNo;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNO(String seatNo) {
		this.seatNo= seatNo;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	@Override
	public String toString() {
		return "TktDetails [tktNo=" + tktNo + ", seatNO=" + seatNo + ", from=" + from + ", to=" + to + ", price="
				+ price + ", bookDate=" + bookDate + "]";
	}
	
	
}
