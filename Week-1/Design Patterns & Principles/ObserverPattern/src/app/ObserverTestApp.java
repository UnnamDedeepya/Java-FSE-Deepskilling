package app;

import subject.StockMarket;
import observer.MobileApp;
import observer.WebApp;

public class ObserverTestApp {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("TCS");

        MobileApp mobile = new MobileApp();
        WebApp web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        System.out.println("\nUpdating stock price to ₹3500...");
        stockMarket.setStockPrice(3500);

        System.out.println("\nUpdating stock price to ₹3650...");
        stockMarket.setStockPrice(3650);
    }
}
