package rule;

public class KingRule implements IRule {
    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, boolean hasMoved) {
        if (Math.abs(fromX - toX) == 1 || Math.abs(fromY - toY) == 1)
            return true;

        return false;
    }
}
