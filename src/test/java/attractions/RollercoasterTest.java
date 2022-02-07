package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void minHeight145(){
        Visitor tall = new Visitor(17, 1.45, 20.00);
        Visitor small = new Visitor(17, 1.40, 20.00);
        assertEquals(true,rollerCoaster.isAllowedTo(tall));
        assertEquals(false, rollerCoaster.isAllowedTo(small));
    }

    @Test
    public void minAge12(){
        Visitor old = new Visitor(17, 1.45, 20.00);
        Visitor young = new Visitor(11, 1.45, 20.00);
        assertEquals(true,rollerCoaster.isAllowedTo(old));
        assertEquals(false, rollerCoaster.isAllowedTo(young));
    }

    @Test
    public void doubleFeeForTallVisitors(){
        Visitor tall = new Visitor(17, 2.01, 20.00);
        Visitor small = new Visitor(17, 1.45, 20.00);
        assertEquals(16.80,rollerCoaster.priceFor(tall), 0.00);
        assertEquals(8.40, rollerCoaster.priceFor(small), 0.00);
    }
}
