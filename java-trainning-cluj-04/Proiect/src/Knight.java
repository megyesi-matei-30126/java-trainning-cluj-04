import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;

public class Knight implements Piece {
    private ImageIcon image;
    private boolean isBlack;
    private int x;
    private int y;

    public Knight(boolean isBlack, int x, int y) {
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
            this.image = new ImageIcon("src/ImaginiPiese/calNegru.png");
        } else {
            this.image = new ImageIcon("src/ImaginiPiese/calAlb.png");
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
        if (x == 0) {
            if (y > 1 && y < 6) {
                for (int i = 0, j = y - 1, k = y - 2; i < 2; i++, j += 2, k += 4) {
                    Moves.moves.add(new Pair<>(x + 2, j));
                    Moves.moves.add(new Pair<>(x + 1, k));
                }
            } else if (y == 1) {
                Moves.moves.add(new Pair<>(2, 0));
                Moves.moves.add(new Pair<>(2, 2));
                Moves.moves.add(new Pair<>(1, 3));
            } else if (y == 6) {
                Moves.moves.add(new Pair<>(2, 5));
                Moves.moves.add(new Pair<>(2, 7));
                Moves.moves.add(new Pair<>(1, 4));
            } else if (y == 0) {
                Moves.moves.add(new Pair<>(1, 2));
                Moves.moves.add(new Pair<>(2, 1));
            } else {
                Moves.moves.add(new Pair<>(1, 5));
                Moves.moves.add(new Pair<>(2, 6));
            }
        } else if (x == 7) {
            if (y > 1 && y < 6) {
                for (int i = 0, j = y - 1, k = y - 2; i < 2; i++, j += 2, k += 4) {
                    Moves.moves.add(new Pair<>(x - 2, j));
                    Moves.moves.add(new Pair<>(x - 1, k));
                }
            } else if (y == 1) {
                Moves.moves.add(new Pair<>(5, 0));
                Moves.moves.add(new Pair<>(5, 2));
                Moves.moves.add(new Pair<>(6, 3));
            } else if (y == 6) {
                Moves.moves.add(new Pair<>(5, 5));
                Moves.moves.add(new Pair<>(5, 7));
                Moves.moves.add(new Pair<>(6, 4));
            }
            else if (y == 0) {
                Moves.moves.add(new Pair<>(5, 1));
                Moves.moves.add(new Pair<>(6, 2));
            } else {
                Moves.moves.add(new Pair<>(6, 5));
                Moves.moves.add(new Pair<>(5, 6));
            }
        } else if (y == 0) {
            Moves.moves.add(new Pair<>(x - 1, y + 2));
            Moves.moves.add(new Pair<>(x + 1, y + 2));
        } else if (y == 7) {
            Moves.moves.add(new Pair<>(x - 1, y - 2));
            Moves.moves.add(new Pair<>(x + 1, y - 2));
        } else if (x == 1 && y == 6) {
            Moves.moves.add(new Pair<>(0, 4));
            Moves.moves.add(new Pair<>(2, 4));
            Moves.moves.add(new Pair<>(3, 5));
            Moves.moves.add(new Pair<>(3, 7));
        } else if (x == 1 && y == 1) {
            Moves.moves.add(new Pair<>(0, 3));
            Moves.moves.add(new Pair<>(2, 3));
            Moves.moves.add(new Pair<>(3, 0));
            Moves.moves.add(new Pair<>(3, 2));
        } else if (x == 6 && y == 1) {
            Moves.moves.add(new Pair<>(7, 3));
            Moves.moves.add(new Pair<>(4, 0));
            Moves.moves.add(new Pair<>(4, 2));
            Moves.moves.add(new Pair<>(5, 3));
        } else if (x == 6 && y == 6) {
            Moves.moves.add(new Pair<>(7, 4));
            Moves.moves.add(new Pair<>(5, 4));
            Moves.moves.add(new Pair<>(4, 5));
            Moves.moves.add(new Pair<>(4, 7));
        } else if ((y == 6 || y == 1) && (x > 1 && x < 6)) {
            for (int i = 0, j = y - 1, k = x - 1; i < 2; i++, j += 2, k += 2) {
                Moves.moves.add(new Pair<>(x - 2, j));
                Moves.moves.add(new Pair<>(x + 2, j));
                if (y == 6) {
                    Moves.moves.add(new Pair<>(k, y - 2));
                } else {
                    Moves.moves.add(new Pair<>(k, y + 2));
                }
            }
        } else {
            for (int i = 0, j = y - 1, k = y - 2; i < 2; i++, j += 2, k += 4) {
                Moves.moves.add(new Pair<>(x - 2, j));
                Moves.moves.add(new Pair<>(x + 2, j));
                Moves.moves.add(new Pair<>(x - 1, k));
                Moves.moves.add(new Pair<>(x + 1, k));
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
