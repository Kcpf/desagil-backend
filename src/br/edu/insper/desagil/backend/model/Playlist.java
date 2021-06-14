package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
	
	private int id;
	private List<Track> tracks;
	private Map<String, Integer> ratings;
	
	public Playlist(int id) {
		this.id = id;
		this.tracks = new ArrayList<>();
		this.ratings = new HashMap<>();
	}

	public int getId() {
		return id;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public Map<String, Integer> getRatings() {
		return ratings;
	}
	
	public void addTrack(Track track) {
		this.tracks.add(track);
	}
	
	public void putRating(String username, int rating) {
		this.ratings.put(username, rating);
	}
	
	public double averageRatings() {
		double simpleAverage = 0;
		
		for (Integer rating : this.ratings.values()) {
			simpleAverage += rating;
		}
		
		simpleAverage = simpleAverage / (double) this.ratings.size();
		
		int i = (int) simpleAverage;
		double d = simpleAverage - i;
		
		if (d < 0.26) return simpleAverage - d;
		if (d >= 0.26 && d < 0.74) return (simpleAverage - d) + 0.5;
		
		return (simpleAverage - d) + 1;
	}

}
