package chess;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!checkPositions(line, column, toLine, toColumn) || line == toLine && column == toColumn) {
            return false;
        }
        int dy = toLine - line;
        int dx = toColumn - column;
        boolean checker = false;
        if (dx == 0 && dy != 0 || dx != 0 && dy == 0) {
            int dirY, dirX;
            if (dy != 0) {
                dirY = Math.abs(dy) / dy;
                for (int i = dirY; i < dy; i += dirY) {
                    checker = checker || chessBoard.board[line + i][toColumn] != null;
                }
                if (checker) {
                    return false;
                }
                if (chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(getColor());
                }
            } else {
                dirX = Math.abs(dx) / dx;
                for (int i = dirX; i < dx; i += dirX) {
                    checker = checker || chessBoard.board[toLine][column + i] != null;
                }
                if (checker) {
                    return false;
                }
                if (chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(getColor());
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
