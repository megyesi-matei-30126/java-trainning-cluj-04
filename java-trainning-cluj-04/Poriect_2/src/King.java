import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class King extends Piece {
    private ImageIcon pieceIcon;
    private boolean isBlack;

    public King(boolean isBlack) {
        this.isBlack = isBlack;
        fixImage();
    }

    @Override
    List<Pair<Integer, Integer>> moves(int x, int y) {
        List<BiFunction<Integer, Integer, Pair<Integer, Integer>>> allMoves = Arrays.asList((z, t) -> new Pair<>(z + 1, t + 1),
                (z, t) -> new Pair<>(z - 1, t + 1), (z, t) -> new Pair<>(z - 1, t - 1),
                (z, t) -> new Pair<>(z, t - 1), (z, t) -> new Pair<>(z, t + 1),
                (z, t) -> new Pair<>(z + 1, t), (z, t) -> new Pair<>(z - 1, t),
                (z, t) -> new Pair<>(z + 1, t - 1));
        return allMoves.stream().map(i -> i.apply(x, y)).
                filter(i -> (i.getKey() >= 0 && i.getKey() <= 7) && (i.getValue() >= 0 && i.getValue() <= 7)).
                collect(Collectors.toList());
    }

    @Override
    void fixImage() {
        if (this.isBlack) {
            this.pieceIcon = new ImageIcon("ImaginiPiese/regeNegru.png");
        } else {
            this.pieceIcon = new ImageIcon("ImaginiPiese/regeAlb.png");
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
