package DBAccess;

import FunctionLayer.FogException;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.User;

import java.sql.*;
import java.util.ArrayList;

public class OrderMapper {

    public static ArrayList<Order> getOrderList() throws FogException {
        ArrayList<Order> orderList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM `order`");

            while (resultSet.next()) {
                Order order = new Order();
                getOrderFromDB(order, resultSet);
                orderList.add(order);
            }

        } catch (SQLException e) {
            throw new FogException(e.toString(), "getOrderList(): SQL syntax fejl");
        } catch (ClassNotFoundException e) {
            throw new FogException(e.toString(), "getOrderList(): JDBC driver ikke fundet");
        }
        return orderList;
    }

    /**
     * @param order
     */
    public static void insertOrder(Order order) throws FogException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Connector.connection();
            preparedStatement = connection.prepareStatement("insert into Fog.order " +
                    "(user_id, status, itemlist, price, roof_id, roof_angle, length, width, height, shed_length, shed_width, comment) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, order.getUser().getUserId());
            preparedStatement.setString(2, order.getStatus());
            preparedStatement.setString(3, "");
            preparedStatement.setDouble(4, order.getPrice());
            preparedStatement.setInt(5, order.getRoofId());
            preparedStatement.setInt(6, order.getAngle());
            preparedStatement.setInt(7, order.getLength());
            preparedStatement.setInt(8, order.getWidth());
            preparedStatement.setInt(9, order.getHeight());
            preparedStatement.setInt(10, order.getShedLength());
            preparedStatement.setInt(11, order.getShedWidth());
            preparedStatement.setString(12, order.getComment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new FogException(e.toString(), "insertOrder(): SQL syntax fejl");
        } catch (ClassNotFoundException e) {
            throw new FogException(e.toString(), "insertOrder(): JDBC driver ikke fundet");
        } catch (NullPointerException e) {
            throw new FogException(e.toString(), "insertOrder(): Null pointer, check user");
        }
    }

    public static ArrayList<Order> getUserOrderList(User user) throws FogException {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Fog.`order` WHERE user_id = ?");
            ps.setInt(1, user.getUserId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                getOrderFromDB(order, resultSet);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new FogException(e.toString(), "getUserOrderList(): SQL syntax fejl");
        } catch (ClassNotFoundException e) {
            throw new FogException(e.toString(), "getUserOrderList(): JDBC driver ikke fundet");
        }
        return orders;
    }

    public static ArrayList<Order> getOrdersByStatus(String status) throws FogException {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Fog.`order` WHERE status = ?");
            ps.setString(1, status);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                getOrderFromDB(order, resultSet);
                orders.add(order);
            }

        } catch (SQLException e) {
            throw new FogException(e.toString(), "getOrdersByStatus(): SQL syntax fejl");
        } catch (ClassNotFoundException e) {
            throw new FogException(e.toString(), "getOrdersByStatus(): JDBC driver ikke fundet");
        }
        return orders;
    }

    public static Order getSingleOrder(String orderId) throws FogException {
        Order order = new Order();
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Fog.`order` WHERE order_id = ?");
            ps.setString(1, orderId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                getOrderFromDB(order, resultSet);
            }
        } catch (SQLException e) {
            throw new FogException(e.toString(), "getSingleOrder(): SQL syntax fejl");
        } catch (ClassNotFoundException e) {
            throw new FogException(e.toString(), "getSingleOrder(): JDBC driver ikke fundet");
        }
        return order;
    }

    private static void getOrderFromDB(Order order, ResultSet resultSet) throws SQLException, FogException {
        order.setOrderId(resultSet.getInt("order_id"));
        order.setUser(UserMapper.getUser(resultSet.getInt("user_id")));
        order.setStatus(resultSet.getString("status"));
        order.setOrderLineList(new ArrayList<>());
        order.setPrice(resultSet.getDouble("price"));
        order.setRoofId(resultSet.getInt("roof_id"));
        order.setAngle(resultSet.getInt("roof_angle"));
        order.setLength(resultSet.getInt("length"));
        order.setWidth(resultSet.getInt("width"));
        order.setHeight(resultSet.getInt("height"));
        order.setShedLength(resultSet.getInt("shed_length"));
        order.setShedWidth(resultSet.getInt("shed_width"));
        order.setComment(resultSet.getString("comment"));
    }

    public static void setPrice(double newPrice, int orderId) throws FogException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Connector.connection();
            preparedStatement = connection.prepareStatement("UPDATE Fog.`order` SET price = ? WHERE order_id = ?");
            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new FogException(e.toString(), "setPriceAndStatus(): SQL syntax fejl");
        } catch (ClassNotFoundException e) {
            throw new FogException(e.toString(), "setPriceAndStatus(): JDBC driver ikke fundet");
        }
    }

    public static void setStatus(String newStatus, int orderId) throws FogException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Connector.connection();
            preparedStatement = connection.prepareStatement("UPDATE Fog.`order` set status = ? WHERE order_id = ?");
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new FogException(e.toString(), "setPriceAndStatus(): SQL syntax fejl");
        } catch (ClassNotFoundException e) {
            throw new FogException(e.toString(), "setPriceAndStatus(): JDBC driver ikke fundet");
        }
    }
}

