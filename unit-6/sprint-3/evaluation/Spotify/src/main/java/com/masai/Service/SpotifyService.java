package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.Entity.Album;
import com.masai.Entity.Artist;
import com.masai.Entity.Playlist;
import com.masai.Entity.Song;
import com.masai.Entity.User;
import com.masai.Exception.SpotifyException;
import com.masai.Repository.AlbumRepository;
import com.masai.Repository.ArtistRepository;
import com.masai.Repository.PlaylistRepository;
import com.masai.Repository.SongRepository;
import com.masai.Repository.UserRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SpotifyService {
	
	@Autowired
	private ArtistRepository ar;
	
	@Autowired
	private AlbumRepository alr;
	
	@Autowired
	private SongRepository sr;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private PlaylistRepository pr;
	

	public void addArtist(Artist artist) {
		log.info("Artist added successfully");
		
		if (artist==null) {
			throw new SpotifyException("artist cannot be null");
		}
		Optional<Artist> opt =  ar.findById(artist.getArtistId());
		if (opt.isPresent()) {
			throw new SpotifyException("artist already present");
		}
		ar.save(artist);
	}
	

	public void addAlbum(Album album) {
		log.info("Album added successfully");
		
		if (album==null) {
			throw new SpotifyException("artist cannot be null");
		}
		Optional<Album> opt =  alr.findById(album.getAlbumId());
		if (opt.isPresent()) {
			throw new SpotifyException("album already present");
		}
		alr.save(album);
	}
	

	public void addSong(Song song) {
		log.info("Song added successfully");
		
		if (song==null) {
			throw new SpotifyException("artist cannot be null");
		}
		Optional<Song> opt =  sr.findById(song.getSongId());
		if (opt.isPresent()) {
			throw new SpotifyException("song already present");
		}
		sr.save(song);
	}
	

	public void addUser(User user) {
		log.info("User added successfully");
		
		if (user==null) {
			throw new SpotifyException("user cannot be null");
		}
		Optional<User> opt =  ur.findById(user.getUserId());
		if (opt.isPresent()) {
			throw new SpotifyException("user already present");
		}
		ur.save(user);
	}
	

	public void addPlaylist(Playlist playlist) {
		log.info("Playlist added successfully");
		
		if (playlist==null) {
			throw new SpotifyException("user cannot be null");
		}
		Optional<Playlist> opt =  pr.findById(playlist.getPlaylistId());
		if (opt.isPresent()) {
			throw new SpotifyException("user already present");
		}
		pr.save(playlist);
	}
	

	public void createPlaylist(Playlist playlist, Integer userId) {
		log.info("Playlist created by user successfully");
		
		Optional<User> user =  ur.findById(userId);
		
		if (user.isEmpty() || playlist==null) {
			throw new SpotifyException("value cannot be null");
		}
		
		playlist.setUserId(userId);
		
		user.get().getPlaylists().add(playlist);
	}
	

	public void addSongToPlaylist(Song song, Integer playlistId, Integer userId) {
		log.info("Song added to playlist successfully");
		
		Optional<Playlist> play =  pr.findById(playlistId);
		Optional<User> user =  ur.findById(userId);
		Optional<Song> s =  sr.findById(song.getSongId());
		
		if (user.isEmpty() || play.isEmpty() || song==null) {
			throw new SpotifyException("value cannot be null");
		}
		
		List<Song> list = play.get().getSongList();
		int n = list.size();
		
		for (int i=0; i<n; i++) {
			if (list.get(i).getSongId()==s.get().getSongId()) {
				throw new SpotifyException("song already exist in the playlist");
			}
		}
		
		play.get().getSongList().add(song);
	}
	

	public void updatePlaylist(Playlist playlist, Integer playlistId) {
		log.info("Playlist details updated successfully");
		
		Optional<Playlist> play =  pr.findById(playlistId);
		
		if (play.isEmpty() || playlist==null) {
			throw new SpotifyException("value cannot be null");
		}
		
		play.get().setName(playlist.getName());
		play.get().setDescription(playlist.getDescription());
		play.get().setPrivacy(playlist.getPrivacy());
	}
	

	public List<Playlist> fetchUserPlaylistHistory(Integer userId) {
		log.info("User playlist history fetched successfully");
		
		Pageable pageable = PageRequest.of(0, 5, Sort.by("name").ascending());
		
		Optional<User> user =  ur.findById(userId);
		
		if (user.isEmpty()) {
			throw new SpotifyException("user cannot be null");
		}
		
		if (user.get().getPlaylists().isEmpty()) {
			throw new SpotifyException("playlist empty");
		}
		
		return user.get().getPlaylists();
		
	}

}
