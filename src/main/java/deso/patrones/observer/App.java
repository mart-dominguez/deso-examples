package deso.patrones.observer;

public class App {
    
    public static void main(String[] args) {
        Producto p1 = new Producto(1,"prd1");
        Producto p2 = new Producto(2,"prd2");
        Cliente c1 = new Cliente();
        c1.id = 222;
        c1.nombre = "PEPE";

        Venta venta1 = new Venta();
        venta1.productos.add(p1);
        venta1.cliente = c1;

        Stock st = Stock.get();
        st.stock.put(p1, 100);
        st.stock.put(p2, 50);
        st.imprimir();

        Logistica l1 = new Logistica();

        venta1.observadores.add(l1);
        venta1.addObserver(st);

        venta1.pagar();

    }
}
