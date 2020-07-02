import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;

public class Rook implements Piece {
    private ImageIcon image;
    private boolean isBlack;
    private int x;
    private int y;

    public Rook(boolean isBlack, int x, int y) {
        this.isBlack = isBlack;
        this.x = x;
        this.y = y;
        blackWhitePiece();
        Image img = this.image.getImage();
        Image img2 = img.getScaledInstance(64, 60, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(img2);
    }

    private void blackWhitePiece() {
        if (isBlack()) {
            this.image = new ImageIcon("src/ImaginiPiese/turaNegru.png");
        } else {
            this.image = new ImageIcon("src/ImaginiPiese/turaAlb.png");
        }
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void calculateMoves(int x, int y) {
        /*  Moves.moves.clear();*/
    /*    if (isBlack()) {
            for (int i = x, j = x; i < 8; i++, j--) {
                Moves.moves.add(new Pair<>(i, y));
                if (j >= 0) {
                    Moves.moves.add(new Pair<>(j, y));
                }
            }
            for (int i = y; i < 8; i++) {
                Moves.moves.add(new Pair<>(x, i));
            }
        }
        for (Pair<Integer, Integer> pair : Moves.moves) {
            System.out.println(pair);
        }*/
    }

    @Override
    public int[] calculateMoves2(int x, int y, Square[][] squares) {
        return null;
    }

    @Override
    public boolean isBlack() {
        return this.isBlack;
    }

    @Override
    public ImageIcon getIcon() {
        return this.image;
    }
}
