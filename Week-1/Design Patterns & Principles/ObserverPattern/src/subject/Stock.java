package subject;

import observer.Observer;

public interface Stock {
    void registerObserver(Observer o);
    void notifyObservers();
}
