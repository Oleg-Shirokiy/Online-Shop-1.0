package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.CurrencyDao;
import shop.model.Currency;
import shop.service.CurrencyService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oleg on 11.03.16.
 */
@Service
public class CurrencyServiсeImpl extends BaseService<Currency, CurrencyDao> implements CurrencyService {
    public Map<String, Currency> getAllAsMap() {
        List<Currency> currencyList = dao.findAll();
        Map<String, Currency> currencyMap = new LinkedHashMap<>();
        for (Currency currency : currencyList) {
            currencyMap.put(currency.getName(), currency);
        }
        return currencyMap;
    }
}
