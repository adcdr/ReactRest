package model.piece;

import rule.KnightRule;

public class Knight extends Piece {
    public Knight(int number, PieceColor color) {
        setName("N");
        setNumber(number);
        setColor(color);
        setRule(new KnightRule());
    }
}
