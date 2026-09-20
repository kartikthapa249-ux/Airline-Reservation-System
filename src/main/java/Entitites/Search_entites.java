package Entitites;

import java.sql.Date;
import java.sql.Time;

public class Search_entites {

	private int Flight_id;
	private String Flight_name;
	private Date Departure_date;
	private Time Departure_time;
	private Time Arrival_time;
	private String origin;
	private String Destination;
	private int Seats_available;
	private int Seat_price;
	public Search_entites() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Search_entites(int flight_id, String flight_name, Date departure_date, Time departure_time,
			Time arrival_time, String origin, String destination, int seats_available, int seat_price) {
		super();
		Flight_id = flight_id;
		Flight_name = flight_name;
		Departure_date = departure_date;
		Departure_time = departure_time;
		Arrival_time = arrival_time;
		this.origin = origin;
		Destination = destination;
		Seats_available = seats_available;
		Seat_price = seat_price;
	}
	public int getFlight_id() {
		return Flight_id;
	}
	public void setFlight_id(int flight_id) {
		Flight_id = flight_id;
	}
	public String getFlight_name() {
		return Flight_name;
	}
	public void setFlight_name(String flight_name) {
		Flight_name = flight_name;
	}
	public Date getDeparture_date() {
		return Departure_date;
	}
	public void setDeparture_date(Date departure_date) {
		Departure_date = departure_date;
	}
	public Time getDeparture_time() {
		return Departure_time;
	}
	public void setDeparture_time(Time departure_time) {
		Departure_time = departure_time;
	}
	public Time getArrival_time() {
		return Arrival_time;
	}
	public void setArrival_time(Time arrival_time) {
		Arrival_time = arrival_time;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public int getSeats_available() {
		return Seats_available;
	}
	public void setSeats_available(int seats_available) {
		Seats_available = seats_available;
	}
	public int getSeat_price() {
		return Seat_price;
	}
	public void setSeat_price(int seat_price) {
		Seat_price = seat_price;
	}
	@Override
	public String toString() {
		return "Search_entites [Flight_id=" + Flight_id + ", Flight_name=" + Flight_name + ", Departure_date="
				+ Departure_date + ", Departure_time=" + Departure_time + ", Arrival_time=" + Arrival_time + ", origin="
				+ origin + ", Destination=" + Destination + ", Seats_available=" + Seats_available + ", Seat_price="
				+ Seat_price + "]";
	}
	
	
	
}
