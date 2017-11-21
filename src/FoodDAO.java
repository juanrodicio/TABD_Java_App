import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodDAO {

    Connection conn;

    public FoodDAO(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Food> search_by_wine(String wine_name){
        ArrayList<Food> foodArray = new ArrayList<>();
        CallableStatement call = null;
        try {
            call = conn.prepareCall("{? = call search_package.search_foods_by_wine(?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2,wine_name);
            call.execute();
            ResultSet rset = (ResultSet) call.getObject(1);

            while (rset.next ()) {
                Food fd = (Food) rset.getObject(1);
                foodArray.add(fd);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return foodArray;
    }

    public void add_food(String food_name, String food_description){
        CallableStatement call = null;
        try {
            call = conn.prepareCall("{call insert_package.insert_food(?,?)}");
            call.setString(1,food_name);
            call.setString(2,food_description);
            call.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete_food (String food_name){
        CallableStatement call = null;
        try {
            call = conn.prepareCall("{call delete_package.delete_food(?)}");
            call.setString(1,food_name);
            call.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
