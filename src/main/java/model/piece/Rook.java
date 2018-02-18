package model.piece;

import rule.RookRule;

public class Rook extends Piece {
    public Rook(int number, PieceColor color) {
        setName("R");
        setNumber(number);
        setColor(color);
        setRule(new RookRule());
    }
}
