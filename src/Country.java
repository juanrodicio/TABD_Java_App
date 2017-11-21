import java.sql.*;

public class Country implements SQLData {

    private String sql_type;
    public int country_id;
    public String country_name;
    public Array winemakers_located;

    public Country() {
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        this.country_id = sqlInput.readInt();
        this.country_name = sqlInput.readString();
        this.winemakers_located = sqlInput.readArray();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeInt(this.country_id);
        sqlOutput.writeString(this.country_name);
        sqlOutput.writeArray(this.winemakers_located);
    }
}
