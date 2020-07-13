import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table extends JFrame {
    static TableButton[][] tableButtons = new TableButton[8][8];
    private String[] numbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    private String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
    static Controller controller;

    public Table() {
        super("CHESS GAME");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        createTable();
        controller = new Controller();
        setVisible(true);
    }

    private void createTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);

        Font font = new Font("FontBold", Font.BOLD, 20);
        for (int i = 1; i <= 8; i++) {
            JLabel label01 = new JLabel(this.letters[i - 1]);
            JLabel label02 = new JLabel(this.numbers[i - 1]);

            label01.setFont(font);
            label01.setBounds((i * 64) + 60, 10, 64, 64);

            label02.setFont(font);
            label02.setBounds(60, i * 63, 64, 64);

            tablePanel.add(label02);
            tablePanel.add(label01);
        }

        int location = 100; // de unde pleaca primul buton pe axa x
        int rows = 60; // de unde pleaca primul buton pe axa y

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                TableButton tableButton;
                if (i == 1) {
                    tableButton = new TableButton(new Pawn(true), true, location + (j * 64), rows); // Pion negru
                } else if (i == 6) {
                    tableButton = new TableButton(new Pawn(false), true, location + (j * 64), rows); // Pion alb
                } else if (i == 0 && (j == 1 || j == 6)) {
                    tableButton = new TableButton(new Knight(true), true, location + (j * 64), rows); // Cal negru
                } else if (i == 7 && (j == 1 || j == 6)) {
                    tableButton = new TableButton(new Knight(false), true, location + (j * 64), rows); // Cal alb
                } else if (i == 0 && (j == 0 || j == 7)) {
                    tableButton = new TableButton(new Rook(true), true, location + (j * 64), rows); // Tura negru
                } else if (i == 7 && (j == 0 || j == 7)) {
                    tableButton = new TableButton(new Rook(false), true, location + (j * 64), rows); // Tura alb
                } else if (i == 0 && (j == 2 || j == 5)) {
                    tableButton = new TableButton(new Bishop(true), true, location + (j * 64), rows); // Nebun negru
                } else if (i == 7 && (j == 2 || j == 5)) {
                    tableButton = new TableButton(new Bishop(false), true, location + (j * 64), rows); // Nebun alb
                } else if (i == 0 && j == 4) {
                    tableButton = new TableButton(new King(true), true, location + (j * 64), rows); // Rege negru
                } else if (i == 7 && j == 4) {
                    tableButton = new TableButton(new King(false), true, location + (j * 64), rows); // Rege alb
                } else if (i == 0) {
                    tableButton = new TableButton(new Queen(true), true, location + (j * 64), rows); // Regina negru
                } else if (i == 7) {
                    tableButton = new TableButton(new Queen(false), true, location + (j * 64), rows); // Regina alb
                } else {
                    tableButton = new TableButton(false, location + (j * 64), rows); // Patrat gol
                }

                tableButton.addActionListener(new Buttons());

                if (checkSquareColor(i, j)) {
                    tableButton.setBackground(new Color(240, 217, 181)); // Patart alb
                } else {
                    tableButton.setBackground(new Color(181, 136, 99)); // Patrat negru
                }

                tableButtons[i][j] = tableButton;

            }
            rows += 64;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablePanel.add(tableButtons[i][j]);
            }
        }

        add(tablePanel, BorderLayout.CENTER);
    }

    public boolean checkSquareColor(int i, int j) {
        return (i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0);
    }

    static class Buttons implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (actionEvent.getSource() == tableButtons[i][j]) {
                        if (!controller.isSelected()) {
                            if (tableButtons[i][j].getPiece() != null) {
                                controller.selectPiece(i, j);
                            }
                        } else {
                            if (controller.isSelected() && tableButtons[i][j].getPiece() != null && tableButtons[i][j].getPiece().isBlack() == controller.getSelectedPiece().isBlack()) {
                                controller.selectPiece(i, j);
                            }
                            else if (controller.checkColorOfPiece(i, j, controller.getSelectedPiece().isBlack())) {
                                controller.makeMove(i, j);
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}

