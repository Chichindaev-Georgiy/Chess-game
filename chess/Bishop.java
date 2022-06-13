package chess;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
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
        if (Math.abs(line - toLine) != Math.abs(column - toColumn)) {
            return false;
        } else {
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
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
