import java.sql.Date;
import java.sql.Ref;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Wine_At_Merchants implements SQLData {
    private String sql_type;
    public Ref merchant_id;
    public Date offer_start_date;
    public Date offer_finish_date;
    public Double price_on_offer;


    public Wine_At_Merchants() {

    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        this.merchant_id = sqlInput.readRef();
        this.offer_start_date = sqlInput.readDate();
        this.offer_finish_date = sqlInput.readDate();
        this.price_on_offer = sqlInput.readDouble();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeRef(merchant_id);
        sqlOutput.writeDate(offer_start_date);
        sqlOutput.writeDate(offer_finish_date);
        sqlOutput.writeDouble(price_on_offer);
    }
}
