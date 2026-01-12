package behavioral.visitor.exporter.visitor;

import behavioral.visitor.exporter.shapes.Circle;
import behavioral.visitor.exporter.shapes.CompoundShape;
import behavioral.visitor.exporter.shapes.Dot;
import behavioral.visitor.exporter.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
