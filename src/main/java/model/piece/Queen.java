package model.piece;

import rule.QueenRule;

public class Queen extends Piece {
    public Queen(int number, PieceColor color) {
        setName("Q");
        setNumber(number);
        setColor(color);
        setRule(new QueenRule());
    }
}
