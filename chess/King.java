package chess;

public class King extends ChessPiece {
    public King (String color) {
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
        if (Math.abs(toLine - line) > 1 || Math.abs(toColumn - column) > 1) {
            return false;
        } else {
            if (chessBoard.board[toLine][toColumn] != null) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(getColor());
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == line && j == column) {
                    continue;
                }
                if (chessBoard.board[i][j] == null) {
                    continue;
                }
                if (chessBoard.board[i][j].getColor().equals(getColor())) {
                    continue;
                }
                if (chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }
}
