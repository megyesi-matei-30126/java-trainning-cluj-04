public class Fight extends Observable {
    public void simFight() {
        int[] healthEachFrontArmy1 = new int[3];
        int[] healthEachFrontArmy2 = new int[3];
        int[] damageEachFrontArmy1 = new int[3];
        int[] damageEachFrontArmy2 = new int[3];

        /*
         * Luam valorile fiecarui fornt din interfata
         */

        for (int m = 0; m < 3; m++) {
            healthEachFrontArmy1[m] = Interfata.healthEachFrontArmy1.get(m);
            healthEachFrontArmy2[m] = Interfata.healthEachFrontArmy2.get(m);
            damageEachFrontArmy1[m] = Interfata.damageEachFrontArmy1.get(m);
            damageEachFrontArmy2[m] = Interfata.damageEachFrontArmy2.get(m);
        }

        /*
         * Verificam daca e egalitae
         */
        if (Interfata.draw) {
            super.changeState("Draw!"); //notificam observatorul
        } else {
            int i = 0;
            int k = 0;

            /*
             * Verificam care fronturi se lupta primele
             */

            while (Interfata.healthArmy1 > 0 && Interfata.healthArmy2 > 0) {
                for (int j = i; j < 3; j++) {
                    if (Interfata.healthEachFrontArmy1.get(j) != 0) {
                        i = j + 1;
                        break;
                    }
                }
                for (int j = k; j < 3; j++) {
                    if (Interfata.healthEachFrontArmy2.get(j) != 0) {
                        k = j + 1;
                        break;
                    }
                }

                while (healthEachFrontArmy1[i - 1] > 0 && healthEachFrontArmy2[k - 1] > 0) { //verificam daca fronturile corespunazatoare au viata
                    if (checkWhcichFrontAttackFirst(damageEachFrontArmy1[i - 1], damageEachFrontArmy2[k - 1])) { // verficam care front ataca primul
                        healthEachFrontArmy2[k - 1] -= damageEachFrontArmy1[i - 1]; // daca atac pimul scadem viata la forntul din armata2
                        Interfata.healthArmy2 -= damageEachFrontArmy1[i - 1]; // scadem viata armatei 2
                        if (healthEachFrontArmy2[k - 1] > 0) { // verificam daca forntul din aramta 2 e distrus dupa atacul armatei 1
                            healthEachFrontArmy1[i - 1] -= damageEachFrontArmy2[k - 1]; // daca nu e dsitrus atunci ataca si el
                            Interfata.healthArmy1 -= damageEachFrontArmy2[k - 1]; // scadem viata armatei 1
                        }
                    } else {
                        //Aceiasi logica ca si la if doar ca ataca armata 2 prima data

                        healthEachFrontArmy1[i - 1] -= damageEachFrontArmy2[k - 1];
                        Interfata.healthArmy1 -= damageEachFrontArmy2[k - 1];
                        if (healthEachFrontArmy1[i - 1] > 0) {
                            healthEachFrontArmy2[k - 1] -= damageEachFrontArmy1[i - 1];
                            Interfata.healthArmy2 -= damageEachFrontArmy1[i - 1];
                        }
                    }
                }

                if (healthEachFrontArmy1[i - 1] <= 0) {
                    if (i == 1) {
                        super.changeState("Player 1 lost first front");
                    } else if (i == 2) {
                        super.changeState("Player 1 lost second front");
                    } else {
                        super.changeState("Player 1 lost third front");
                    }
                    if (k - 1 <= 1) {
                        if (healthEachFrontArmy2[k] != 0 && k - 1 == 0) {
                            healthEachFrontArmy2[k] += healthEachFrontArmy2[k - 1]; // adugam viata forntului care a supravietuit la forntul urmator
                            damageEachFrontArmy2[k] += damageEachFrontArmy2[k - 1] / 2; // adugam jumatate din pputere de atac forntului care a supravietuit la forntul urmator
                            if (i - 1 == 1) {
                                damageEachFrontArmy1[i] -= Interfata.archerSecondFtonArmy1 * 50; // scadem atacul arcasilor din frontul care a fost distrus
                            }
                        } else if (healthEachFrontArmy2[k] != 0 && k - 1 == 1) {
                            healthEachFrontArmy2[k] += healthEachFrontArmy2[k - 1];
                            damageEachFrontArmy2[k] += damageEachFrontArmy2[k - 1] / 2; // adugam jumatate din pputere de atac forntului care a supravietuit la forntul urmator
                            if (i - 1 == 1) {
                                damageEachFrontArmy1[i] -= Interfata.archerSecondFtonArmy1 * 50; // scadem atacul arcasilor din frontul care a fost distrus
                            }
                        }
                    }
                } else if (healthEachFrontArmy2[k - 1] <= 0) {
                    if (k == 1) {
                        super.changeState("Player 2 lost first front");
                    } else if (k == 2) {
                        super.changeState("Player 2 lost second front");
                    } else {
                        super.changeState("Player 2 lost third front");
                    }
                    if (i - 1 <= 1) {
                        if (healthEachFrontArmy1[i] != 0 && i - 1 == 0) {
                            healthEachFrontArmy1[i] += healthEachFrontArmy1[i - 1]; // adugam viata forntului care a supravietuit la forntul urmator
                            damageEachFrontArmy1[i] += damageEachFrontArmy1[i - 1] / 2; // adugam jumatate din pputere de atac forntului care a supravietuit la forntul urmator
                            if (k - 1 == 1) {
                                damageEachFrontArmy2[k] -= Interfata.archerFirstFtonArmy2 * 50;
                            }
                        } else if (healthEachFrontArmy1[i] == 0 && i - 1 == 1) {
                            healthEachFrontArmy1[i] += healthEachFrontArmy1[i - 1];
                            damageEachFrontArmy1[i] += damageEachFrontArmy1[i - 1] / 2; // adugam jumatate din pputere de atac forntului care a supravietuit la forntul urmator
                            if (k - 1 == 1) {
                                damageEachFrontArmy2[k] -= Interfata.archerFirstFtonArmy2 * 50;
                            }
                        }
                    }
                }
            }
            if (Interfata.healthArmy1 > 0) {
                super.changeState("Player 1 won!");
            } else {
                super.changeState("Player 2 won!");
            }
        }
    }

    /**
     * Daca puterea de atac este mai mate pe frontul din aramta 1 atunci ataca acesta primul
     * altfel ataca cel din armata 2
     *
     * @param damgeFrontArmy1
     * @param damageFrontArmy2
     * @return
     */

    private boolean checkWhcichFrontAttackFirst(int damgeFrontArmy1, int damageFrontArmy2) {
        return damgeFrontArmy1 >= damageFrontArmy2;
    }
}
