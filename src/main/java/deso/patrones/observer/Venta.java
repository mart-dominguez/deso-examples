package deso.patrones.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Venta implements Obvservable<Venta>{
    
    Set<Producto> productos;
    Cliente cliente;
    List<Observer<Venta>> observadores = new ArrayList<>();
    boolean pagada;

    public Venta(){
        productos = new HashSet<>();
        pagada = false;
    }

    @Override
    public void addObserver(Observer<Venta> observer) {
        this.observadores.add(observer);
    }

    @Override
    public void notifyChange() {
        for(Observer<Venta> unObserver : observadores){
            unObserver.evento(this);
        }
    }

    @Override
    public Venta get() {
        return this;
    }

    public void pagar(){
        if(cliente==null) {
            System.out.println("DEBE ELEGIR UN CLIENTE");
            return;
        }
        this.pagada = true;
        this.notifyChange();
    }
}
