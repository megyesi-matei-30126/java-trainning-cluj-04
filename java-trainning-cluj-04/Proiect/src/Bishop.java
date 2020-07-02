import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;

public class Bishop implements Piece {
    private ImageIcon image;
    private boolean isBlack;
    private int x;
    private int y;

    public Bishop(boolean isBlack, int x, int y) {
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
            this.image = new ImageIcon("src/ImaginiPiese/nebunNegru.png");
        } else {
            this.image = new ImageIcon("src/ImaginiPiese/nebunAlb.png");
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
        int posX = x;
        int posY = y;
        int posY2 = y;
        int posX2 = x;
        int posY3 = y;
        int posX3 = x;

        if (x == 7) {
            while (posY < 7) {
                posY++;
                posX--;
                Moves.moves.add(new Pair<>(posX, posY));
                if (checkIfSquareIsBusy(posX, posY)) {
                    break;
                }
            }
            while (posY3 > 0) {
                posY3--;
                posX3--;
                Moves.moves.add(new Pair<>(posX3, posY3));
                if (checkIfSquareIsBusy(posX3, posY3)) {
                    break;
                }
            }
            if (y != 0 && y != 7) {
                while (posY2 > 0) {
                    posX2--;
                    posY2--;
                    Moves.moves.add(new Pair<>(posX2, posY2));
                    if (checkIfSquareIsBusy(posX2, posY2)) {
                        break;
                    }
                }
            }
        } else if (y == 0) {
            while (posX < 7) {
                posX++;
                posY++;
                Moves.moves.add(new Pair<>(posX, posY));
                if (checkIfSquareIsBusy(posX, posY)) {
                    break;
                }
            }
            while (posX2 > 0) {
                posX2--;
                posY2++;
                Moves.moves.add(new Pair<>(posX2, posY2));
                if (checkIfSquareIsBusy(posX2, posY2)) {
                    break;
                }
            }
        } else if (x == 0) {
            while (posY < 7) {
                posY++;
                posX++;
                Moves.moves.add(new Pair<>(posX, posY));
                if (checkIfSquareIsBusy(posX, posY)) {
                    break;
                }
            }
            while (posY2 > 0) {
                posY2--;
                posX2++;
                Moves.moves.add(new Pair<>(posX2, posY2));
                if (checkIfSquareIsBusy(posX2, posY2)) {
                    break;
                }
            }
        } else {
            while (posY < 7) {
                posX--;
                posY++;
                Moves.moves.add(new Pair<>(posX, posY));
                if (checkIfSquareIsBusy(posX, posY)) {
                    break;
                }
            }
            while (posX2 < 7) {
                posX2++;
                posY2--;
                Moves.moves.add(new Pair<>(posX2, posY2));
                if (checkIfSquareIsBusy(posX2, posY2)) {
                    break;
                }
            }
            while (y < 7) {
                y++;
                x++;
                Moves.moves.add(new Pair<>(x, y));
                if (checkIfSquareIsBusy(x, y)) {
                    break;
                }
            }
            while (posY3 > 0 && posX3 > 0) {
                posY3--;
                posX3--;
                Moves.moves.add(new Pair<>(posX3, posY3));
                if (checkIfSquareIsBusy(posX3, posY3)) {
                    break;
                }
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

    private boolean checkIfSquareIsBusy(int x, int y) {
        return Table.squares[x][y].isBusy();
    }
}
