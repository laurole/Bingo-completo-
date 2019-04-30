package main;

import bingo.Bingo;
import bingo.BingoAmericano;
import bingo.BingoClasico;
import bingo.Carton;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Bingo> bingo = new ArrayList<>();
        BingoClasico bingoC = new BingoClasico(5);
        BingoAmericano bingoA = new BingoAmericano();

        bingo.add(bingoA);
        bingo.add(bingoC);
        ArrayList<Carton> cartonesClassic = new ArrayList<>();
        ArrayList<Carton> cartonesAmerican = new ArrayList<>();

        for (int i = 0; i < bingo.size(); i++) {
            for (int x = 0; x < 5; x++) {
                if (bingo.get(i) instanceof BingoClasico) {
                    cartonesClassic.add(bingo.get(i).generarCarton());
                } else {
                    cartonesAmerican.add(bingo.get(i).generarCarton());
                }
            }
        }

        for (int i = 0; i < cartonesClassic.size(); i++) {
            System.out.println(cartonesClassic.get(i).toString());
        }

        for (int i = 0; i < cartonesAmerican.size(); i++) {
            System.out.println(cartonesClassic.get(i).toString());
        }

        for (int i = 0; i < bingo.size(); i++) {
            while (bingo.get(i).isFinalizado()) {
                System.out.println(bingo.get(i).mezclar());
            }
        }
    }
}
