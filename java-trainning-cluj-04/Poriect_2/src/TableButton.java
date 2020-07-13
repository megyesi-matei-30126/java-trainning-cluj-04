import javax.swing.*;

public class TableButton extends JButton {
    private Piece piece;
    private boolean isBusy;

    public TableButton(Piece piece, boolean isBusy, int x, int y) {
        super();
        setSize(64, 64);
        setLocation(x, y);
        this.piece = piece;
        setIcon(this.piece.getImage());
        this.isBusy = isBusy;
    }

    public TableButton(boolean isBusy, int x, int y) {
        super();
        setSize(64, 64);
        setLocation(x, y);
        this.isBusy = isBusy;
    }

    public boolean checkBishop(int x1, int y1, int x2, int y2) {
        boolean isFree = true;
        if (x1 > x2 && y1 > y2) {
            while (y2 < y1 - 1 && x2 < x1 - 1) {
                y2++;
                x2++;
                if (Table.tableButtons[x2][y2].isBusy()) {
                    isFree = false;
                    break;
                }
            }
        } else if (x1 < x2 && y1 < y2) {
            while (y2 > y1 + 1 && x2 > x1 + 1) {
                y2--;
                x2--;
                if (Table.tableButtons[x2][y2].isBusy()) {
                    isFree = false;
                    break;
                }
            }
        } else if (x1 < x2 && y1 > y2) {
            while (x2 > x1 + 1 && y2 < y1 - 1) {
                x2--;
                y2++;
                if (Table.tableButtons[x2][y2].isBusy()) {
                    isFree = false;
                    break;
                }
            }
        } else {
            while (x2 < x1 - 1 && y2 > y1 + 1) {
                x2++;
                y2--;
                if (Table.tableButtons[x2][y2].isBusy()) {
                    isFree = false;
                    break;
                }
            }
        }
        return isFree;
    }

    public boolean checkRook(int x1, int y1, int x2, int y2) {
        boolean isFree = true;
        if (x1 > x2) {
            while (x2 < x1 - 1) {
                x2++;
                if (Table.tableButtons[x2][y1].isBusy()) {
                    isFree = false;
                    break;
                }
            }
        } else if (x1 < x2) {
            while (x2 > x1 + 1) {
                x2--;
                if (Table.tableButtons[x2][y1].isBusy()) {
                    isFree = false;
                    break;
                }
            }
        } else if (y1 < y2) {
            while (y2 > y1 + 1) {
                y2--;
                if (Table.tableButtons[x1][y2].isBusy()) {
                    isFree = false;
                    break;
                }
            }
        } else if (y1 > y2) {
            while (y2 < y1 - 1) {
                y2++;
                if (Table.tableButtons[x1][y2].isBusy()) {
                    isFree = false;
                    break;
                }
            }
        }
        return isFree;
    }

    public void imageSet(ImageIcon imageIcon) {
        this.setIcon(imageIcon);
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
