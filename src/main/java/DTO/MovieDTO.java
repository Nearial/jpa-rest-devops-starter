package DTO;

import entities.Movie;
/**
 *
 * @author Nikolaj Larsen
 */
public class MovieDTO {
    
    long id;
    int year;
    String title;
    
    public MovieDTO(Movie m){
        this.id = m.getId();
        this.year = m.getYear();
        this.title = m.getTitle();
    }
    
}
