package deso.patrones.observer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class Stock implements Observer<Venta>{
    
    private static Stock _INSTANCE;
    Map<Producto,Integer> stock;

    public static Stock get(){
        if(_INSTANCE == null){
            _INSTANCE = new Stock();
        }
        return _INSTANCE;
    }
    private Stock(){
        stock = new LinkedHashMap<>();
    }

    @Override
    public void evento(Obvservable<Venta> o) {
        Venta v = o.get();
        for(Producto p :v.productos){
            this.stock.put(p,this.stock.get(p)-1);
        }
        imprimir();
    }

    public void imprimir(){
        this.stock.entrySet().forEach( e -> System.out.println(e.getKey().nombre+"_"+e.getValue()));
    }
}
