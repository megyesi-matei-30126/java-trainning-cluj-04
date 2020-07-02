import javax.swing.*;

public interface Piece {
    void setX(int x);

    void setY(int y);

    void calculateMoves(int x, int y);

    int[] calculateMoves2(int x, int y, Square[][] squares);

    boolean isBlack();

    ImageIcon getIcon();
}
