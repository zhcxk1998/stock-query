package shares.data;

import javafx.beans.property.SimpleStringProperty;

/**
 * This method is structure the table-view
 */
public class Stock {
    private final SimpleStringProperty name;
    private final SimpleStringProperty openPrice;
    private final SimpleStringProperty closePrice;
    private final SimpleStringProperty nowPrice;
    private final SimpleStringProperty highestPrice;
    private final SimpleStringProperty lowestPrice;
    private final SimpleStringProperty bidPrice;
    private final SimpleStringProperty auctionPrice;
    private final SimpleStringProperty transactionNumber;
    private final SimpleStringProperty transactionMoney;


    private final SimpleStringProperty Date_;
    private final SimpleStringProperty Date_time_;

    public Stock(String[] stock_data) {
        this.name = new SimpleStringProperty(stock_data[0]);
        this.openPrice = new SimpleStringProperty(stock_data[1]);
        this.closePrice = new SimpleStringProperty(stock_data[2]);
        this.nowPrice = new SimpleStringProperty(stock_data[3]);
        this.highestPrice = new SimpleStringProperty(stock_data[4]);
        this.lowestPrice = new SimpleStringProperty(stock_data[5]);
        this.bidPrice = new SimpleStringProperty(stock_data[6]);
        this.auctionPrice = new SimpleStringProperty(stock_data[7]);
        this.transactionNumber = new SimpleStringProperty(stock_data[8]);
        this.transactionMoney = new SimpleStringProperty(stock_data[9].substring(0, stock_data[9].indexOf(".")));

        this.Date_ = new SimpleStringProperty(stock_data[30]);
        this.Date_time_ = new SimpleStringProperty(stock_data[31]);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getopenPrice() {
        return openPrice.get();
    }

    public SimpleStringProperty openPriceProperty() {
        return openPrice;
    }

    public void setopenPrice(String openPrice) {
        this.openPrice.set(openPrice);
    }

    public String getclosePrice() {
        return closePrice.get();
    }

    public SimpleStringProperty closePriceProperty() {
        return closePrice;
    }

    public void setclosePrice(String closePrice) {
        this.closePrice.set(closePrice);
    }

    public String getnowPrice() {
        return nowPrice.get();
    }

    public SimpleStringProperty nowPriceProperty() {
        return nowPrice;
    }

    public void setnowPrice(String nowPrice) {
        this.nowPrice.set(nowPrice);
    }

    public String gethighestPrice() {
        return highestPrice.get();
    }

    public SimpleStringProperty highestPriceProperty() {
        return highestPrice;
    }

    public void sethighestPrice(String highestPrice) {
        this.highestPrice.set(highestPrice);
    }

    public String getlowestPrice() {
        return lowestPrice.get();
    }

    public SimpleStringProperty lowestPriceProperty() {
        return lowestPrice;
    }

    public void setlowestPrice(String lowestPrice) {
        this.lowestPrice.set(lowestPrice);
    }

    public String getbidPrice() {
        return bidPrice.get();
    }

    public SimpleStringProperty bidPriceProperty() {
        return bidPrice;
    }

    public void setbidPrice(String bidPrice) {
        this.bidPrice.set(bidPrice);
    }

    public String getauctionPrice() {
        return auctionPrice.get();
    }

    public SimpleStringProperty auctionPriceProperty() {
        return auctionPrice;
    }

    public void setauctionPrice(String auctionPrice) {
        this.auctionPrice.set(auctionPrice);
    }

    public String gettransactionNumber() {
        return transactionNumber.get();
    }

    public SimpleStringProperty transactionNumberProperty() {
        return transactionNumber;
    }

    public void settransactionNumber(String transactionNumber) {
        this.transactionNumber.set(transactionNumber);
    }

    public String gettransactionMoney() {
        return transactionMoney.get();
    }

    public SimpleStringProperty transactionMoneyProperty() {
        return transactionMoney;
    }

    public void settransactionMoney(String transactionMoney) {
        this.transactionMoney.set(transactionMoney);
    }

    public String getDate_() {
        return Date_.get();
    }

    public SimpleStringProperty date_Property() {
        return Date_;
    }

    public void setDate_(String date_) {
        this.Date_.set(date_);
    }

    public String getDate_time_() {
        return Date_time_.get();
    }

    public SimpleStringProperty date_time_Property() {
        return Date_time_;
    }

    public void setDate_time_(String date_time_) {
        this.Date_time_.set(date_time_);
    }
}
