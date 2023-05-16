package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ArtistService {

    // Hint: Make use of Setter Injection to inject ArtworkMap and artistList.

    private Map<Artist, Artwork> artworkMap; // inject 4 entries with valid details

    private List<Artist> artistList; // inject List of 6 Artist object

    
    public void setArtworkMap(Map<Artist, Artwork> artworkMap) {
		this.artworkMap = artworkMap;
	}


	public void setArtistList(List<Artist> artistList) {
		this.artistList = artistList;
	}
	


	public void printArtworkMap() {
        // print all the artists and their artwork details from the artworkMap
    	for (Map.Entry<Artist, Artwork> entry : artworkMap.entrySet()) {
    		System.out.println(entry.getKey().getName() + " is the artist of " + entry.getValue().getName());
    	}
    }

    
    public void printArtistList() {
        // sort the List of Artists according to the decreasing order of the noOfArtworks Created
        // If the number of artworks is the same, then sort by age
        // print all the sorted Artist Details
    	artistList.sort((a1,a2) -> {
    		if (a1.getNoOfArtworksCreated() != a2.getNoOfArtworksCreated()) {
    			return a2.getNoOfArtworksCreated() - a1.getNoOfArtworksCreated();
    		}
    		return a1.getAge() - a2.getAge();
    	});
    	
    	for (Artist element : artistList) {
    		System.out.println(element.getName() + " is the creator of " + element.getNoOfArtworksCreated() + " artworks at age " + element.getAge());
    	}
    }

    
    public double averageAgeOfArtistsWithArtworks(int minArtworks) {
        // Calculate the average age of the artists who have created more than 'minArtworks' artworks
    	List<Artist> artists = artistList.stream().filter(element -> element.getNoOfArtworksCreated() > minArtworks).collect(Collectors.toList());
    	if (artists.isEmpty()) {
    		return 0;
    	}
    	else return (artists.stream().mapToInt(Artist::getAge).sum())/artists.size();
    }


    public List<Artist> topArtistsByArtworks(int n) {
        // Find the top 'n' artists based on the number of artworks created, and sort them by age in case of a tie
    	List<Artist> top = artistList.stream().sorted((a1,a2) -> {
        	if (a1.getNoOfArtworksCreated() != a2.getNoOfArtworksCreated()) {
    			return a2.getNoOfArtworksCreated() - a1.getNoOfArtworksCreated();
    		}
    		return a1.getAge() - a2.getAge();
        }).limit(n).collect(Collectors.toList());
    	
    	return top;
    }
    

    
    public List<Artwork> topArtworksByCreationTime(int n) {
        // Find the top 'n' artworks based on creation time, and return the artwork information as a Map
    	List<Artwork> art = new ArrayList<>(artworkMap.values());
    	art.sort((a1, a2) -> a2.getCreationTime() - a1.getCreationTime());
    	
    	return art.subList(0, Math.min(n, art.size()));
    }
    
}
