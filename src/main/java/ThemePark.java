import attractions.Attraction;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    private ArrayList<IReviewed> locations;
    private HashMap<String , Integer> allReviews;

    public ThemePark(){
        this.locations = new ArrayList<>();
        this.allReviews = new HashMap<>();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return locations;
    }

    public HashMap<String, Integer> getAllReviewsHashMap(){
        return this.allReviews;
    }


    public void addToLocations(IReviewed location){
        locations.add(location);
        updateAllReviews();
    }

    public void updateAllReviews() {
        for (IReviewed location : locations) {
            allReviews.put(location.getName(), location.getRating());
        }
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addToVisited(attraction);
        attraction.incrementVisit();
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allAllowed = new ArrayList<>();
        for(IReviewed location : this.locations) {
            if (location instanceof ISecurity) {
                if (((ISecurity) location).isAllowedTo(visitor)){
                    allAllowed.add(location);
                }
            }
            else {
                allAllowed.add(location);
            }
        }
        return allAllowed;
    }
}
