package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }


    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return visitor.getHeight() >= 1.45 && visitor.getAge() >= 12;
    }

    @Override
    public double defaultPrice() {
        return 8.40;
    }

    @Override
    public double priceFor(Visitor visitor) {
        return visitor.getHeight() >= 2.00 ? defaultPrice() * 2 : defaultPrice();
    }
}
