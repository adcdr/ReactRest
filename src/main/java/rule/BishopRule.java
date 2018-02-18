package rule;

public class BishopRule implements IRule {
    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, boolean hasMoved) {
        if (Math.abs(fromX - toX) == Math.abs(fromY - toY))
            return true;

        return false;
    }
}
