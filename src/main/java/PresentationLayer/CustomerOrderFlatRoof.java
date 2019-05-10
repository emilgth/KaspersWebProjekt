package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.ListGen;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.OrderLine;
import FunctionLayer.Models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

class CustomerOrderFlatRoof extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String status = "pending";
        int roofId = Integer.parseInt(request.getParameter("Tag"));
        int angle = 0;
        int length = Integer.parseInt(request.getParameter("Carport_laengde"));
        int width = Integer.parseInt(request.getParameter("Carport_bredde"));

        //todo er height altid 3000?
        int height = 3000;
        int shedLength = Integer.parseInt(request.getParameter("Redskabsrum_laengde"));
        int shedWidth = Integer.parseInt(request.getParameter("Redskabsrum_bredde"));
        String comment = request.getParameter("bemaerkninger");
        Order order = new Order(user, status, roofId, angle, length, width, height, shedLength, shedWidth, comment);

        //todo hvad er formålet her?
        ArrayList<Order> orderList = OrderMapper.getOrderList();
        ArrayList<OrderLine> orderLineList = ListGen.getOrderLinelist(order);

        OrderMapper orderMapper = new OrderMapper();
        orderMapper.insertOrder(order);

        session.setAttribute("orderList", orderList);
        session.setAttribute("orderLineList", orderLineList);

        return "skitse";
    }
}
