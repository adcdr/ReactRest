package rule;

public class RookRule implements IRule {
    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, boolean hasMoved) {
        if (fromX    == toX || fromY == toY)
            return true;

        return false;
    }
}
