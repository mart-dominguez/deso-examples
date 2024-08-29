package deso.patrones.observer;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Logistica implements Observer<Venta>{
    
    Map<Cliente,Set<Producto>> envios = new LinkedHashMap<>();

    @Override
    public void evento(Obvservable<Venta> v) {
        Set<Producto> prod = envios.get(v.get().cliente);
        if(prod == null){
            prod = new LinkedHashSet<>();
        }
        for(Producto p : v.get().productos){
            prod.add(p);
        }
        envios.put(v.get().cliente, prod);
        System.out.println(envios);
    }
}
