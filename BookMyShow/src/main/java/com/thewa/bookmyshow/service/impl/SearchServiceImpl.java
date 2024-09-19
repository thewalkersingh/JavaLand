package com.thewa.bookmyshow.service.impl;
import com.thewa.bookmyshow.model.Show;
import com.thewa.bookmyshow.service.SearchService;
import com.thewa.bookmyshow.service.ShowService;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {
	private final ShowService showService;
	
	public SearchServiceImpl() {
		this.showService = new ShowServiceImpl();
	}
	
	public SearchServiceImpl(ShowService showService) {
		this.showService = showService;
	}
	
	@Override
	public List<Show> search(String namePrefix, Instant date) {
		Instant start = date;
		Instant end = date.plus(Duration.ofDays(1));
		
		List<Show> shows = this.showService.getShows(start, end);
		List<Show> result = new ArrayList<>();
		
		for (Show s : shows) {
			if (s.getMovie().getName().startsWith(namePrefix)) {
				result.add(s);
			}
		}
		
		return result;
	}
}