package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.model.*;
import shop.service.*;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by oleg on 13.03.16.
 */
@Controller
public class AttributeController {
    @Autowired
    AttributeService attributeService;
    @Autowired
    AttributeTemplateService attributeTemplateService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductContentService productContentService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/admin/attributeForm", method = RequestMethod.GET)
    public ModelAndView showAttributeForm(HttpServletRequest request,
                                          @RequestParam(required = true) Integer id) throws SQLException{
        ModelAndView modelAndView = new ModelAndView(JspPath.ATTRIBUTE_FORM);

        Product product = productService.getById(id);
        Category category = categoryService.getByIdWithAttributeTemplateList(product.getCategory().getId());

//        List<AttributeTemplate> attributeTemplateList = attributeTemplateService.getAll();
        List<AttributeTemplate> attributeTemplateList = category.getAttributeTemplateList();
        modelAndView.addObject("attributeTemplateList", attributeTemplateList);

        return modelAndView;
    }

    @RequestMapping(value = "/admin/saveAttributes", method = RequestMethod.POST)
    public String saveAttributes(HttpServletRequest request,
                                 @RequestParam(required = true) Integer productContentId) throws SQLException {
        ProductContent productContent = productContentService.getById(productContentId);
        Set<Attribute> attributeSet = productContent.getAttributes();

        String[] attTmpIds = request.getParameterValues("attTmpId");
        String[] attrTmpNames = request.getParameterValues("attrTmpName");
        String[] attrTmpMeasurements = request.getParameterValues("attrTmpMeasurement");
        String[] attrTmpValues = request.getParameterValues("attrTmpValue");

        String[] attrIds = request.getParameterValues("attrId");
        String[] attrNames = request.getParameterValues("attrName");
        String[] attrMeasurements = request.getParameterValues("attrMeasurement");
        String[] attrValues = request.getParameterValues("attrValue");

//        List<Attribute> newAttributeList = new LinkedList<>();
        for (int i = 0; i < attTmpIds.length; i++) {
            AttributeTemplate attributeTemplate = new AttributeTemplate();
            attributeTemplate.setId(Integer.parseInt(attTmpIds[i]));
            attributeTemplate.setName(attrTmpNames[i]);
            attributeTemplate.setMeasurement(attrTmpMeasurements[i]);
            Attribute attribute = new Attribute();
            attribute.setAttributeTemplate(attributeTemplate);
            attribute.setValue(attrTmpValues[i]);
//            attributeService.insert(attribute);
            attributeSet.add(attribute);
        }

//        List<Attribute> attributeList = new LinkedList<>();
        for (int i = 0; i < attTmpIds.length; i++) {
            Attribute attribute = attributeService.getById(Integer.parseInt(attTmpIds[i]));
            attribute.setValue(attrValues[i]);
            attributeService.update(attribute);
        }

        return "redirect:/admin/attributeForm" + productContent.getProduct().getId();
    }


}

//<input type="hidden" name="attTmpId" value="${attrTmp.id}">
//<input type="text" name="attrTmpName" value="${attrTmp.name}">
//<input type="text" name="attrTmpMeasurement" value="${attrTmp.measurement}">
//<input type="text" name="attrTmpValue">

//<input type="hidden" name="attributeId" value="${attr.id}">
//<input type="text" name="attrName" value="${attr.name}">
//<input type="text" name="attrMeasurement" value="${attr.measurement}">
//<input type="text" name="attrValue" value="${attr.value}">