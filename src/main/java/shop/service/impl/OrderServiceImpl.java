package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.OrderDao;
import shop.model.Order;
import shop.service.OrderService;
import shop.util.MailUtil;

/**
 * Created by oleg on 05.03.16.
 */
@Service
public class OrderServiceImpl extends BaseService<Order, OrderDao> implements OrderService {

    @Autowired
    private MailUtil mailUtil;

    private String senderEmail = "oleg.shirokiy.it@gmail.com";
    private String subject = "Order";

    public Order getByIdWithProductList(Integer id) {
        Order order = dao.findOne(id);
        order.getProductList().size();
        return order;
    }
    @Override
    public Order insert(Order order) {
        dao.save(order);
        String email = order.getEmail();
        if (email != null) {
            mailUtil.sendMessage(senderEmail, email, subject,
                                        getTextByOrder(order));
        }
        return order;
    }
    private String getTextByOrder(Order order) {

        return "You ordered something in our shop.. congratulation!";
    }

    public MailUtil getMailUtil() {
        return mailUtil;
    }

    public void setMailUtil(MailUtil mailUtil) {
        this.mailUtil = mailUtil;
    }

}
