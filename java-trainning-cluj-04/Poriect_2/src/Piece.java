import javafx.util.Pair;

import javax.swing.*;
import java.util.List;

public abstract class Piece {
    abstract List<Pair<Integer, Integer>> moves(int x, int y);

    abstract void setImage(ImageIcon imageIcon);

    abstract void fixImage();

    abstract ImageIcon getImage();

    abstract boolean isBlack();
}

