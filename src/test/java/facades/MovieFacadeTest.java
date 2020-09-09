package facades;

import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entities.Movie;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class MovieFacadeTest {

    private static EntityManagerFactory emf;
    private static MovieFacade facade;
    private static List<Movie> fisk;

    public MovieFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = MovieFacade.getMovieFacade(emf);
       fisk = new ArrayList();
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();

        fisk.add(new Movie(1982,"The Thing"));
        fisk.add(new Movie(1981, "Escape from New York"));
        fisk.add(new Movie(1996, "Escape from L.A"));
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Movie.deleteAllRows").executeUpdate();
            em.persist(fisk.get(0));
            em.persist(fisk.get(1));
            em.persist(fisk.get(2));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown(){
        fisk.clear();
    }
    
    @Test
    public void testMovieCount() {
        assertEquals(3, facade.getMovieCount(), "Expects three rows in the database");
    }
    
    @Test
    public void testGetMovieByName(){
        List<Movie> eList = new ArrayList(); 
        Movie expected = new Movie(1982,"The Thing");
        eList.add(expected);
        
        List<Movie> actual = facade.getMovieByName("The Thing"); 
        
        assertEquals(eList, actual);
    }
    
    @Test
    public void testGetAllMovies(){
        List<Movie> eList = new ArrayList();
        Movie m1 = new Movie(1982, "The Thing");
        Movie m2 = new Movie(1981, "Escape from New York");
        Movie m3 = new Movie(1996, "Escape from L.A");
        eList.add(m1);
        eList.add(m2);
        eList.add(m3);
        
        List<Movie> actual = facade.getAllMovies();
        
        assertThat("List equality without order", actual, containsInAnyOrder(eList.toArray()));
    }
    
    @Test
    public void testGetMovieById(){
        Movie expected = fisk.get(0);
        
        Movie actual = facade.getMovieById(expected.getId());
        
        assertEquals(expected, actual);
    }
}
