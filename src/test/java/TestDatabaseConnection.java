import DAO.UserDAO;
import DAO.UserTelephoneDAO;
import Model.User;
import Model.UserAndPhoneInfo;
import db.SingleConnection;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestDatabaseConnection {

    public UserDAO userDao = new UserDAO();
    public UserTelephoneDAO userTelephoneDAO = new UserTelephoneDAO();

    @Test
    public void createUser(){
        try {
            userDao.insert(new User("Rulio Pestinha", "pestinha@praga.com"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void selectAllUsers(){
        try{
            List<User> users = userDao.selectAll();
            System.out.println(users);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Test
    public void selectOneUser(){
        try{
            User user = userDao.select(4L);
            System.out.println(user);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Test
    public void update(){
        try{
            userDao.update(4L, "Zivinha", "ziva@zivinha.com");
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Test
    public void delete(){
        try{
            userDao.delete(4L);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Test
    public void selectInnerJoin(){
        try {
            List<UserAndPhoneInfo> result = userDao.selectUserAndPhone(3L);
            System.out.println(result);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Test
    public void deleteUserAndPhones(){
        try{
            userTelephoneDAO.deleteWithUserId(2L);
            userDao.delete(2L);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
