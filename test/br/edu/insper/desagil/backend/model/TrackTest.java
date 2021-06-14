package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest {
	private Track track;
	private Artist artist1;
	private Artist artist2;
	private Artist artist3;
	private Artist artist4;
	
	@BeforeEach
	void setUp() {
		artist1 = new Artist("Anitta");
		artist2 = new Artist("Becky G");
		artist3 = new Artist("Ludmilla");
		artist4 = new Artist("Snoop Dog");
	}

	@Test
	void testZeroSeconds() {
		track = new Track(artist1, "Atencion", 0);
		assertEquals(track.getDurationString(), "0:00");
	}

	@Test
	void testFiveSeconds() {
		track = new Track(artist1, "Atencion", 5);
		assertEquals(track.getDurationString(), "0:05");
	}

	@Test
	void testTwentyFiveSeconds() {
		track = new Track(artist1, "Atencion", 25);
		assertEquals(track.getDurationString(), "0:25");
	}

	@Test
	void testOneMinuteZeroSeconds() {
		track = new Track(artist1, "Atencion", 60);
		assertEquals(track.getDurationString(), "1:00");
	}

	@Test
	void testOneMinuteFiveSeconds() {
		track = new Track(artist1, "Atencion", 65);
		assertEquals(track.getDurationString(), "1:05");
	}

	@Test
	void testOneMinuteTwentyFiveSeconds() {
		track = new Track(artist1, "Atencion", 85);
		assertEquals(track.getDurationString(), "1:25");
	}

	@Test
	void testTwoMinutesZeroSeconds() {
		track = new Track(artist1, "Atencion", 120);
		assertEquals(track.getDurationString(), "2:00");
	}

	@Test
	void testTwoMinutesFiveSeconds() {
		track = new Track(artist1, "Atencion", 125);
		assertEquals(track.getDurationString(), "2:05");
	}

	@Test
	void testTwoMinutesTwentyFiveSeconds() {
		track = new Track(artist1, "Atencion", 145);
		assertEquals(track.getDurationString(), "2:25");
	}

	@Test
	void testOneCollaborator() {
		List<Artist> collaboratorList= new ArrayList<>();
		collaboratorList.add(artist2);
		
		track = new CollaborationTrack(artist1, collaboratorList, "Atencion", 120);
		assertEquals(track.getFullArtistName(), "Anitta (feat. Becky G)");
	}

	@Test
	void testTwoCollaborators() {
		List<Artist> collaboratorList= new ArrayList<>();
		collaboratorList.add(artist3);
		collaboratorList.add(artist4);
		
		track = new CollaborationTrack(artist1, collaboratorList, "Atencion", 120);
		assertEquals(track.getFullArtistName(), "Anitta (feat. Ludmilla, Snoop Dog)");
	}
}
