package chess;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(checkPositions(line, column, toLine, toColumn)) || line == toLine && column == toColumn ||
            chessBoard.board[line][column] == null) {   // sanity check
            return false;
        }
        int dir;
        if (chessBoard.board[line][column].getColor().equals("White")) {
            dir = 1;
        } else {
            dir = -1;
        }
        if (column == toColumn) {
            if (toLine - line == dir) {
                return chessBoard.board[toLine][toColumn] == null;
            } else {
                if (getColor().equals("White") && line != 1 && toLine != 3 ||
                    getColor().equals("Black") && line != 6 && toLine != 4) {
                    return false;
                } else {
                    return chessBoard.board[line + dir][toColumn] == null &&
                           chessBoard.board[toLine][toColumn] == null;
                }
            }
        } else if (Math.abs(toColumn - column) != 1) {
            return false;
        } else {
            if (chessBoard.board[toLine][toColumn] == null) {
                return false;
            } else {
                return toLine - line == dir || !chessBoard.board[toLine][toColumn].getColor().equals(getColor());
            }
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
