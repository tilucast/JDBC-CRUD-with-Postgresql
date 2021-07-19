package DAO;

import Model.UserPhone;
import db.SingleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserTelephoneDAO {

    private Connection connection;

    public UserTelephoneDAO(){
        this.connection = SingleConnection.getConnection();
    }

    public void insert(UserPhone userPhone) throws  SQLException{
        try{

            String sql = String.format("INSERT INTO userphone (telephonenumber, telephonetype, userid) VALUES('%s','%s',%d)", userPhone.getTelephoneNumber(), userPhone.getTelephoneType(), userPhone.getUserId());
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            int x = sqlStatement.executeUpdate();
            connection.commit();

            System.out.println("The query has created " + x + " rows");

        }catch(SQLException error){
            connection.rollback();
            error.printStackTrace();
        }
    }

    public List<UserPhone> selectAll() throws SQLException {
        List<UserPhone> phones = new ArrayList();

        String sql = "SELECT * FROM userphone ORDER BY id ASC";
        PreparedStatement sqlStatement = connection.prepareStatement(sql);
        ResultSet result = sqlStatement.executeQuery();

        while(result.next()){
            phones.add(new UserPhone(result.getLong(1), result.getString(2), result.getString(3), result.getLong(4)));
        }

        return phones;
    }

    public void delete(Long id) throws SQLException{
        try{

            String sql = String.format("DELETE FROM userphone WHERE id = %d", id);
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            int x = sqlStatement.executeUpdate();
            connection.commit();

            System.out.println("The query has updated " + x + " rows");

        }catch(SQLException error){
            connection.rollback();
            error.printStackTrace();
        }
    }

    public void deleteWithUserId(Long id) throws SQLException{
        try{

            String sql = String.format("DELETE FROM userphone WHERE userid = %d", id);
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            int x = sqlStatement.executeUpdate();
            connection.commit();

            System.out.println("The query has updated " + x + " rows");

        }catch(SQLException error){
            connection.rollback();
            error.printStackTrace();
        }
    }

}
