package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Album;
import com.masai.Entity.Artist;
import com.masai.Entity.Playlist;
import com.masai.Entity.Song;
import com.masai.Entity.User;
import com.masai.Service.SpotifyService;

import jakarta.validation.Valid;

@RestController
public class SpotifyController {

	@Autowired
	private SpotifyService spotifyService;
	
	
	@PostMapping("/artist")
	@ResponseStatus(HttpStatus.CREATED)
	public void addArtist(@RequestBody @Valid Artist artist) {
		spotifyService.addArtist(artist);
	}
	
	@PostMapping("/album")
	@ResponseStatus(HttpStatus.CREATED)
	public void addAlbum(@RequestBody @Valid Album album) {
		spotifyService.addAlbum(album);
	}
	
	@PostMapping("/song")
	@ResponseStatus(HttpStatus.CREATED)
	public void addSong(@RequestBody @Valid Song song) {
		spotifyService.addSong(song);
	}
	
	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody @Valid User user) {
		spotifyService.addUser(user);
	}
	
	@PostMapping("/playlist")
	@ResponseStatus(HttpStatus.CREATED)
	public void addPlaylist(@RequestBody @Valid Playlist playlist) {
		spotifyService.addPlaylist(playlist);
	}
	
	@PutMapping("/createPlaylist/{userId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void createPlaylist(@RequestBody @Valid Playlist playlist, @PathVariable Integer userId) {
		spotifyService.createPlaylist(playlist, userId);
	}
	
	@PutMapping("/addSongToPlaylist/{playlistId}/{userId}")
	@ResponseStatus(HttpStatus.OK)
	public void addSongToPlaylist(@RequestBody @Valid Song song, @PathVariable Integer playlistId, @PathVariable Integer userId) {
		spotifyService.addSongToPlaylist(song, playlistId, userId);
	}
	
	@PatchMapping("/updatePlaylist/{playlistId}")
	@ResponseStatus(HttpStatus.OK)
	public void updatePlaylist(@RequestBody @Valid Playlist playlist, @PathVariable Integer playlistId) {
		spotifyService.updatePlaylist(playlist, playlistId);
	}
	
	@GetMapping("/user/{userId}/playlists")
	@ResponseStatus(HttpStatus.OK)
	public List<Playlist> fetchUserPlaylistHistory(@RequestBody @PathVariable Integer userId) {
		return spotifyService.fetchUserPlaylistHistory(userId);
	}
	
}
