package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.AvailabilityDao;
import shop.model.Availability;
import shop.service.AvailabilityService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oleg on 11.03.16.
 */
@Service
public class AvailabilityServiceImpl extends BaseService<Availability, AvailabilityDao>
        implements AvailabilityService {
    public Map<String, Availability> getAllAsMap() {
        List<Availability> availabilityList = dao.findAll();
        Map<String, Availability> availabilityMap = new LinkedHashMap<>();
        for (Availability availability : availabilityList) {
            availabilityMap.put(availability.getStatus(), availability);
        }
        return availabilityMap;
    }
}
