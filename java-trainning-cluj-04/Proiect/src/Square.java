import javax.swing.*;

public class Square extends JButton {
    private Piece piece;
    private boolean isBusy;
    private int squareNumber;

    public Square(int x, int y, int squareNumber) {
        super();
        setSize(64, 64);
        setLocation(x, y);
        this.isBusy = false;
        this.squareNumber = squareNumber;
    }

    public Square(Piece piece, int x, int y, int squareNumber) {
        super();
        setSize(64, 64);
        setLocation(x, y);
        this.piece = piece;
        ImageIcon imageIcon = this.piece.getIcon();
        setIcon(imageIcon);
        this.isBusy = true;
        this.squareNumber = squareNumber;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public int getSquareNumber() {
        return squareNumber;
    }
}
