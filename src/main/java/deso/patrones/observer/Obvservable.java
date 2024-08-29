package deso.patrones.observer;

public interface Obvservable<T> {
    
    public void addObserver(Observer<T> observer);
    public void notifyChange();
    public T get();
}
