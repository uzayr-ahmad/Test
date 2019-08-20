package models;

public class BitcoinPrice {
    private long trade_id;
    private String type;
    private String quantity;
    private String price;
    private String amount;
    private long date;


    public long getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(long trade_id) {
        this.trade_id = trade_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BitcoinPrice{" +
                "trade_id=" + trade_id +
                ", type='" + type + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                ", date=" + date +
                '}';
    }
}
