package com.thewa.bookmyshow.service;
import com.thewa.bookmyshow.model.Show;

import java.time.Instant;
import java.util.List;

public interface ShowService {
	void addShow(Show show);
	
	List<Show> getShows(Instant start, Instant end);
}