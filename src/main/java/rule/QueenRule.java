package rule;

public class QueenRule extends BishopRule implements IRule {
    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, boolean hasMoved) {
        if (super.isValidMove(fromX, fromY, toX, toY, hasMoved))
            return true;

        if (fromX == toX || fromY == toY)
            return true;

        return false;
    }
}
