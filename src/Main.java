import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import oracle.sql.STRUCT;

import javax.naming.spi.DirStateFactory;
import java.sql.*;
import java.util.Dictionary;
import java.util.Map;

public class Main {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnection.dbConnector();
        java.util.Map map = conn.getTypeMap();
        map.put("RATING_GUIDE_TYPE", Class.forName("Rating_Guide"));
        map.put("MERCHANTS_TYPE", Class.forName("Merchant"));
        map.put("WINE_AT_MERCHANTS_TYPE", Class.forName("Wine_At_Merchants"));
        map.put("CERTIFICATE_TYPE", Class.forName("Certificate"));
        map.put("LOCAL_TYPE", Class.forName("Local"));
        map.put("NATIONAL_TYPE", Class.forName("National"));
        map.put("INTERNATIONAL_TYPE", Class.forName("International"));
        map.put("WINE_TYPE", Class.forName("Wine"));
        map.put("WINE_COLOURS_TYPE", Class.forName("Wine_Colour"));
        map.put("COUNTRY_TYPE", Class.forName("Country"));
        map.put("FOOD_TYPE", Class.forName("Food"));
        map.put("WINEMAKER_TYPE", Class.forName("Winemaker"));
        map.put("WINE_GOES_WITH_FOOD_TYPE", Class.forName("Wine_Goes_With_Food"));
        conn.setTypeMap(map);

        // Esto es una prueba, lo de arriba no deberíais tocarlo.
        CallableStatement call = conn.prepareCall("{? = call search_package.search_wines_by_winemaker(?)}");
        call.registerOutParameter(1, OracleTypes.CURSOR);
        call.setString(2,"Tuscany Winemaker");
        call.execute();
        ResultSet rset = (ResultSet) call.getObject(1);

        // Dump the cursor
        while (rset.next ()){
            Wine rg = (Wine) rset.getObject(1);
            System.out.println(rg.wine_name);
        }
    }
}
