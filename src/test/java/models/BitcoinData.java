package models;

import java.util.List;
import java.util.Map;

public class BitcoinData {
    private List<BitcoinPrice> BTC_USD;

    public List<BitcoinPrice> getBTC_USD() {
        return BTC_USD;
    }

    public void setBTC_USD(List<BitcoinPrice> BTC_USD) {
        this.BTC_USD = BTC_USD;
    }

    @Override
    public String toString() {
        return "BitcoinData{" +
                "BTC_USD=" + BTC_USD +
                '}';
    }
}
