import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;

public class WineDAO {

    Connection conn;

    public WineDAO(Connection conn) {
        this.conn = conn;
    }

    // Search methods
    public ArrayList<Wine> search_by_name(String name) {
        ArrayList<Wine> array_wines = new ArrayList<Wine>();
        CallableStatement call = null;

        try {
            call = conn.prepareCall("{? = call search_package.search_wines_by_name(?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2,name);
            call.execute();
            ResultSet rset = (ResultSet) call.getObject(1);

            while (rset.next ()){
                Wine rg = (Wine) rset.getObject(1);
                array_wines.add(rg);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return array_wines;
    }

    public ArrayList<Wine> search_by_price(Double price_min, Double price_max) {
        ArrayList<Wine> array_wines = new ArrayList<Wine>();
        CallableStatement call = null;

        try {
            call = conn.prepareCall("{? = call search_package.search_wines_by_price(?, ?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setDouble(2,price_min);
            call.setDouble(3,price_max);
            call.execute();
            ResultSet rset = (ResultSet) call.getObject(1);

            while (rset.next ()){
                Wine rg = (Wine) rset.getObject(1);
                array_wines.add(rg);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return array_wines;
    }

    public ArrayList<Wine> search_by_colour(String colour) {
        ArrayList<Wine> array_wines = new ArrayList<Wine>();
        CallableStatement call = null;

        try {
            call = conn.prepareCall("{? = call search_package.search_wines_by_colour(?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2,colour);
            call.execute();
            ResultSet rset = (ResultSet) call.getObject(1);

            while (rset.next ()){
                Wine rg = (Wine) rset.getObject(1);
                array_wines.add(rg);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return array_wines;
    }

    public ArrayList<Wine> search_by_country(String country) {
        ArrayList<Wine> array_wines = new ArrayList<Wine>();
        CallableStatement call = null;

        try {
            call = conn.prepareCall("{? = call search_package.search_wines_by_country(?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2,country);
            call.execute();
            ResultSet rset = (ResultSet) call.getObject(1);

            while (rset.next ()){
                Wine rg = (Wine) rset.getObject(1);
                array_wines.add(rg);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return array_wines;
    }

    public ArrayList<Wine> search_by_winemaker(String winemaker) {
        ArrayList<Wine> array_wines = new ArrayList<Wine>();
        CallableStatement call = null;

        try {
            call = conn.prepareCall("{? = call search_package.search_wines_by_winemaker(?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2,winemaker);
            call.execute();
            ResultSet rset = (ResultSet) call.getObject(1);

            while (rset.next ()){
                Wine rg = (Wine) rset.getObject(1);
                array_wines.add(rg);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return array_wines;
    }

    public ArrayList<Wine> search_by_food(String food) {
        ArrayList<Wine> array_wines = new ArrayList<Wine>();
        CallableStatement call = null;

        try {
            call = conn.prepareCall("{? = call search_package.search_wines_by_food(?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2,food);
            call.execute();
            ResultSet rset = (ResultSet) call.getObject(1);

            while (rset.next ()){
                Wine rg = (Wine) rset.getObject(1);
                array_wines.add(rg);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return array_wines;
    }


    // Insert method


    // Update method
    public void update_wine(int wine_id, String wine_name, String wine_description, String good_years, Double price_bottle) {
        CallableStatement call = null;

        try {
            call = conn.prepareCall("{call update_package.update_wine(?,?,?,?,?)}");
            call.setInt(1,wine_id);
            call.setString(2, wine_name);
            call.setString(3, wine_description);
            call.setString(4, good_years);
            call.setDouble(5, price_bottle);
            call.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete method
    public void delete_wine(int wine_id) {
        CallableStatement call = null;

        try {
            call = conn.prepareCall("{call delete_package.delete_wine(?)}");
            call.setInt(1,wine_id);
            call.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
