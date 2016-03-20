package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.VendorDao;
import shop.model.Vendor;
import shop.service.VendorService;

/**
 * Created by oleg on 11.03.16.
 */
@Service
public class VendorServiceImpl extends BaseService<Vendor, VendorDao> implements VendorService {
}
