import attractions.Attraction;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import people.Visitor;

import java.util.ArrayList;

public class ThemePark {
    private ArrayList<IReviewed> locations;

    public ThemePark(){
        this.locations = new ArrayList<>();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return locations;
    }

    public void addToLocations(IReviewed location){
        locations.add(location);
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addToVisited(attraction);
        attraction.incrementVisit();
    }
}
