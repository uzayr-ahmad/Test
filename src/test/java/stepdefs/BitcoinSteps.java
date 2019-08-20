package stepdefs;


import com.google.inject.Inject;
//import com.sun.codemodel.internal.JForEach;
import connectors.BitcoinDataConnector;
import connectors.ChromeDriverConnector;
import cucumber.api.java8.En;
import models.BitcoinPrice;
import org.assertj.core.api.Assertions;
import utils.SharedState;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;

public class BitcoinSteps implements En {

    @Inject
    public BitcoinSteps(SharedState sharedState, BitcoinDataConnector bitcoinDataConnector) {

        Given("^I fetch bitcoin price data$", () -> {

            sharedState.setBitcoinData(bitcoinDataConnector.fetchLatestChromeDriverVersion("https://api.exmo.com"));

        });
        Then("^There are more than (\\d+) bitcoin available$", (Integer amount) -> {

            List<BitcoinPrice> collect = sharedState
                    .getBitcoinData()
                    .getBTC_USD()
                    .stream()
                    .filter(bp -> Double.parseDouble(bp.getAmount()) > amount)//use to convert between datatypes
                    .collect(Collectors.toList());
            collect.forEach(System.out::println);
            assertThat(collect.isEmpty()).isFalse();
        });
//        And("^The price is less than (\\d+) USD$", (Integer price) -> {
//
//            List<BitcoinPrice> collect = sharedState
//                    .getBitcoinData()
//                    .getBTC_USD()
//                    .stream()
//                    .filter(bp -> Double.parseDouble(bp.getPrice()) < price)
//                    .collect(Collectors.toList());
//            collect.forEach(System.out::println);
//            assertThat(collect.isEmpty()).isFalse();
//        });
        Then("^I sort the data$", () -> {
            BitcoinPrice minPrice = sharedState
                    .getBitcoinData()
                    .getBTC_USD()
                    .stream()
                    .min(Comparator.comparingDouble(tp -> Double.parseDouble(tp.getPrice())))
                    .get();

            BitcoinPrice maxPrice = sharedState
                    .getBitcoinData()
                    .getBTC_USD()
                    .stream()
                    .max(Comparator.comparingDouble(tp -> Double.parseDouble(tp.getPrice())))
                    .get();

            double price_max = Double.parseDouble(maxPrice.getPrice());
            double price_min = Double.parseDouble(minPrice.getPrice());
            double price_differ = price_max - price_min;
            System.out.println("The Lowest Price for 1 Bitcoin is " + price_min);
            System.out.println("The Highest Price for 1 Bitcoin is " + price_max);
            System.out.println("The Difference in price between the max and min value for 1 Bitcoin is " + price_differ);


        });
    }
    }

