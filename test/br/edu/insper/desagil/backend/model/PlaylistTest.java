package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private static double DELTA = 0.000001;
	private Playlist playlist;
	
	
	@BeforeEach
	void setUp() {
		playlist = new Playlist(0);
	}

	@Test
	void testRoundDownToZero() {
		playlist.putRating("Fernando", 1);
		playlist.putRating("Francisco", 2);
		playlist.putRating("Vinícius", 3);
		playlist.putRating("Luiza", 3);
		
		assertEquals(playlist.averageRatings(), 2.0, DELTA);
	}

	@Test
	void testRoundUpToHalf() {
		playlist.putRating("Fernando", 1);
		playlist.putRating("Francisco", 2);
		playlist.putRating("Vinícius", 1);
		
		assertEquals(playlist.averageRatings(), 1.5, DELTA);
	}

	@Test
	void testRoundDownToHalf() {
		playlist.putRating("Fernando", 1);
		playlist.putRating("Francisco", 2);
		playlist.putRating("Vinícius", 2);
		
		assertEquals(playlist.averageRatings(), 1.5, DELTA);
	}

	@Test
	void testRoundUpToOne() {
		playlist.putRating("Fernando", 1);
		playlist.putRating("Francisco", 1);
		playlist.putRating("Vinícius", 2);
		playlist.putRating("Luiza", 3);
		
		assertEquals(playlist.averageRatings(), 2.0, DELTA);
	}
}
