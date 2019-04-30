package bingo;

import java.util.ArrayList;
import java.util.Collections;
import utilidades.Utilidades;

public abstract class Bingo {

    protected int bolaMayor;
    protected boolean finalizado;
    protected int ultimaBola;
    protected int tmxCarton;
    protected ArrayList<Carton> cartones;
    protected ArrayList<Carton> cartonesBingo;
    protected ArrayList<Integer> bombo;
    protected ArrayList<Integer> bolasExtraidas;

    public Bingo() {
        this.bombo = new ArrayList<>(Utilidades.llenarBombo(bolaMayor));
        cartonesBingo = new ArrayList<>();
        bolasExtraidas = new ArrayList<>();
        cartones = new ArrayList<>();
        this.ultimaBola = 0;
        finalizado = false;
    }

    public int mezclar() {
        Collections.shuffle(bombo);
        ultimaBola = bombo.get(0);
        bolasExtraidas.add(bombo.get(0));
        bombo.remove(0);
        for (int i = 0; i < cartones.size(); i++) {
            if (cartones.get(i).comprobar(bolasExtraidas)) {
                cartonesBingo.add(cartones.get(i));
                this.finalizado = true;
            }
        }
        return ultimaBola;
    }

    public boolean isFinalizado() {
        return this.finalizado;
    }

    public abstract boolean cartonAceptable(Carton carton);

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
            System.out.println(carton.toString());
        } while (cartonAceptable(carton) && cartones.contains(carton));
        cartones.add(carton);

        return carton;
    }
}
