package deso.patrones.observer;


public interface Observer<T> {

    public void evento(Obvservable<T> o);
}
