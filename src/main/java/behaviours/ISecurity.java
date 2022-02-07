package behaviours;

import people.Visitor;

public interface ISecurity extends IReviewed {

    boolean isAllowedTo(Visitor visitor);
}
