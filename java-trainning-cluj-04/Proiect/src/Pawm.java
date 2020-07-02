import javax.swing.*;
import java.awt.*;

public class Pawm implements Piece {
    private ImageIcon image;
    private boolean isBlack;
    private int x;
    private int y;

    public Pawm(boolean isBlack, int x, int y) {
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
            this.image = new ImageIcon("src/ImaginiPiese/pionNegru.png");
        } else {
            this.image = new ImageIcon("src/ImaginiPiese/pionAlb.png");
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
       /* Moves.moves.clear();
        for (int i = y - 1; i <= y + 1; i++) {
            if (i < 0 || i > 7) {
                continue;
            }
            if (this.isBlack) {
                if (y != i && Table.squares[x + 1][i].isBusy()) {
                    Moves.moves.add(new Pair<>(x + 1, i));
                } else if (y == i){
                    Moves.moves.add(new Pair<>(x + 1, i));
                }
            } else {
                if (y != i && Table.squares[x - 1][i].isBusy()) {
                    Moves.moves.add(new Pair<>(x - 1, i));
                } else if (y == i) {
                    Moves.moves.add(new Pair<>(x - 1, i));
                }
            }
        }*/

    }

    @Override
    public int[] calculateMoves2(int x, int y, Square[][] squares) {
       // IntStream.range(0, 8).mapToObj(x -> IntStream.range(0, 8).m)
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
