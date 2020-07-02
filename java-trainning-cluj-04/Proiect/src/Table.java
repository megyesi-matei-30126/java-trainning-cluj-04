import javafx.util.Pair;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table extends JFrame {
    public static Square[][] squares;
    public static Square currentSquarePress = null;
    private String[] numbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    private String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
    public static Color whiteSquare = new Color(240, 217, 181);
    public static Color blackSquare = new Color(181, 136, 99);

    public Table() throws HeadlessException {
        super("CHESS GAME");
        squares = new Square[8][8];
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        chessTable();
        setVisible(true);
    }

    private void chessTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBorder(new LineBorder(Color.BLACK));

        /*
         *  Adaugam in tablePanel literele si cifrele de pe placa de sah
         */
        Font font = new Font("FontBold", Font.BOLD, 20);
        for (int i = 1; i <= 8; i++) {
            JLabel label01 = new JLabel(this.letters[i - 1]);
            JLabel label02 = new JLabel(this.numbers[i - 1]);

            label01.setFont(font);
            label01.setBounds((i * 64) + 140, 10, 64, 64);

            label02.setFont(font);
            label02.setBounds(140, i * 63, 64, 64);

            tablePanel.add(label02);
            tablePanel.add(label01);
        }

        int location = 180; // de unde pleaca primul buton pe axa x
        int rows = 60; // de unde pleaca primul buton pe axa y
        int squareNumber = 0;
        /*
         * Construim piesele si le aduagam in matricea squares
         */
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square;
                squareNumber++;
                if (i == 1) {
                    square = new Square(new Pawm(true, i, j), location + (j * 64), rows, squareNumber); // Pion negru
                } else if (i == 6) {
                    square = new Square(new Pawm(false, i, j), location + (j * 64), rows, squareNumber); // Pion alb
                } else if (i == 0 && (j == 1 || j == 6)) {
                    square = new Square(new Knight(true, i, j), location + (j * 64), rows, squareNumber); // Cal negru
                } else if (i == 7 && (j == 1 || j == 6)) {
                    square = new Square(new Knight(false, i, j), location + (j * 64), rows, squareNumber); // Cal alb
                } else if (i == 0 && (j == 0 || j == 7)) {
                    square = new Square(new King(true, i, j), location + (j * 64), rows, squareNumber); // Tura negru
                } else if (i == 7 && (j == 0 || j == 7)) {
                    square = new Square(new King(false, i, j), location + (j * 64), rows, squareNumber); // Tura alb
                } else if (i == 0 && (j == 2 || j == 5)) {
                    square = new Square(new Bishop(true, i, j), location + (j * 64), rows, squareNumber); // Nebun negru
                } else if (i == 7 && (j == 2 || j == 5)) {
                    square = new Square(new Bishop(false, i, j), location + (j * 64), rows, squareNumber); // Nebun alb
                } else if (i == 0 && j == 4) {
                    square = new Square(new King(true, i, j), location + (j * 64), rows, squareNumber); // Rege negru
                } else if (i == 7 && j == 4) {
                    square = new Square(new King(false, i, j), location + (j * 64), rows, squareNumber); // Rege alb
                } else if (i == 0) {
                    square = new Square(new Queen(true, i, j), location + (j * 64), rows, squareNumber); // Regina negru
                } else if (i == 7) {
                    square = new Square(new Queen(false, i, j), location + (j * 64), rows, squareNumber); // Regina alb
                } else {
                    square = new Square(location + (j * 64), rows, squareNumber); // Patrat gol
                }
                square.addActionListener(new TableButton());

                if (checkSquareColor(i, j)) {
                    square.setBackground(whiteSquare); // Patart alb
                } else {
                    square.setBackground(blackSquare); // Patrat negru
                }

                squares[i][j] = square;
            }
            rows += 64;
        }

        /*
         * Spaunam piesele pe ecran
         */
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablePanel.add(squares[i][j]);
            }
        }

        JPanel panelLeft = new JPanel(); // deocamdata pentru test
        panelLeft.setLayout(null);
        panelLeft.setBorder(new LineBorder(Color.RED));
        panelLeft.setPreferredSize(new Dimension(100, 0));

        add(tablePanel, BorderLayout.CENTER);
        add(panelLeft, BorderLayout.WEST);
    }

    public static boolean checkSquareColor(int i, int j) {
        return (i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0);
    }

    static class TableButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (actionEvent.getSource() == squares[i][j]) {
                        if (squares[i][j].getPiece() != null) {
                            squares[i][j].getPiece().calculateMoves(i, j);
                        }
                        showPossibleMoves();
                        squares[i][j].setBackground(Color.RED);
                        currentSquarePress = squares[i][j];
                        break;
                    }
                }
            }
        }

        private void showPossibleMoves() {
            /*for (Pair<Integer, Integer> pair : Moves.moves) {
                squares[pair.getKey()][pair.getValue()].setBackground(Color.BLUE);
            }*/
        }
    }

    public static void main(String[] args) {
        Table table = new Table();
    }
}



