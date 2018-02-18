package model.piece;

import rule.KingRule;

public class King extends Piece {
    public King(int number, PieceColor color) {
        setName("K");
        setNumber(number);
        setColor(color);
        setRule(new KingRule());
    }
}
