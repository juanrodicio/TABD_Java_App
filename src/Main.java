import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import oracle.sql.STRUCT;
import oracle.sql.*;
//import oracle.jdbc.OracleConnection;

import javax.naming.spi.DirStateFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
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

        /*DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet rs = dbmd.getTypeInfo();

        while(rs.next()) {
            System.out.println(rs.getString("TYPE_NAME"));
        }*/


        // Como crear nuevos ids para los certificados usando la secuencia
        /*CallableStatement call = null;

        try {
            call = conn.prepareCall("{? = call method_wrappers.f_nextval_certificate_seq}");
            call.registerOutParameter(1, OracleTypes.INTEGER);
            call.execute();
            int new_certificate_id = (int) call.getObject(1);
            System.out.println(new_certificate_id);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        // Intento de añadir vino (NO FUNCIONA POR EL ARRAY DE CERTIFICADOS
        /*Local local = new Local(154, "Vino Local", "UCA");
        National nacional = new National(155, "Vino Nacional", "UCA");

        Certificate[] certificates = new Certificate[]{nacional};

        java.sql.Array cert_array = conn.createArrayOf("Certificate_Type", certificates);
        
        WineDAO wdao = new WineDAO(conn);
        wdao.insert_wine(1, "El vino definitivo", "Este vino demuestra el buen " +
                "hacer durante muchas horas en TABD", "2010 - 2090", 80.0, 1,
                "blanco", cert_array);*/

        // Mostrar todos los vinos tras una consulta
        /*for(Wine wine : wines) {
            System.out.println(wine.wine_name);
        }*/
    }
}
