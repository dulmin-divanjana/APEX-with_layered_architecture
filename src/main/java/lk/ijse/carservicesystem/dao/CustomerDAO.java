package lk.ijse.carservicesystem.dao;

import lk.ijse.carservicesystem.db.DbConnection;
import lk.ijse.carservicesystem.dto.CustomerDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public interface CustomerDAO {
    public ArrayList<CustomerDto> getAllCustomer() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ArrayList<CustomerDto> getAllCustomer=new ArrayList<>();
        while (rst.next()){
            CustomerDto customerDTO=new CustomerDto(rst.getString("id"),
                    rst.getString("name"), rst.getString("address"));
            getAllCustomer.add(customerDTO);
        }
        return getAllCustomer;


    }
}
