package com.thewa.bookmyshow.model;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class Show {
	private final String id;
	private final Hall hall;
	private final Movie movie;
	private final ShowPrice showPrice;
	private final long startTime; // millisecond format
	private final long endTime; // millisecond format
	private final ReentrantLock lock;
	
	public Show(Hall hall, Movie movie, ShowPrice showPrice, long start, long end) {
		this.id = UUID.randomUUID().toString();
		this.hall = hall;
		this.movie = movie;
		this.showPrice = showPrice;
		this.startTime = start;
		this.endTime = end;
		this.lock = new ReentrantLock();
	}
	
	public Hall getHall() {
		return hall;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public ShowPrice getShowPrice() {
		return showPrice;
	}
	
	public long getStartTime() {
		return startTime;
	}
	
	public long getEndTime() {
		return endTime;
	}
	
	public ReentrantLock getLock() {
		return lock;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, this.hall.hashCode(), this.movie.hashCode());
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		
		if (this == o) {
			return true;
		}
		
		Show other = (Show) o;
		return this.id.equals(other.id);
	}
	
	@Override
	public String toString() {
		return "Show: " + "Movie: " + movie.getName() + " @ Hall: " + hall.getId() + " @ Cinema: " +
		       hall.getCinema().getName() + " Start Time = " + Instant.ofEpochMilli(startTime);
	}
}