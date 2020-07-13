import javafx.util.Pair;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    private ImageIcon pieceIcon;
    private boolean isBlack;

    public Queen(boolean isBlack) {
        this.isBlack = isBlack;
        fixImage();
    }

    @Override
    List<Pair<Integer, Integer>> moves(int x, int y) {
        List<Pair<Integer, Integer>> bishopMoves = new Bishop(false).moves(x, y);
        List<Pair<Integer, Integer>> rookMoves = new Rook(false).moves(x, y);
        List<Pair<Integer, Integer>> queenMoves = new ArrayList<>();
        queenMoves.addAll(bishopMoves);
        queenMoves.addAll(rookMoves);
        return queenMoves;
    }

    @Override
    void fixImage() {
        if (this.isBlack) {
            this.pieceIcon = new ImageIcon("ImaginiPiese/reginaNegru.png");
        } else {
            this.pieceIcon = new ImageIcon("ImaginiPiese/reginaAlb.png");
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
