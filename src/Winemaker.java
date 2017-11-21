import java.sql.*;

public class Winemaker implements SQLData {
    private String sql_type;
    public int winemaker_id;
    public Ref located;
    public Array wines_made;
    public String winemaker_name;

    public Winemaker() {
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        this.winemaker_id = sqlInput.readInt();
        this.located = sqlInput.readRef();
        this.wines_made = sqlInput.readArray();
        this.winemaker_name = sqlInput.readString();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeInt(this.winemaker_id);
        sqlOutput.writeRef(this.located);
        sqlOutput.writeArray(this.wines_made);
        sqlOutput.writeString(this.winemaker_name);
    }
}
