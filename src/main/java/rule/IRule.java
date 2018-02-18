package rule;

import java.awt.*;

public interface IRule {
    boolean isValidMove(int fromX, int fromY, int toX, int toY, boolean hasMoved);
}
