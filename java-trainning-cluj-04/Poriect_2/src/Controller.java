import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Controller {
    private boolean isSelected;
    private Piece selectedPiece;
    private List<Pair<Integer, Integer>> pieceMoves;
    private int selectedPieceX;
    private int selectedPieceY;
    private boolean playerBlack;

    public Controller() {
        this.pieceMoves = new ArrayList<>();
    }

    public boolean checkColorOfPiece(int x, int y, boolean isBlack) {
        if (Table.tableButtons[x][y].isBusy()) {
            return Table.tableButtons[x][y].getPiece().isBlack() != isBlack;
        }
        return true;
    }

    public void selectPiece(int x, int y) {
        if (Table.tableButtons[x][y].getPiece() != null && Table.tableButtons[x][y].getPiece().isBlack() == this.playerBlack) {
            this.isSelected = true;
            this.selectedPiece = Table.tableButtons[x][y].getPiece();
            this.selectedPieceX = x;
            this.selectedPieceY = y;
            if (!this.pieceMoves.isEmpty()) {
                this.pieceMoves.clear();
            }
            this.pieceMoves = Table.tableButtons[x][y].getPiece().moves(x, y);
            System.out.println(this.selectedPiece);
            //this.pieceMoves.forEach(System.out::println);*/
        }
    }

    public void makeMove(int x, int y) {
        for (Pair<Integer, Integer> move : this.pieceMoves) {
            if (move.getKey() == x && move.getValue() == y) {
                Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setBusy(false);
                Table.tableButtons[x][y].setBusy(true);
                Table.tableButtons[x][y].setPiece(this.selectedPiece);
                if (isChess(this.selectedPiece.isBlack())) {
                    if (checkChessMate()) {
                        System.out.println("Chess mat");
                        System.out.println(this.playerBlack + " win");
                    } else {
                        Table.tableButtons[x][y].setBusy(true);
                        Table.tableButtons[x][y].setPiece(this.selectedPiece);
                        Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setPiece(null);
                        System.out.println(Table.tableButtons[x][y].getPiece());
                        if (this.isChess(this.selectedPiece.isBlack())) {
                            System.out.println("Chess, can't move!");
                            System.out.println("Muta alta piesa!");
                            this.isSelected = false;
                            Table.tableButtons[x][y].setBusy(false);
                            Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setBusy(true);
                            Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setPiece( Table.tableButtons[x][y].getPiece());
                            Table.tableButtons[x][y].setPiece(null);
                        } else {
                            Table.tableButtons[x][y].setBusy(false);
                            if (Table.tableButtons[x][y].getPiece() != null) {
                                Table.tableButtons[x][y].setIcon(selectedPiece.getImage());
                                Table.tableButtons[this.selectedPieceX][this.selectedPieceY].imageSet(null);
                                Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setPiece(null);
                                Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setBusy(false);
                                Table.tableButtons[x][y].setPiece(this.selectedPiece);
                            } else {
                                Table.tableButtons[x][y].setIcon(selectedPiece.getImage());
                                Table.tableButtons[this.selectedPieceX][this.selectedPieceY].imageSet(null);
                                Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setPiece(null);
                                Table.tableButtons[x][y].setPiece(this.selectedPiece);
                                Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setBusy(false);
                            }
                            this.playerBlack = !this.playerBlack;
                        }
                    }
                } else {
                    Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setBusy(true);
                    if (Table.tableButtons[x][y].getPiece() != null) {
                        Table.tableButtons[x][y].setIcon(selectedPiece.getImage());
                        Table.tableButtons[this.selectedPieceX][this.selectedPieceY].imageSet(null);
                        Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setPiece(null);
                        Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setBusy(false);
                        Table.tableButtons[x][y].setBusy(true);
                        Table.tableButtons[x][y].setPiece(this.selectedPiece);
                        this.playerBlack = !this.playerBlack;
                    } else {
                        Table.tableButtons[x][y].setIcon(selectedPiece.getImage());
                        Table.tableButtons[this.selectedPieceX][this.selectedPieceY].imageSet(null);
                        Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setPiece(null);
                        Table.tableButtons[x][y].setPiece(this.selectedPiece);
                        Table.tableButtons[x][y].setBusy(true);
                        Table.tableButtons[this.selectedPieceX][this.selectedPieceY].setBusy(false);
                        this.playerBlack = !this.playerBlack;
                    }
                }
            }
        }
        this.isSelected = false;
    }


    private boolean checkChessMate() {
        return !isChess(this.selectedPiece.isBlack()) || checkChess(this.selectedPiece.isBlack());
    }

    private boolean checkChess(boolean isBlack) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Table.tableButtons[i][j].getPiece() != null && Table.tableButtons[i][j].getPiece().isBlack() != isBlack) {
                    for (Pair<Integer, Integer> pair : Table.tableButtons[i][j].getPiece().moves(i, j)) {
                        Table.tableButtons[pair.getKey()][pair.getValue()].setBusy(true);
                        if (isChess(isBlack)) {
                            Table.tableButtons[pair.getKey()][pair.getValue()].setBusy(false);
                            return false;
                        }
                        Table.tableButtons[pair.getKey()][pair.getValue()].setBusy(false);
                    }
                }
            }
        }
        return true;
    }

    public boolean isChess(boolean isBlack) {
        return !allChess(isBlack).isEmpty();
    }

    public List<Pair<Integer, Integer>> allChess(boolean isBlack) {
        List<Pair<Integer, Integer>> chess = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Table.tableButtons[i][j].getPiece() != null && Table.tableButtons[i][j].getPiece().isBlack() != isBlack) {
                    for (Pair<Integer, Integer> pair : Table.tableButtons[i][j].getPiece().moves(i, j)) {
                        if (pair.getKey().equals(Objects.requireNonNull(getKingPos()).get(0)) && pair.getValue().equals(Objects.requireNonNull(Objects.requireNonNull(getKingPos()).get(1)))) {
                            System.out.println(pair);
                            chess.add(pair);
                        }
                    }
                }
            }
        }

        return chess;
    }

    private List<Integer> getKingPos() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Table.tableButtons[i][j].getPiece() != null && Table.tableButtons[i][j].getPiece().getClass().getName().equals("King") && Table.tableButtons[i][j].getPiece().isBlack() == playerBlack) {
                    System.out.println(i + "  " + j);
                    return Arrays.asList(i, j);
                }
            }
        }
        return null;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public Piece getSelectedPiece() {
        return this.selectedPiece;
    }
}
