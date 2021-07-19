package DAO;

import Model.User;
import Model.UserAndPhoneInfo;
import db.SingleConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection connection;

    public UserDAO(){
        connection = SingleConnection.getConnection();
    }

    public void insert(User user) throws SQLException {
        try{

            String sql = "INSERT INTO usersjdbc (name, email) VALUES(?,?)";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setString(1, user.getName());
            sqlStatement.setString(2, user.getEmail());
            sqlStatement.execute();
            connection.commit();

        }catch(SQLException error){
            connection.rollback();
            error.printStackTrace();
        }
    }

    public List<User> selectAll() throws SQLException {
        List<User> users = new ArrayList();

        String sql = "SELECT * FROM usersjdbc ORDER BY id ASC";
        PreparedStatement sqlStatement = connection.prepareStatement(sql);
        ResultSet result =  sqlStatement.executeQuery();

        while(result.next()){
            users.add(new User(result.getLong(1), result.getString(2), result.getString(3)));
        }

        return users;
    }

    public User select(Long id) throws SQLException {
        User user = new User();

        String sql = "SELECT * FROM usersjdbc WHERE id = (?)";
        PreparedStatement sqlStatement = connection.prepareStatement(sql);
        sqlStatement.setLong(1, id);
        ResultSet result = sqlStatement.executeQuery();

        if(result.next()){
            user = new User(result.getLong(1), result.getString(2), result.getString(3));
        }

        return user;
    }

    public void update(Long id, String name, String email) throws SQLException {

        try{

            String sql = "UPDATE usersjdbc SET name = ?, email = ? WHERE id = ?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setString(1, name);
            sqlStatement.setString(2, email);
            sqlStatement.setLong(3, id);
            int x = sqlStatement.executeUpdate();
            connection.commit();

            System.out.println("The query has updated " + x + " rows");

        }catch(SQLException error){
            connection.rollback();
            error.printStackTrace();
        }
    }

    public void delete(Long id) throws SQLException{
        try{
            // it is also possible to concatenate the string with given values on place, instead of using the set methods of preparedstatement.
            String sql = "DELETE FROM usersjdbc WHERE id = ?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setLong(1, id);
            int x = sqlStatement.executeUpdate();
            connection.commit();

            System.out.println("The query has deleted " + x + " rows");

        }catch(SQLException error){
            connection.rollback();
            error.printStackTrace();
        }
    }

    public List<UserAndPhoneInfo> selectUserAndPhone(Long userId) throws SQLException {
        List<UserAndPhoneInfo> userAndPhoneInfos = new ArrayList();

        String sql = String.format("SELECT usersjdbc.id, name, email, telephonenumber, telephonetype from usersjdbc INNER JOIN userphone ON usersjdbc.id = userphone.userid WHERE usersjdbc.id = %s ORDER BY usersjdbc.id ASC", userId);
        PreparedStatement sqlStatement = connection.prepareStatement(sql);
        ResultSet result = sqlStatement.executeQuery();

        while (result.next()) {
            userAndPhoneInfos.add(new UserAndPhoneInfo(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            ));
        }

        return userAndPhoneInfos;
    }
}


//    CREATE SEQUENCE userjdbcsequence increment 1 minvalue 1 start 4;
//
//     ALTER TABLE usersjdbc ALTER COLUMN id SET default nextval('userjdbcsequence'::regclass);