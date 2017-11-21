import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Merchant implements SQLData {

    private String sql_type;
    public int merchant_id;
    public String merchant_name;

    public Merchant() {
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        this.merchant_id = sqlInput.readInt();
        this.merchant_name = sqlInput.readString();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeInt(this.merchant_id);
        sqlOutput.writeString(this.merchant_name);
    }
}
