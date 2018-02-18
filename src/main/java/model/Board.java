package model;

import model.piece.*;

import static model.piece.PieceColor.BLACK;
import static model.piece.PieceColor.WHITE;

public class Board {
    private Piece cells[][];

    public Board() {
        cells = new Piece[8][8];

        cells[0][0] = new Rook(1, WHITE);
        cells[0][1] = new Knight(1, WHITE);
        cells[0][2] = new Bishop(1, WHITE);
        cells[0][3] = new Queen(1, WHITE);
        cells[0][4] = new King(1, WHITE);
        cells[0][5] = new Bishop(2, WHITE);
        cells[0][6] = new Knight(2, WHITE);
        cells[0][7] = new Rook(2, WHITE);
        cells[1][0] = new Pawn(1, WHITE);
        cells[1][1] = new Pawn(2, WHITE);
        cells[1][2] = new Pawn(3, WHITE);
        cells[1][3] = new Pawn(4, WHITE);
        cells[1][4] = new Pawn(5, WHITE);
        cells[1][5] = new Pawn(6, WHITE);
        cells[1][6] = new Pawn(7, WHITE);
        cells[1][7] = new Pawn(8, WHITE);

        cells[7][0] = new Rook(1, BLACK);
        cells[7][1] = new Knight(1, BLACK);
        cells[7][2] = new Bishop(1, BLACK);
        cells[7][3] = new Queen(1, BLACK);
        cells[7][4] = new King(1, BLACK);
        cells[7][5] = new Bishop(2, BLACK);
        cells[7][6] = new Knight(2, BLACK);
        cells[7][7] = new Rook(2, BLACK);
        cells[6][0] = new Pawn(1, BLACK);
        cells[6][1] = new Pawn(2, BLACK);
        cells[6][2] = new Pawn(3, BLACK);
        cells[6][3] = new Pawn(4, BLACK);
        cells[6][4] = new Pawn(5, BLACK);
        cells[6][5] = new Pawn(6, BLACK);
        cells[6][6] = new Pawn(7, BLACK);
        cells[6][7] = new Pawn(8, BLACK);
    }

    public boolean makeMove(Integer from, Integer to) {
        int fromX = from % 8;
        int fromY = from / 8;
        int toX = to % 8;
        int toY = to / 8;

        Piece srcPiece = cells[fromX][fromY];
        Piece destPiece = cells[toX][toY];

        if (srcPiece == null)
            return false;

        if (destPiece != null && destPiece.getColor() == srcPiece.getColor())
            return false;

        if (!srcPiece.getRule().isValidMove(fromX, fromY, toX, toY, srcPiece.isHasMoved()))
            return false;

        cells[fromX][fromY] = null;
        cells[toX][toY] = srcPiece;

        return true;
    }

    public Piece[][] getCells() {
        return this.cells;
    }
}
