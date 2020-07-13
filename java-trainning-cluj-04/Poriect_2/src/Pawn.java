import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Pawn extends Piece {
    private ImageIcon pieceIcon;
    private boolean isBlack;

    public Pawn(boolean isBlack) {
        this.isBlack = isBlack;
        fixImage();
    }

    @Override
    List<Pair<Integer, Integer>> moves(int x, int y) {
        List<BiFunction<Integer, Integer, Pair<Integer, Integer>>> allMoves;
        if (Table.tableButtons[x][y].getPiece().isBlack()) {
            allMoves = Arrays.asList((z, t) -> new Pair<>(z + 1, t + 1),
                    (z, t) -> new Pair<>(z + 1, t), (z, t) -> new Pair<>(z + 1, t - 1));
        } else {
            allMoves = Arrays.asList((z, t) -> new Pair<>(z - 1, t - 1),
                    (z, t) -> new Pair<>(z - 1, t), (z, t) -> new Pair<>(z - 1, t + 1));
        }

        List<Pair<Integer, Integer>> possibleMoves;
        possibleMoves = allMoves.stream().map(i -> i.apply(x, y)).
                filter(i -> (i.getKey() >= 0 && i.getKey() <= 7) && (i.getValue() <= 7 && i.getValue() >= 0)).
                filter(i -> {
                    if (this.isBlack) {
                        if (Table.tableButtons[i.getKey()][i.getValue()].isBusy()  && i.getKey() == x + 1 && i.getValue() != y) {
                            return true;
                        } else if (Table.tableButtons[i.getKey()][i.getValue()].isBusy() && i.getKey() == x + 1 && i.getValue() == y) {
                            return false;
                        } else return i.getKey() == x + 1 && (i.getValue() == y);
                    } else {
                        if (Table.tableButtons[i.getKey()][i.getValue()].isBusy()  && i.getKey() == x - 1 && i.getValue() != y) {
                            return true;
                        } else if (Table.tableButtons[i.getKey()][i.getValue()].isBusy() && i.getKey() == x - 1 && i.getValue() == y) {
                            return false;
                        } else return i.getKey() == x - 1 && (i.getValue() == y);
                    }
                }).
                collect(Collectors.toList());

        if (x == 1 && this.isBlack && !Table.tableButtons[x + 2][y].isBusy()) {
            possibleMoves.add(new Pair<>(x + 2, y));
        } else if (x == 6 && !this.isBlack && !Table.tableButtons[x - 2][y].isBusy()) {
            possibleMoves.add(new Pair<>(x - 2, y));
        }

        return possibleMoves;
    }

    @Override
    void fixImage() {
        if (this.isBlack) {
            this.pieceIcon = new ImageIcon("ImaginiPiese/pionNegru.png");
        } else {
            this.pieceIcon = new ImageIcon("ImaginiPiese/pionAlb.png");
        }
        Image img = this.pieceIcon.getImage();
        Image img2 = img.getScaledInstance(64, 60, Image.SCALE_SMOOTH);
        this.pieceIcon = new ImageIcon(img2);
    }

    @Override
    ImageIcon getImage() {
        return this.pieceIcon;
    }

    @Override
    public boolean isBlack() {
        return isBlack;
    }

    @Override
    void setImage(ImageIcon imageIcon) {
        this.pieceIcon = imageIcon;
    }

    public ImageIcon getPieceIcon() {
        return pieceIcon;
    }
}
