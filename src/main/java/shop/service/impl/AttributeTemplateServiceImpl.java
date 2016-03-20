package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.dao.AttributeTemplateDao;
import shop.model.AttributeTemplate;
import shop.model.Category;
import shop.service.AttributeTemplateService;

import java.util.List;

/**
 * Created by oleg on 11.03.16.
 */
@Service
public class AttributeTemplateServiceImpl extends BaseService<AttributeTemplate,
        AttributeTemplateDao> implements AttributeTemplateService {
//    public List<AttributeTemplate> getByCategory(Category category) {
//        return dao.findByCategory(category);
//    }
}
