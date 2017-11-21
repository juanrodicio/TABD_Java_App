import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import oracle.sql.STRUCT;

import javax.naming.spi.DirStateFactory;
import java.sql.*;
import java.util.ArrayList;
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
        
        FoodDAO fdDAO = new FoodDAO(conn);
        Wine_At_MerchantsDAO WaMDAO = new Wine_At_MerchantsDAO(conn);
        MerchantDAO MerchDAO = new MerchantDAO(conn);

        Date fecha_inicial = new Date(2017,11,22);
        Date fecha_final = new Date(2017,11,27);

        MerchDAO.add_merchant("nuevo merchant");
        MerchDAO.delete_merchant(7);

        /*ArrayList<Wine_At_Merchants> ofertas = WaMDAO.search_offers(fecha_inicial, fecha_final);

        for(Wine_At_Merchants oferta : ofertas) {
            System.out.println("Fecha_ini : "+ oferta.offer_start_date +"\n"+
                                "Fecha_fin : "+ oferta.offer_finish_date+"\n"+
                                "Precio: " + oferta.price_on_offer);
        }*/
    }
}
