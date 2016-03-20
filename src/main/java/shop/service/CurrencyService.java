package shop.service;

import shop.model.Currency;

import java.util.Map;

/**
 * Created by oleg on 11.03.16.
 */
public interface CurrencyService extends Service<Currency> {
    Map<String, Currency> getAllAsMap();
}
