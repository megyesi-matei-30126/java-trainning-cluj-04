import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;

public class King implements Piece {
    private ImageIcon image;
    private boolean isBlack;
    private int x;
    private int y;

    public King(boolean isBlack, int x, int y) {
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
            this.image = new ImageIcon("src/ImaginiPiese/regeNegru.png");
        } else {
            this.image = new ImageIcon("src/ImaginiPiese/regeAlb.png");
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
      /*  Moves.moves.clear();
        if (x == 0) {
            if (y != 0 && y != 7) {
                for (int j = 0, i = y + 1; j < 3; j++, i--) {
                    if (i != y) {
                        Moves.moves.add(new Pair<>(x, i));
                    }
                    Moves.moves.add(new Pair<>(x + 1, i));
                }
            } else if (y == 7) {
                Moves.moves.add(new Pair<>(0, 6));
                Moves.moves.add(new Pair<>(1, 6));
                Moves.moves.add(new Pair<>(1, 7));
            } else {
                Moves.moves.add(new Pair<>(0, 1));
                Moves.moves.add(new Pair<>(1, 0));
                Moves.moves.add(new Pair<>(1, 1));
            }
        } else if (x == 7) {
            if (y != 0 && y != 7) {
                for (int j = 0, i = y + 1; j < 3; j++, i--) {
                    if (i != y) {
                        Moves.moves.add(new Pair<>(x, i));
                    }
                    Moves.moves.add(new Pair<>(x - 1, i));
                }
            } else if (y == 7) {
                Moves.moves.add(new Pair<>(6, 6));
                Moves.moves.add(new Pair<>(6, 7));
                Moves.moves.add(new Pair<>(7, 6));
            } else {
                Moves.moves.add(new Pair<>(6, 1));
                Moves.moves.add(new Pair<>(6, 0));
                Moves.moves.add(new Pair<>(7, 1));
            }
        } else if (y == 0) {
            for (int i = 0, j = x - 1; i < 3; i++, j++) {
                if (j != x) {
                    Moves.moves.add(new Pair<>(j, y));
                }
                Moves.moves.add(new Pair<>(j, y + 1));
            }
        } else if (y == 7) {
            for (int j = 0, i = x - 1; j < 3; j++, i++) {
                if (i != x) {
                    Moves.moves.add(new Pair<>(i, y));
                }
                Moves.moves.add(new Pair<>(i, y - 1));
            }
        } else {
            for (int i = 0, j = y + 1; i < 3; i++, j--) {
                if (j != y) {
                    Moves.moves.add(new Pair<>(x, j));
                }
                Moves.moves.add(new Pair<>(x - 1, j));
                Moves.moves.add(new Pair<>(x + 1, j));
            }
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
