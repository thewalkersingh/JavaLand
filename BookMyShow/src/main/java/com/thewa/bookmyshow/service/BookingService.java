package com.thewa.bookmyshow.service;
import com.thewa.bookmyshow.exception.BookingNotFoundException;
import com.thewa.bookmyshow.exception.BookingValidationException;
import com.thewa.bookmyshow.exception.InvalidSeatStatusException;
import com.thewa.bookmyshow.model.Booking;
import com.thewa.bookmyshow.model.Payment;
import com.thewa.bookmyshow.model.Show;
import com.thewa.bookmyshow.model.User;

public interface BookingService {
	Booking hold(User user, Show show, int noOfSeats) throws BookingValidationException;
	
	Booking book(
			User user, Booking booking,
			Payment payment) throws BookingNotFoundException, InvalidSeatStatusException,
			BookingValidationException;
	
	Booking cancel(
			User user,
			Booking booking) throws BookingValidationException, BookingNotFoundException,
			InvalidSeatStatusException;
}