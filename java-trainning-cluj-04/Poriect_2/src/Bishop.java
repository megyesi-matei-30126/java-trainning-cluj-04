import javafx.util.Pair;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Bishop extends Piece {
    private ImageIcon pieceIcon;
    private boolean isBlack;

    public Bishop(boolean isBlack) {
        this.isBlack = isBlack;
        fixImage();
    }

    @Override
    List<Pair<Integer, Integer>> moves(int x, int y) {
        List<BiFunction<Integer, Integer, Pair<Integer, Integer>>> allMoves = Arrays.asList((z, t) -> new Pair<>(z + 1, t + 1), (z, t) -> new Pair<>(z + 2, t + 2),
                (z, t) -> new Pair<>(z + 3, t + 3), (z, t) -> new Pair<>(z + 4, t + 4),
                (z, t) -> new Pair<>(z + 5, t + 5), (z, t) -> new Pair<>(z + 6, t + 6),
                (z, t) -> new Pair<>(z + 7, t + 7), (z, t) -> new Pair<>(z - 1, t - 1),
                (z, t) -> new Pair<>(z - 2, t - 2), (z, t) -> new Pair<>(z - 3, t - 3),
                (z, t) -> new Pair<>(z - 4, t - 4), (z, t) -> new Pair<>(z - 5, t - 5),
                (z, t) -> new Pair<>(z - 6, t - 6), (z, t) -> new Pair<>(z - 7, t - 7),
                (z, t) -> new Pair<>(z + 1, t - 1), (z, t) -> new Pair<>(z + 2, t - 2),
                (z, t) -> new Pair<>(z + 3, t - 3), (z, t) -> new Pair<>(z + 4, t - 4),
                (z, t) -> new Pair<>(z + 5, t - 5), (z, t) -> new Pair<>(z + 6, t - 6),
                (z, t) -> new Pair<>(z + 7, t - 7), (z, t) -> new Pair<>(z - 1, t + 1),
                (z, t) -> new Pair<>(z - 2, t + 2), (z, t) -> new Pair<>(z - 3, t + 3),
                (z, t) -> new Pair<>(z - 4, t + 4), (z, t) -> new Pair<>(z - 5, t + 5),
                (z, t) -> new Pair<>(z - 6, t + 6), (z, t) -> new Pair<>(z - 7, t + 7));
        return allMoves.stream().map(i -> i.apply(x, y)).
                filter(i -> (i.getKey() >= 0 && i.getKey() <= 7) && (i.getValue() <= 7 && i.getValue() >= 0)).
                filter(i -> {
                    if (Table.tableButtons[i.getKey()][i.getValue()].isBusy()) {
                        return Table.tableButtons[i.getKey()][i.getValue()].checkBishop(x, y, i.getKey(), i.getValue());
                    }
                    return true;
                }).
                filter(i -> Table.tableButtons[i.getKey()][i.getValue()].checkBishop(x, y, i.getKey(), i.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    void fixImage() {
        if (this.isBlack) {
            this.pieceIcon = new ImageIcon("ImaginiPiese/nebunNegru.png");
        } else {
            this.pieceIcon = new ImageIcon("ImaginiPiese/nebunAlb.png");
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
