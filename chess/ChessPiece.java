package chess;

public abstract class ChessPiece {
    protected String color;
    protected boolean check;

    public ChessPiece (String color) {
        check = true;
        this.color = color;
    }

    protected boolean isInsideBoard(int pos) {
        return pos >= 0 && pos <= 7;
    }

    protected boolean checkPositions(int line, int column, int toLine, int toColumn) {
        return isInsideBoard(line) && isInsideBoard(column) && isInsideBoard(toLine) && isInsideBoard(toColumn);
    }

    public abstract String getColor();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();
}