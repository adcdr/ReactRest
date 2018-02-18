package model.piece;

import rule.BishopRule;

public class Bishop extends Piece {
    public Bishop(int number, PieceColor color) {
        setName("B");
        setNumber(number);
        setColor(color);
        setRule(new BishopRule());
    }
}
