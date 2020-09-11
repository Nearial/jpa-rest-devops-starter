package DTO;

import entities.Movie;
/**
 *
 * @author Nikolaj Larsen
 */
public class MovieDTO {
    
    int id;
    int Ryear;
    String title;
    
    public MovieDTO(Movie m){
        this.id = m.getId();
        this.Ryear = m.getRYear();
        this.title = m.getTitle();
    }
    
}
