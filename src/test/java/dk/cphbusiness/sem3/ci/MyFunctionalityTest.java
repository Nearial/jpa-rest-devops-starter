package dk.cphbusiness.sem3.ci;

import dk.cphbusiness.sem3.ci.MyFunctionality;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jens
 */
public class MyFunctionalityTest {

  @Test
  public void testFunctionality() {
    assertEquals(10, MyFunctionality.giveMeTen());
  }

}
