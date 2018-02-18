package rule;

public class PawnRule implements IRule {
    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, boolean hasMoved) {
        if (fromX == toX) {
            int dist = toY - fromY;

            if (dist == 1)
                return true;
            else if (dist == 2 && !hasMoved)
                return true;
        }

        return false;
    }
}
