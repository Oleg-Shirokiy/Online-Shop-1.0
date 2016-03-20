package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.AttributeDao;
import shop.model.Attribute;
import shop.service.AttributeService;

/**
 * Created by oleg on 11.03.16.
 */
@Service
public class AttributeServiceImpl extends BaseService<Attribute, AttributeDao> implements AttributeService {
}
