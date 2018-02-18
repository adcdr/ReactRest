package rule;

public class KnightRule implements IRule {
    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, boolean hasMoved) {
        int distX = Math.abs(toX - fromX);
        int distY = Math.abs(toY - fromY);

        if ((distX + distX) == 4)
            if ((distX == 3 && distY == 1) || (distY == 3 && distX == 1))
                return true;

        return false;
    }
}
