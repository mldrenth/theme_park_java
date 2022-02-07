import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;


public class ThemePark {
    private ArrayList<IReviewed> locationsNoSecurity;
    private ArrayList<ISecurity> locationsWithSecurity;
    private HashMap<String, Integer> allReviews;

    public ThemePark() {
        this.allReviews = new HashMap<>();
        this.locationsNoSecurity = new ArrayList<>();
        this.locationsWithSecurity = new ArrayList<>();

    }

    public ArrayList<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> allLocations = new ArrayList<>();
        allLocations.addAll(locationsNoSecurity);
        allLocations.addAll(locationsWithSecurity);
        return allLocations;
    }

    public HashMap<String, Integer> getAllReviewsHashMap() {
        return this.allReviews;
    }


    public void addToLocations(IReviewed location) {
        locationsNoSecurity.add(location);
        allReviews.put(location.getName(), location.getRating());
    }

    public void addToLocations(ISecurity location) {
        locationsWithSecurity.add(location);
        allReviews.put(location.getName(), location.getRating());
    }


    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addToVisited(attraction);
        attraction.incrementVisit();
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allAllowed = new ArrayList<>();
        allAllowed.addAll(locationsNoSecurity);
        locationsWithSecurity.stream()
                .filter(location -> location.isAllowedTo(visitor))
                .forEach(allAllowed::add);
        return allAllowed;
    }
}
