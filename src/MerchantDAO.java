import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MerchantDAO {

    Connection conn;

    public MerchantDAO(Connection conn) {
        this.conn = conn;
    }

    public void add_merchant(String p_merchant_name){
        CallableStatement call = null;
        try {
            call = conn.prepareCall("{call insert_package.insert_merchant(?)}");
            call.setString(1, p_merchant_name);
            call.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete_merchant(Integer p_merchant_id){
        CallableStatement call = null;
        try {
            call = conn.prepareCall("{call delete_package.delete_merchant(?)}");
            call.setInt(1, p_merchant_id);
            call.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
