package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private MovieFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getMovieCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long movieCount = (long)em.createQuery("SELECT COUNT(r) FROM Movie r").getSingleResult();
            return movieCount;
        }finally{  
            em.close();
        }
    }
    
    public Movie getMovieById(int id){
         EntityManager em = emf.createEntityManager();
        try{
            Movie employee = em.find(Movie.class,id);
            return employee;
        }finally {
            em.close();
        }
}
    
        public List<Movie> getMovieByName(String title) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT r FROM Movie r WHERE r.title = :title");
            query.setParameter("title", title);
            List<Movie> result = query.getResultList();
            return result;
        }finally {
            em.close();
        }
    }
    
        public List<Movie> getAllMovies (){
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM Movie e");
            List<Movie> result = query.getResultList();
            return result;
        }finally {
            em.close();
        }
    }
            
        public Movie createMovie(int year, String title) {
        Movie movie = new Movie (year, title);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
            return movie;
        }finally {
            em.close();
        }
    }
        
}
