import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Interfata extends JFrame {

    /**
     * Doar pentru creeare interfetei
     */

    private JFrame frame;
    private JPanel panelG1;
    private JPanel panelG2;
    private JLabel backgroundImage;
    private JLabel playerText;
    private JButton save;
    private List<JTextField> jTextFieldList;

    /**
     * armyCreate - il folosim pentru a stii care player introduce soldati in armata
     * - daca e 0 inseamna ca primul player isi construeiste armata
     * - daca e 1 inseamna ca al doielea player isi construieste armata
     * - daca e 2 atunci schimbam interfata apeland metoda 'graphics02'
     * <p>
     * <p>
     * strateCreate - la fel ca armyCreate il folosim pentru a stii care player isi construieste strategia
     * - daca e 0 primul player isi contruieste strategia
     * - daca e 1 al doielea player isi construieste strategia
     * - daca e 2 atunci shicmbam interfatra apeland metoda 'graphics03'
     * <p>
     * <p>
     * numberOfArcher - numarul arcasiilor din armata player1
     * <p>
     * <p>
     * numberOfLencier - numarul lancerilor din armata player1
     * <p>
     * <p>
     * numberOfCavalier - numarul cavalerilor din armata player1
     * <p>
     * <p>
     * numberOfArcher2 - numarul arcasiilor din armata player2
     * <p>
     * <p>
     * numberOfLencier2 - numarul lancerilor din armata player2
     * <p>
     * <p>
     * numberOfCavalier2 - numarul cavalerilor din armata player2
     * <p>
     * <p>
     * healthEachFrontArmy1 - aici stocam viata fiecarui front din aramata player1
     * - inedxul 0 corespunde cu primul front
     * - inedxul 1 corespunde cu al doielea front
     * - inedxul 2 corespunde cu al treielea front
     * <p>
     * <p>
     * damageEachFrontArmy1 - aici stocam puterea de atatc pe fiecare front din aramata player1
     * - inedxul 0 corespunde cu primul front
     * - inedxul 1 corespunde cu al doielea front
     * - inedxul 2 corespunde cu al treielea front
     * <p>
     * <p>
     * healthEachFrontArmy2 - aici stocam viata fiecarui front din aramata player2
     * - inedxul 0 corespunde cu primul front
     * - inedxul 1 corespunde cu al doielea front
     * - inedxul 2 corespunde cu al treielea front
     * <p>
     * <p>
     * damageEachFrontArmy2 - aici stocam puterea de atatc pe fiecare front din aramata player2
     * - inedxul 0 corespunde cu primul front
     * - inedxul 1 corespunde cu al doielea front
     * - inedxul 2 corespunde cu al treielea front
     * <p>
     * <p>
     * archerFirstFtonArmy1 - numarul aracsiilor din primul front armata player1
     * <p>
     * <p>
     * archerSecondFtonArmy1 - numarul aracsiilor din al doielea front armata player1
     * <p>
     * <p>
     * archerThirdFtonArmy1 - numarul aracsiilor din al trielea front armata player1
     * <p>
     * <p>
     * archerFirstFtonArmy2 - numarul aracsiilor din primul front armata player2
     * <p>
     * <p>
     * archerSecondFtonArmy2 - numarul aracsiilor din al doielea front armata player2
     * <p>
     * <p>
     * archerThirdFtonArmy2 - numarul aracsiilor din al trielea front armata player2
     * <p>
     * <p>
     * healthArmy1 - viata armatei player1 de pe toate cele 3 fornturi
     * <p>
     * <p>
     * healthArmy2 - viata armatei player2 de pe toate cele 3 fornturi
     * <p>
     * <p>
     * arhcerEachFrontArmy1 - stocam numarul arcasilor de pe fiecare fornt din armata player1
     * <p>
     * <p>
     * arhcerEachFrontArmy2 - stocam numarul arcasilor de pe fiecare fornt din armata player2
     * <p>
     * <p>
     * resultBattle - stocam un string de fiecare data cand un front este peirdut
     * - la sfarsit stocam player-ul care a castigata
     * <p>
     * <p>
     * draw - daca a introdus acelasi numar si tip de soldati pe aceleasi fronturi va fi egalitate
     * <p>
     * <p>
     * fh1 - viata primului front din armata player1
     * <p>
     * <p>
     * fh2 - viata de pe doielea front din armata player1
     * <p>
     * <p>
     * fh3 - viata de pe treielea front din armata player1
     * <p>
     * <p>
     * d1 - puterea de atac de pe primul front din armata player1
     * <p>
     * <p>
     * d2 - puterea de atac de pe al doielea front din armata player1
     * <p>
     * <p>
     * d3 - puterea de atac de pe al treielea front din armata player1
     * <p>
     * <p>
     * fh12 - viata primului front din armata player2
     * <p>
     * <p>
     * fh22 - viata de pe doielea front din armata player2
     * <p>
     * <p>
     * fh32 - viata de pe treielea front din armata player2
     * <p>
     * <p>
     * d12 - puterea de atac de pe primul front din armata player2
     * <p>
     * <p>
     * d22 - puterea de atac de pe al doielea front din armata player2
     * <p>
     * <p>
     * d32 - puterea de atac de pe al treielea front din armata player2
     * <p>
     * <p>
     * fight - un obiect de tip clasa 'Fight'
     */
    private int armyCreate;
    private int strategyCreate;
    private int numberOfArcher;
    private int numberOfLencier;
    private int numberOfCavalier;
    private int numberOfArcher2;
    private int numberOfLencier2;
    private int numberOfCavalier2;
    static List<Integer> healthEachFrontArmy1;
    static List<Integer> damageEachFrontArmy1;
    static List<Integer> healthEachFrontArmy2;
    static List<Integer> damageEachFrontArmy2;
    static int archerFirstFtonArmy1;
    static int archerSecondFtonArmy1;
    static int archerThirdFtonArmy1;
    static int archerFirstFtonArmy2;
    static int archerSecondFtonArmy2;
    static int archerThirdFtonArmy2;
    static int healthArmy1;
    static int healthArmy2;
    static List<Integer> arhcerEachFrontArmy1;
    static List<Integer> arhcerEachFrontArmy2;
    static List<String> resultBattle;
    static boolean draw;
    private int fh1 = 0;
    private int fh2 = 0;
    private int fh3 = 0;
    private int d1 = 0;
    private int d2 = 0;
    private int d3 = 0;
    private int fh12 = 0;
    private int fh22 = 0;
    private int fh32 = 0;
    private int d12 = 0;
    private int d22 = 0;
    private int d32 = 0;

    private Fight fight;


    /**
     * Instantiem fiecare lista care am creat-o
     * <p>
     * Apelam metoda 'graphicsOne'
     *
     * @param fight - pentru a insatntiem obiectul de tip fight de fiecare data cand creeam un obiect de tip 'Interfata'
     */

    public Interfata(Fight fight) {
        this.fight = fight;
        resultBattle = new ArrayList<>();
        healthEachFrontArmy1 = new ArrayList<>();
        damageEachFrontArmy1 = new ArrayList<>();
        healthEachFrontArmy2 = new ArrayList<>();
        damageEachFrontArmy2 = new ArrayList<>();
        arhcerEachFrontArmy1 = new ArrayList<>();
        arhcerEachFrontArmy2 = new ArrayList<>();
        this.armyCreate = 0;
        this.strategyCreate = 0;
        graphicsOne();
    }


    /**
     * Aici creeam prima interfata
     */

    private void graphicsOne() {
        this.jTextFieldList = new ArrayList<>();
        frame = new JFrame("Battle");
        frame.setSize(700, 500);
        panelG1 = new JPanel();
        panelG1.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundImage = new JLabel(new ImageIcon("Background03.jpg"));
        backgroundImage.setBounds(0, 0, 700, 500);

        JLabel title = new JLabel("Create you army!");
        title.setBounds(260, 10, 200, 30);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        title.setForeground(Color.white);
        panelG1.add(title);

        JLabel maximSoldier = new JLabel("Maxim 90 soldiers!");
        maximSoldier.setBounds(500, 10, 200, 30);
        maximSoldier.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        maximSoldier.setForeground(Color.white);
        panelG1.add(maximSoldier);

        playerText = new JLabel("Player1");
        playerText.setBounds(315, 40, 100, 20);
        playerText.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        playerText.setForeground(Color.white);
        panelG1.add(playerText);

        JLabel imageArcher = new JLabel(new ImageIcon("descărcare.png"));
        imageArcher.setBounds(20, 150, 200, 200);

        JLabel imageLancer = new JLabel(new ImageIcon("lancer.png"));
        imageLancer.setBounds(250, 150, 200, 200);

        JLabel imageLancer2 = new JLabel(new ImageIcon("soldier3.png"));
        imageLancer2.setBounds(480, 150, 200, 200);

        JLabel archerHealth = new JLabel("Health = 30");
        archerHealth.setBounds(80, 70, 100, 25);
        archerHealth.setForeground(Color.white);
        panelG1.add(archerHealth);

        JLabel archerArmor = new JLabel("Armor = 20");
        archerArmor.setBounds(80, 95, 100, 25);
        archerArmor.setForeground(Color.white);
        panelG1.add(archerArmor);

        JLabel archerDamage = new JLabel("Damage = 25");
        archerDamage.setBounds(80, 120, 100, 25);
        archerDamage.setForeground(Color.white);
        panelG1.add(archerDamage);

        JLabel lancerHealth = new JLabel("Health = 70");
        lancerHealth.setBounds(310, 70, 100, 25);
        lancerHealth.setForeground(Color.white);
        panelG1.add(lancerHealth);

        JLabel lancerArmor = new JLabel("Armor = 50");
        lancerArmor.setBounds(310, 95, 100, 25);
        lancerArmor.setForeground(Color.white);
        panelG1.add(lancerArmor);

        JLabel lancerDamage = new JLabel("Damage = 40");
        lancerDamage.setBounds(540, 120, 100, 25);
        lancerDamage.setForeground(Color.white);
        panelG1.add(lancerDamage);

        JLabel cavalierHealth = new JLabel("Health = 100");
        cavalierHealth.setBounds(540, 70, 100, 25);
        cavalierHealth.setForeground(Color.white);
        panelG1.add(cavalierHealth);

        JLabel cavalierArmor = new JLabel("Armor = 60");
        cavalierArmor.setBounds(540, 95, 100, 25);
        cavalierArmor.setForeground(Color.white);
        panelG1.add(cavalierArmor);

        JLabel cavalierDamage = new JLabel("Damage = 70");
        cavalierDamage.setBounds(310, 120, 100, 25);
        cavalierDamage.setForeground(Color.white);
        panelG1.add(cavalierDamage);

        save = new JButton("Save");
        save.setBounds(300, 420, 100, 25);
        panelG1.add(save);

        JTextField textFieldArcher = new JTextField("");
        textFieldArcher.setBounds(90, 370, 50, 20);

        /*
         * Cand da click pe un text field daca exista text
         * il sterge
         */

        textFieldArcher.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeTextFromTF(textFieldArcher);
            }
        });
        panelG1.add(textFieldArcher);

        JTextField textFieldLancer = new JTextField("");
        textFieldLancer.setBounds(330, 370, 50, 20);
        textFieldLancer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeTextFromTF(textFieldLancer);
            }
        });
        panelG1.add(textFieldLancer);

        JTextField textFieldLancer2 = new JTextField("");
        textFieldLancer2.setBounds(560, 370, 50, 20);
        textFieldLancer2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeTextFromTF(textFieldLancer2);
            }
        });
        panelG1.add(textFieldLancer2);

        this.jTextFieldList.add(textFieldArcher);
        this.jTextFieldList.add(textFieldLancer);
        this.jTextFieldList.add(textFieldLancer2);

        panelG1.add(imageArcher);
        panelG1.add(imageLancer);
        panelG1.add(imageLancer2);
        panelG1.add(backgroundImage);
        frame.add(panelG1);

        frame.setVisible(true);

        save.addActionListener(e -> createArmy());
    }

    /**
     * Creeam a doua interfata unde isi construieste interfata
     */

    private void graphicsTwo() {
        this.jTextFieldList = new ArrayList<>();
        frame.setSize(700, 500);
        panelG1.setVisible(false);
        panelG2 = new JPanel();
        panelG2.setLayout(null);
        panelG2.setVisible(true);

        JLabel title = new JLabel("Create your strategy!");
        title.setBounds(250, 10, 230, 20);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        title.setForeground(Color.white);
        panelG2.add(title);

        JLabel maximSoldier = new JLabel("In each fornt maxim 30 soldiers");
        maximSoldier.setBounds(200, 40, 300, 20);
        maximSoldier.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        maximSoldier.setForeground(Color.white);
        panelG2.add(maximSoldier);

        playerText.setBounds(315, 70, 100, 20);
        panelG2.add(playerText);

        JLabel firstFront = new JLabel("Put soldier in first fornt!");
        firstFront.setBounds(90, 150, 200, 20);
        firstFront.setForeground(Color.white);
        panelG2.add(firstFront);

        JLabel archerFirstFront = new JLabel("Archer: ");
        archerFirstFront.setBounds(90, 170, 50, 20);
        archerFirstFront.setForeground(Color.white);
        panelG2.add(archerFirstFront);

        JTextField textArcherFieldFirstFront = new JTextField("");
        textArcherFieldFirstFront.setBounds(175, 170, 50, 20);
        panelG2.add(textArcherFieldFirstFront);
        this.jTextFieldList.add(textArcherFieldFirstFront);

        JLabel lancerFirstFront = new JLabel("Lancer: ");
        lancerFirstFront.setBounds(90, 200, 50, 20);
        lancerFirstFront.setForeground(Color.white);
        panelG2.add(lancerFirstFront);

        JTextField textLancerFieldFirstFront = new JTextField("");
        textLancerFieldFirstFront.setBounds(175, 200, 50, 20);
        panelG2.add(textLancerFieldFirstFront);
        this.jTextFieldList.add(textLancerFieldFirstFront);

        JLabel cavlierFirstFront = new JLabel("Cavalier: ");
        cavlierFirstFront.setBounds(90, 230, 60, 20);
        cavlierFirstFront.setForeground(Color.white);
        panelG2.add(cavlierFirstFront);

        JTextField textCavalierFieldFirstFront = new JTextField("");
        textCavalierFieldFirstFront.setBounds(175, 230, 50, 20);
        panelG2.add(textCavalierFieldFirstFront);
        this.jTextFieldList.add(textCavalierFieldFirstFront);

        JLabel secondFront = new JLabel("Put soldier in second fornt!");
        secondFront.setBounds(270, 150, 200, 20);
        secondFront.setForeground(Color.white);
        panelG2.add(secondFront);

        JLabel archerSecondFront = new JLabel("Archer: ");
        archerSecondFront.setBounds(270, 170, 50, 20);
        archerSecondFront.setForeground(Color.white);
        panelG2.add(archerSecondFront);

        JTextField textArcherFieldSecondFront = new JTextField("");
        textArcherFieldSecondFront.setBounds(355, 170, 50, 20);
        panelG2.add(textArcherFieldSecondFront);
        this.jTextFieldList.add(textArcherFieldSecondFront);

        JLabel lancerSecondront = new JLabel("Lancer: ");
        lancerSecondront.setBounds(270, 200, 50, 20);
        lancerSecondront.setForeground(Color.white);
        panelG2.add(lancerSecondront);

        JTextField textLancerFieldSecondFront = new JTextField("");
        textLancerFieldSecondFront.setBounds(355, 200, 50, 20);
        panelG2.add(textLancerFieldSecondFront);
        this.jTextFieldList.add(textLancerFieldSecondFront);

        JLabel cavlierSecondFront = new JLabel("Cavalier: ");
        cavlierSecondFront.setBounds(270, 230, 60, 20);
        cavlierSecondFront.setForeground(Color.white);
        panelG2.add(cavlierSecondFront);

        JTextField textCavalierFieldSecondFront = new JTextField("");
        textCavalierFieldSecondFront.setBounds(355, 230, 50, 20);
        panelG2.add(textCavalierFieldSecondFront);
        this.jTextFieldList.add(textCavalierFieldSecondFront);

        JLabel thirdFront = new JLabel("Put soldier in third fornt!");
        thirdFront.setBounds(450, 150, 200, 20);
        thirdFront.setForeground(Color.white);
        panelG2.add(thirdFront);

        JLabel archerThirdFront = new JLabel("Archer: ");
        archerThirdFront.setBounds(450, 170, 50, 20);
        archerThirdFront.setForeground(Color.white);
        panelG2.add(archerThirdFront);

        JTextField textArcherFieldThirFront = new JTextField("");
        textArcherFieldThirFront.setBounds(535, 170, 50, 20);
        panelG2.add(textArcherFieldThirFront);
        this.jTextFieldList.add(textArcherFieldThirFront);

        JLabel lancerThirdront = new JLabel("Lancer: ");
        lancerThirdront.setBounds(450, 200, 50, 20);
        lancerThirdront.setForeground(Color.white);
        panelG2.add(lancerThirdront);

        JTextField textLancerFieldThridFront = new JTextField("");
        textLancerFieldThridFront.setBounds(535, 200, 50, 20);
        panelG2.add(textLancerFieldThridFront);
        this.jTextFieldList.add(textLancerFieldThridFront);

        JLabel cavlierThirdFront = new JLabel("Cavalier: ");
        cavlierThirdFront.setBounds(450, 230, 60, 20);
        cavlierThirdFront.setForeground(Color.white);
        panelG2.add(cavlierThirdFront);

        JTextField textCavalierFieldThirdFront = new JTextField("");
        textCavalierFieldThirdFront.setBounds(535, 230, 50, 20);
        panelG2.add(textCavalierFieldThirdFront);
        this.jTextFieldList.add(textCavalierFieldThirdFront);

        save = new JButton("Save");
        save.setBounds(300, 420, 100, 25);
        panelG2.add(save);
        save.addActionListener(e -> createStrategy());

        panelG2.add(backgroundImage);
        frame.add(panelG2);
        frame.setVisible(true);
    }

    /**
     * Creeam a treia interfata unde poate vedea rezultatul bataliei
     */

    private void graphics03() {
        panelG2.setVisible(false);
        JPanel panelG3 = new JPanel();
        JLabel title = new JLabel("Army fight.....!");
        panelG3.setLayout(null);
        title.setBounds(230, 10, 240, 50);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 35));
        title.setForeground(Color.black);

        panelG3.setVisible(true);
        panelG3.add(title);

        JButton viewResult = new JButton("View result");
        viewResult.setBounds(300, 420, 100, 25);
        panelG3.add(viewResult);

        JLabel backgroundImage02 = new JLabel(new ImageIcon("Background.jpg"));
        backgroundImage02.setBounds(0, 0, 700, 500);


        panelG3.add(backgroundImage02);
        frame.add(panelG3);
        viewResult.addActionListener(e -> viewResult());
    }

    /**
     * Afisam rezulatele batalie stocate in 'resultBattle'
     */

    private void viewResult() {
        this.fight.simFight();
        JOptionPane.showMessageDialog(null, resultBattle);
    }

    /**
     * Stergem textul din text field
     *
     * @param textField din text field-ul respectiv
     */

    private void removeTextFromTF(JTextField textField) {
        textField.setText("");
    }

    /**
     * Creeam armata
     * <p>
     * Verificam prima data daca exista soldati
     * <p>
     * Verificam daca cumva a introdus intr-un camp 0
     * <p>
     * Verificam daca a introdus mai multi soldati decat maximul posibil de 90
     * <p>
     * Pentru fiecare tip te soldati, avem cate un text field
     * <p>
     * Daca text filedul corespunzator pentru fiecare tip este completat atunci verificam care player este la rand
     * si creeam un soldat de tipul corespunzator cu ajutorul abstract factory
     * <p>
     * Daca primele conditii nu trec vom afisa niste mesaje pentru a instinta player-ul ca nu a facut ceva bine
     */

    private void createArmy() {
        if (!checkNoSoldierAdd()) {
            try {
                checkZeroNumberEnter();
                if (checkNumberOfSoldiers()) {
                    Soldier soldier;
                    if (!this.jTextFieldList.get(0).getText().equals("")) {
                        for (int i = 0; i < Integer.parseInt(this.jTextFieldList.get(0).getText()); i++) {
                            soldier = SoldierFactory.getSoldier(new CreateArcher());
                            if (this.armyCreate == 0) {
                                Army.soldati.add(soldier);
                                this.numberOfArcher++;
                            } else {
                                Army.soldati2.add(soldier);
                                this.numberOfArcher2++;
                            }
                        }
                    }

                    if (!this.jTextFieldList.get(1).getText().equals("")) {
                        for (int i = 0; i < Integer.parseInt(this.jTextFieldList.get(1).getText()); i++) {
                            soldier = SoldierFactory.getSoldier(new CreateLancer());
                            if (this.armyCreate == 0) {
                                Army.soldati.add(soldier);
                                this.numberOfLencier++;
                            } else {
                                Army.soldati2.add(soldier);
                                this.numberOfLencier2++;
                            }
                        }
                    }

                    if (!this.jTextFieldList.get(2).getText().equals("")) {
                        for (int i = 0; i < Integer.parseInt(this.jTextFieldList.get(2).getText()); i++) {
                            soldier = SoldierFactory.getSoldier(new CreateCavalier());
                            if (this.armyCreate == 0) {
                                Army.soldati.add(soldier);
                                this.numberOfCavalier++;
                            } else {
                                Army.soldati2.add(soldier);
                                this.numberOfCavalier2++;
                            }
                        }
                    }

                    this.armyCreate++;

                    for (JTextField jTextField : this.jTextFieldList) {
                        removeTextFromTF(jTextField);
                        playerText.setText("Player 2");
                    }

                    if (this.armyCreate == 2) {
                        graphicsTwo();
                        playerText.setText("Player 1");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Maxim number of soldier is 90");
                }
            } catch (NumberFormatException | ZeroNumberExecption e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Your army don't have a soldier");
        }
    }

    /**
     * Creeam strategia
     * <p>
     * Verrificam 'strategyException'
     * <p>
     * Daca conditia trece de 'strategtExpection' verificam daca cumva a introuds 0 intr-un field
     * <p>
     * Daca nu a introuds atunci apelam metoda 'createEachArmyFrontValue' si incrememtam 'strategyCreate'
     * <p>
     * Daca 'strategyCreate' == 2 atunci verifica cazul de egal si apelam metoda 'graphics03' pentru a creea interfata 3
     */

    private void createStrategy() {
        try {
            if (strategyExeception()) {
                checkZeroNumberEnter();
                createEachyArmyFrontValue();
                this.strategyCreate++;
                if (strategyCreate == 1) {
                    for (JTextField jTextField : this.jTextFieldList) {
                        removeTextFromTF(jTextField);
                        playerText.setText("Player 2");
                        save.setText("Fight");
                    }
                }
                if (strategyCreate == 2) {
                    if (this.fh1 == this.fh12 && this.fh2 == this.fh22 && this.fh3 == this.fh32 && this.d1 == this.d12 && this.d2 == this.d22 && this.d3 == this.d32) {
                        draw = true;
                    }
                    if (checkOnlyOneFrontDraw() || checkOnlyTwoFrontDraw()) {
                        draw = true;
                    }
                    graphics03();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Inccorect values!");
            }
        } catch (NumberFormatException | ZeroNumberExecption e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Daca fiecare player a introdus un singur front verificam cazul de egaliate
     * <p>
     * Parcuregem 'dameEachFrontArmy' pt fiecare armata si daca gaseste un camp care e diferit
     * de 0 atunci m++, iar la j ii dam valoare campului diferit de 0
     *
     * @return daca m e mai mare de 2 sau mai mic atunci inseamna ca sunt mai multe sau mai putin fornturi in aramte si returam false
     * daca m == 2 atunci verifcam ca viata in armata 1 sa fie aceiasi cu viata din arama 2 , la fel si puterea de atac, din
     * fornturil care exista; j - forntul primei armate, k - frontu armatei 2
     */

    private boolean checkOnlyOneFrontDraw() {
        int j = 0;
        int k = 0;
        int m = 0;
        for (int i = 0; i < 3; i++) {
            if (damageEachFrontArmy1.get(i) != 0) {
                j = i;
                m++;
            }
            if (damageEachFrontArmy2.get(i) != 0) {
                k = i;
                m++;
            }
        }
        return m == 2 && (healthEachFrontArmy1.get(j).equals(healthEachFrontArmy2.get(k)) && damageEachFrontArmy1.get(j).equals(damageEachFrontArmy2.get(k)));
    }

    /**
     * Daca fiecare player a introdus 2 forntrui verificam cazul de egalitate
     * <p>
     * Aici primesc ceva eraore, dar nu stiu ce e, probabil nu am gandit bine
     * cazul
     */

    private boolean checkOnlyTwoFrontDraw() {
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < 3; i++) {
            if (damageEachFrontArmy1.get(i) != 0) {
                list.add(i);
                j++;
            }
            if (damageEachFrontArmy2.get(i) != 0) {
                list.add(i);
                j++;
            }
        }
        return j == 4 && (healthEachFrontArmy1.get(list.get(0)).equals(healthEachFrontArmy2.get(list.get(2))) && damageEachFrontArmy1.get(list.get(0)).equals(damageEachFrontArmy2.get(list.get(2)))
                && healthEachFrontArmy1.get(list.get(1)).equals(healthEachFrontArmy2.get(list.get(3))) && damageEachFrontArmy1.get(list.get(1)).equals(damageEachFrontArmy2.get(list.get(3))));
    }

    /**
     * Verificam posibile erori cand creeaza strategia
     *
     * @return
     */

    private boolean strategyExeception() {
        try {
            if (this.jTextFieldList.get(0).getText().equals("") && this.jTextFieldList.get(1).getText().equals("") && this.jTextFieldList.get(2).getText().equals("")
                    && this.jTextFieldList.get(3).getText().equals("") && this.jTextFieldList.get(4).getText().equals("") && (this.jTextFieldList.get(5).getText().equals(""))
                    && this.jTextFieldList.get(6).getText().equals("") && this.jTextFieldList.get(7).getText().equals("") && (this.jTextFieldList.get(8).getText().equals(""))) {
                return false;
            }

            if (!checkEvryNumberTypeOfSoldier()) {
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return true;
    }

    /**
     * Verificam daca a introdus mai mult de 90 de soldati si cati soldati din fiecare tip a introdus
     *
     * @return
     */

    private boolean checkEvryNumberTypeOfSoldier() {
        int arhcerFirstFront = 0;
        int lancerFirstFront = 0;
        int cavalierFirstFront = 0;
        int archerSecondFornt = 0;
        int lancerSecondFornt = 0;
        int cavalierSecondFornt = 0;
        int archerThirdFornt = 0;
        int lancerThirdFornt = 0;
        int cavalierThirdFornt = 0;

        if (check01()) {
            arhcerFirstFront = Integer.parseInt(this.jTextFieldList.get(0).getText());
            if (checkStrategy()) {
                archerFirstFtonArmy1 = arhcerFirstFront;
            } else {
                archerFirstFtonArmy2 = arhcerFirstFront;
            }
        }
        if (check04()) {
            archerSecondFornt = Integer.parseInt(this.jTextFieldList.get(3).getText());
            if (checkStrategy()) {
                archerSecondFtonArmy1 = archerSecondFornt;
            } else {
                archerSecondFtonArmy2 = archerSecondFornt;
            }
        }
        if (check07()) {
            archerThirdFornt = Integer.parseInt(this.jTextFieldList.get(6).getText());
            if (checkStrategy()) {
                archerThirdFtonArmy1 = archerThirdFornt;
            } else {
                archerThirdFtonArmy2 = archerThirdFornt;
            }
        }
        if (check02()) {
            lancerFirstFront = Integer.parseInt(this.jTextFieldList.get(1).getText());
        }
        if (check05()) {
            lancerSecondFornt = Integer.parseInt(this.jTextFieldList.get(4).getText());
        }
        if (check08()) {

            lancerThirdFornt = Integer.parseInt(this.jTextFieldList.get(7).getText());
        }
        if (check03()) {
            cavalierFirstFront = Integer.parseInt(this.jTextFieldList.get(2).getText());
        }
        if (check06()) {
            cavalierSecondFornt = Integer.parseInt(this.jTextFieldList.get(5).getText());
        }
        if (check09()) {
            cavalierThirdFornt = Integer.parseInt(this.jTextFieldList.get(8).getText());
        }

        int totalArcher = archerSecondFornt + archerThirdFornt + arhcerFirstFront;
        int totalLancer = lancerFirstFront + lancerSecondFornt + lancerThirdFornt;
        int totalCavalier = cavalierFirstFront + cavalierSecondFornt + cavalierThirdFornt;
        int totalSoldier = totalArcher + totalCavalier + totalLancer;

        if (strategyCreate == 0) {
            if (totalArcher > this.numberOfArcher || totalCavalier > this.numberOfCavalier || totalLancer > this.numberOfLencier) {
                return false;
            }
        } else {
            if (totalArcher > this.numberOfArcher2 || totalCavalier > this.numberOfCavalier2 || totalLancer > this.numberOfLencier2) {
                return false;
            }
        }
        return totalSoldier <= 90;
    }

    private boolean checkStrategy() {
        if (this.strategyCreate == 0) {
            return false;
        } else return this.strategyCreate == 1;
    }


    /**
     * Punem valorile in healthEachFrontArmy1, healthEachFrontArmy2, damageEachFrontArmy1 si damageEachFrontArmy2
     * dupa ce si-a construit strategia
     */

    private void createEachyArmyFrontValue() {
        int arhcerFirstFront = 0;
        int lancerFirstFront = 0;
        int cavalierFirstFront = 0;
        int archerSecondFornt = 0;
        int lancerSecondFornt = 0;
        int cavalierSecondFornt = 0;
        int archerThirdFornt = 0;
        int lancerThirdFornt = 0;
        int cavalierThirdFornt = 0;

        int firstFrontDamage = 0;
        int secondFrontDamage = 0;
        int thirdFrontDamage = 0;

        int numberSoldierFirstFront;
        int numberSoldierSecondFront;
        int numebrSoldierThirdFront;

        if (check01()) {
            arhcerFirstFront = Integer.parseInt(this.jTextFieldList.get(0).getText());
        }
        if (check04()) {
            archerSecondFornt = Integer.parseInt(this.jTextFieldList.get(3).getText());
        }
        if (check07()) {
            archerThirdFornt = Integer.parseInt(this.jTextFieldList.get(6).getText());
        }
        if (check02()) {
            lancerFirstFront = Integer.parseInt(this.jTextFieldList.get(1).getText());
        }
        if (check05()) {
            lancerSecondFornt = Integer.parseInt(this.jTextFieldList.get(4).getText());
        }
        if (check08()) {

            lancerThirdFornt = Integer.parseInt(this.jTextFieldList.get(7).getText());
        }
        if (check03()) {
            cavalierFirstFront = Integer.parseInt(this.jTextFieldList.get(2).getText());
        }
        if (check06()) {
            cavalierSecondFornt = Integer.parseInt(this.jTextFieldList.get(5).getText());
        }
        if (check09()) {
            cavalierThirdFornt = Integer.parseInt(this.jTextFieldList.get(8).getText());
        }

        numberSoldierFirstFront = arhcerFirstFront + lancerFirstFront + cavalierFirstFront;
        numberSoldierSecondFront = archerSecondFornt + lancerSecondFornt + cavalierSecondFornt;
        numebrSoldierThirdFront = archerThirdFornt + lancerThirdFornt + cavalierThirdFornt;

        int totalArcher = archerSecondFornt + arhcerFirstFront + archerThirdFornt;
        int totalArcherFirstAndSecondFront = archerSecondFornt + arhcerFirstFront;

        int firstFrontHealth = arhcerFirstFront * 80 + lancerFirstFront * 120 + cavalierFirstFront * 135;
        if (numberSoldierFirstFront != 0) {
            firstFrontDamage = totalArcherFirstAndSecondFront * 50 + lancerFirstFront * 65 + cavalierFirstFront * 70;
        }

        int secondFrontHealth = archerSecondFornt * 80 + lancerSecondFornt * 120 + cavalierSecondFornt * 135;
        if (numberSoldierSecondFront != 0) {
            secondFrontDamage = totalArcherFirstAndSecondFront * 50 + lancerSecondFornt * 65 + cavalierSecondFornt * 70;
        }

        int thirdFrontHealth = archerThirdFornt * 80 + lancerThirdFornt * 120 + cavalierThirdFornt * 135;
        if (numebrSoldierThirdFront != 0) {
            thirdFrontDamage = archerThirdFornt * 50 + lancerThirdFornt * 65 + cavalierThirdFornt * 70;
        }

        if (strategyCreate == 0) {
            this.fh1 = firstFrontHealth;
            this.fh2 = secondFrontHealth;
            this.fh3 = thirdFrontHealth;
            this.d1 = firstFrontDamage;
            this.d2 = secondFrontDamage;
            this.d3 = thirdFrontDamage;
            healthEachFrontArmy1.add(firstFrontHealth);
            damageEachFrontArmy1.add(firstFrontDamage);
            healthEachFrontArmy1.add(secondFrontHealth);
            damageEachFrontArmy1.add(secondFrontDamage);
            healthEachFrontArmy1.add(thirdFrontHealth);
            damageEachFrontArmy1.add(thirdFrontDamage);
            healthArmy1 = firstFrontHealth + secondFrontHealth + thirdFrontHealth;
        } else {
            this.fh12 = firstFrontHealth;
            this.fh22 = secondFrontHealth;
            this.fh32 = thirdFrontHealth;
            this.d12 = firstFrontDamage;
            this.d22 = secondFrontDamage;
            this.d32 = thirdFrontDamage;
            healthEachFrontArmy2.add(firstFrontHealth);
            damageEachFrontArmy2.add(firstFrontDamage);
            healthEachFrontArmy2.add(secondFrontHealth);
            damageEachFrontArmy2.add(secondFrontDamage);
            healthEachFrontArmy2.add(thirdFrontHealth);
            damageEachFrontArmy2.add(thirdFrontDamage);
            healthArmy2 = firstFrontHealth + secondFrontHealth + thirdFrontHealth;
        }
    }

    /**
     * Verificam daca a introdus cel putin un soldat
     *
     * @return
     */
    private boolean checkNoSoldierAdd() {
        return (this.jTextFieldList.get(0).getText().equals("") && this.jTextFieldList.get(1).getText().equals("") && this.jTextFieldList.get(2).getText().equals(""));
    }


    /**
     * Verificam numarul soldatiilor
     *
     * @return
     */

    private boolean checkNumberOfSoldiers() {
        int numberOfSoldiers = 0;
        for (JTextField jTextField : this.jTextFieldList) {
            if (!jTextField.getText().equals("")) {
                numberOfSoldiers += Integer.parseInt(jTextField.getText());
            }
        }
        return numberOfSoldiers <= 90;
    }

    /**
     * Verificam daca a introdus 0
     *
     * @throws ZeroNumberExecption
     */
    private void checkZeroNumberEnter() throws ZeroNumberExecption {
        for (JTextField jTextField : this.jTextFieldList) {
            if (jTextField.getText().equals("0")) {
                throw new ZeroNumberExecption("You enter 0 soldiers!");
            }
        }
    }

    private boolean check01() {
        return !this.jTextFieldList.get(0).getText().equals("");
    }

    private boolean check02() {
        return !this.jTextFieldList.get(1).getText().equals("");
    }

    private boolean check03() {
        return !this.jTextFieldList.get(2).getText().equals("");
    }

    private boolean check04() {
        return !this.jTextFieldList.get(3).getText().equals("");
    }

    private boolean check05() {
        return !this.jTextFieldList.get(4).getText().equals("");
    }

    private boolean check06() {
        return !this.jTextFieldList.get(5).getText().equals("");
    }

    private boolean check07() {
        return !this.jTextFieldList.get(6).getText().equals("");
    }

    private boolean check08() {
        return !this.jTextFieldList.get(7).getText().equals("");
    }

    private boolean check09() {
        return !this.jTextFieldList.get(8).getText().equals("");
    }
}
