package observers;

public interface Subject {

    void notifyObservers();
    void add(Observer o);
    void remove(Observer o);

}
