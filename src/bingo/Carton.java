package bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Carton {

    private final ArrayList<Integer> numero;
    private final int tmx;

    public Carton(ArrayList<Integer> numero) {
        this.numero = (ArrayList<Integer>) numero.clone();
        this.tmx = numero.size();
        Collections.sort(numero);
    }

    public boolean comprobar(ArrayList<Integer> BolasUsadas) {
        return numero.containsAll(BolasUsadas);
    }

    @Override
    public String toString() {
        String texto;
        texto = numero.toString();
        return texto;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carton other = (Carton) obj;
        if (this.tmx != other.tmx) {
            return false;
        }
        return numero.containsAll(other.numero);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numero);
        hash = 47 * hash + this.tmx;
        return hash;
    }

    public ArrayList<Integer> getNumero() {
        return numero;
    }

    public int getTmx() {
        return tmx;
    }
}
