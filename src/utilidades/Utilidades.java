
package utilidades;

import java.util.ArrayList;

public class Utilidades {

    public static ArrayList<Integer> llenarBombo(int limite) {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= limite; i++) {
            lista.add(i);
        }
        
        return lista;
    }
}
