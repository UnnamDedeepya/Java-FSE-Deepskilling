package subject;

import observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName) {
        this.stockName = stockName;
    }

    public void setStockPrice(double price) {
        if (this.stockPrice != price) {
            this.stockPrice = price;
            notifyObservers();
        } else {
            System.out.println("No change in stock price. Observers not notified.");
        }
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }


    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }
}
