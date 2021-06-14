package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTrack extends Track {
	
	private List<Artist> collaborators;

	public CollaborationTrack(Artist artist, List<Artist> collaborators, String name, Integer duration) {
		super(artist, name, duration);
		this.collaborators = collaborators;
	}
	
	@Override
	public String getFullArtistName() {
		String fullName = "";
		List<String> collaboratorsName = new ArrayList<>();
		
		for (Artist artist : collaborators) {
			collaboratorsName.add(artist.getName());
		}
		
		fullName += this.getArtist().getName() + " (feat. ";
		fullName += String.join(", ", collaboratorsName) + ")";

		return fullName;
	}

}
