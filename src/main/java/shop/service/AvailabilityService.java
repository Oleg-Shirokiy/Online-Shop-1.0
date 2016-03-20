package shop.service;

import shop.model.Availability;
import shop.service.impl.BaseService;

import java.util.Map;

/**
 * Created by oleg on 11.03.16.
 */
public interface AvailabilityService extends Service<Availability> {
    Map<String, Availability> getAllAsMap();
}
