package bingo;

import java.util.Collections;

public class BingoAmericano extends Bingo {

    public BingoAmericano() {
        super();
        bolaMayor = 75;
        tmxCarton = 25;
    }

    @Override
    public int mezclar() {
        int bola;
        do {
            Collections.shuffle(bombo);
            bola = ultimaBola;
            ultimaBola = bombo.get(0);
        } while (bola + 1 != ultimaBola);
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

    @Override
    public boolean cartonAceptable(Carton carton) {
        Integer suma = 0;
        int tamCarton = carton.getNumero().size();
        for (int i = 0; i < tamCarton; i++) {
            suma += carton.getNumero().get(i);
        }
        suma = suma / tamCarton;
        return (suma <= 50);
    }
}
