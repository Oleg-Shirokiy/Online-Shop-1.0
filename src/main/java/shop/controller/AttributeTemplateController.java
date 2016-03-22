package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.model.AttributeTemplate;
import shop.service.AttributeTemplateService;
import shop.util.JspPath;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by oleg on 13.03.16.
 */
@Controller
public class AttributeTemplateController {
    @Autowired
    AttributeTemplateService attributeTemplateService;

    /**
     * It allows to view attribute template page. On this page we can see list of attribute templates,
     * add new and edit existing templates.
     * @param id - attribute template identifier to show page in edit mode
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/admin/attributeBuilder", method = RequestMethod.GET)
    public ModelAndView showAttributeTemplateBuilder(@RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ATTRIBUTE_TEMPLATE_BUILDER);

        List<AttributeTemplate> attributeTemplateList = attributeTemplateService.getAll();
        modelAndView.addObject("attributeTemplateList", attributeTemplateList);

        if (id != null) {
            AttributeTemplate attributeTemplate = attributeTemplateService.getById(id);
            modelAndView.addObject("attributeTemplate", attributeTemplate);
        }

        return modelAndView;
    }

    /**
     * It allows to create new attribute template or update existing.
     * @param template - the existed attribute template will be updated if template have id.
     *                   The new template will by created if id is absent.
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/admin/addAttributeTemplate", method = RequestMethod.POST)
    public String addAttributeTemplate(@ModelAttribute AttributeTemplate template) throws SQLException {
        if (template.getId() != null) {
            attributeTemplateService.update(template);
        } else {
            attributeTemplateService.insert(template);
        }
        return "redirect:/admin/attributeBuilder?id=" + template.getId();
    }
}
