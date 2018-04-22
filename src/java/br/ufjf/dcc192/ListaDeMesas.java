package br.ufjf.dcc192;

import java.util.ArrayList;
import java.util.List;

public class ListaDeMesas {
    private static ArrayList<Mesas> mesas;
    
    public static List<Mesas> getInstance()
    {
        if (mesas == null)
        {
            mesas = new ArrayList<>();
            Mesas m1 = new Mesas("Mesa 1", 1);
            Mesas m2 = new Mesas("Mesa 2", 2);
            mesas.add(m1);
            mesas.add(m2);
        }
        return mesas;
    }
}
