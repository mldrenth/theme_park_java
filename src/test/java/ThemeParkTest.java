import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    private ThemePark themePark;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private Visitor visitor;

    @Before
    public void before(){
        themePark = new ThemePark();
        visitor = new Visitor(18, 1.80, 20.00);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 5);
        themePark.addToLocations(playground);
        themePark.addToLocations(rollerCoaster);
        themePark.addToLocations(candyflossStall);
    }

    @Test
    public void hasLocationsList(){
        assertEquals(3, themePark.getAllReviewed().size());
    }

    @Test
    public void canVisit(){
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
        assertEquals(true, visitor.getVisitedAttractions().contains(rollerCoaster));
    }

    @Test
    public void hasAllReviewOverview(){
        assertEquals(3, themePark.getAllReviewsHashMap().size());
    }

    @Test
    public void getAllAllowedLocations(){
        assertEquals(2, themePark.getAllAllowedFor(visitor).size());
    }


}
