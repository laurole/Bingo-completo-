package bingo;

import java.util.ArrayList;
import java.util.Collections;

public class BingoClasico extends Bingo {

    private final int limite;

    public BingoClasico(int limite) {
        super();
        this.limite = limite;
        bolaMayor = 90;
        tmxCarton = 15;
        cartones.ensureCapacity(limite);
        cartonesBingo.ensureCapacity(limite);
    }

    @Override
    public Carton generarCarton() {
        ArrayList<Integer> numerosPosibles = new ArrayList<>();
        ArrayList<Integer> numeros = new ArrayList<>();
        Carton carton;
        do {
            for (int i = 1; i <= bolaMayor; i++) {
                numerosPosibles.add(i);
            }
            Collections.shuffle(numerosPosibles);
            for (int i = 1; i <= tmxCarton; i++) {
                numeros.add(numerosPosibles.get(i));
            }
            carton = new Carton(numeros);
        } while (cartonAceptable(carton) && cartones.contains(carton));
        cartones.add(carton);

        return carton;
    }

    @Override
    public boolean cartonAceptable(Carton p) {
        int varA = p.getNumero().get(0);
        for (int i = 1; i < p.getNumero().size(); i++) {
            if (varA + 1 == p.getNumero().get(i)) {
                return false;
            }

            varA = p.getNumero().get(i);
        }

        return true;
    }

    public int getFaltantes() {
        return limite - cartones.size();
    }
}
