import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class Wine_At_MerchantsDAO {

    Connection conn;

    public Wine_At_MerchantsDAO(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Wine_At_Merchants> search_offers(String p_initial_date, String p_final_date){
        ArrayList<Wine_At_Merchants> offersArray = new ArrayList<>();
        CallableStatement call = null;
        try {
            call = conn.prepareCall("{? = call search_package.search_offers(?,?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, p_initial_date);
            call.setString(3, p_final_date);
            call.execute();
            ResultSet rset = (ResultSet) call.getObject(1);

            while (rset.next ()) {
                Wine_At_Merchants WMerch = (Wine_At_Merchants) rset.getObject(1);
                offersArray.add(WMerch);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return offersArray;
    }

    public void add_offer(Integer p_wine_id, Integer p_merchant_id, Date p_initial_date, Date p_final_date, Double priceOnOffer){
        CallableStatement call = null;
        try {
            call = conn.prepareCall("{call method_wrappers.p_wine_add_offer(?,?,?,?,?)}");
            call.setInt(1, p_wine_id);
            call.setInt(2, p_merchant_id);
            call.setDate(3, p_initial_date);
            call.setDate(4, p_final_date);
            call.setDouble(5, priceOnOffer);
            call.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete_expired_offers(){
        CallableStatement call = null;
        try {
            call = conn.prepareCall("{call delete_package.delete_expired_offers()}");
            call.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
