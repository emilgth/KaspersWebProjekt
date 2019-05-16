package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        double newPrice = Double.parseDouble(request.getParameter("newPrice"));
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        LogicFacade.confirmOrder(newPrice, orderId);
        return "newOrders";
    }
}
