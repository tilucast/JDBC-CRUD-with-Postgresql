import DAO.UserTelephoneDAO;
import Model.UserPhone;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestPhoneDAO {

    public UserTelephoneDAO userTelephoneDAO = new UserTelephoneDAO();

    @Test
    public void selectAll(){
        try{
            List<UserPhone> phones = userTelephoneDAO.selectAll();
            System.out.println(phones);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Test
    public void insert(){
        try{
            UserPhone userPhone = new UserPhone("44955248762", "iphone", 2L);
            userTelephoneDAO.insert(userPhone);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Test
    public void delete(){
        try{
            userTelephoneDAO.delete(2L);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
