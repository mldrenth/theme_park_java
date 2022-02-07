package people;

import attractions.Attraction;
import attractions.RollerCoaster;

import java.util.ArrayList;

public class Visitor {

    private int age;
    private double height;
    private double money;
    private ArrayList<Attraction> visitedAttractions;

    public Visitor(int age, double height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
        this.visitedAttractions = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getMoney() {
        return money;
    }

    public ArrayList<Attraction> getVisitedAttractions(){
        return this.visitedAttractions;
    }

    public int getVisitedAttractionsAmount() {
        return  this.visitedAttractions.size();

    }

    public void addToVisited(Attraction attraction) {
        this.visitedAttractions.add(attraction);
    }
}
