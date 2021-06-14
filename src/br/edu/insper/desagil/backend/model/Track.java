package br.edu.insper.desagil.backend.model;

public class Track {
	
	private Artist artist;
	private String name;
	private int duration;
	
	public Track(Artist artist, String name, Integer duration) {
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}

	public Artist getArtist() {
		return artist;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}
	
	public String getDurationString() {
		int minutes = this.duration / 60;
		int fullSeconds = this.duration % 60;
		int secondsTens = fullSeconds / 10;
		int secondsOnes = fullSeconds % 10;
		
		return Integer.toString(minutes) + ":" + Integer.toString(secondsTens) + Integer.toString(secondsOnes);
	}
	
	public String getFullArtistName() {
		return this.artist.getName();
	}

}
