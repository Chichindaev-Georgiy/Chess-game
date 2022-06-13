package chess;

public class Queen extends ChessPiece {
    public Queen(String color) {
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
        int dx = toColumn - column;
        int dy = toLine - line;
        if (Math.abs(dx) == Math.abs(dy)) {     // diagonals
            boolean checker = false;
            for (int i = 1; i < Math.abs(toLine - line); i++) {
                int newLine = line + i * Math.abs(toLine - line) / (toLine - line);
                int newColumn = column + i * Math.abs(toColumn - column) / (toColumn - column);
                checker = checker || chessBoard.board[newLine][newColumn] != null;
            } if (checker) {
                return false;
            }
            if (chessBoard.board[toLine][toColumn] != null) {
                if (chessBoard.board[toLine][toColumn].getColor().equals(getColor())) {
                    return true;
                }
            }
        } else {                                // strait lines
            boolean check = false;
            if (dx == 0 && dy != 0 || dx != 0 && dy == 0) {
                int dirY, dirX;
                if (dy != 0) {
                    dirY = Math.abs(dy) / dy;
                    for (int i = dirY; i < dy; i += dirY) {
                        check = check || chessBoard.board[line + i][toColumn] != null;
                    }
                    if (check) {
                        return false;
                    }
                    if (chessBoard.board[toLine][toColumn] != null) {
                        return !chessBoard.board[toLine][toColumn].getColor().equals(getColor());
                    }
                } else {
                    dirX = Math.abs(dx) / dx;
                    for (int i = dirX; i < dx; i += dirX) {
                        check = check || chessBoard.board[toLine][column + i] != null;
                    }
                    if (check) {
                        return false;
                    }
                    if (chessBoard.board[toLine][toColumn] != null) {
                        return !chessBoard.board[toLine][toColumn].getColor().equals(getColor());
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
