import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Rating_Guide implements SQLData {


    private String sql_type;
    public int rating_id;
    public String rating_description;

    public Rating_Guide() {
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        this.rating_id = sqlInput.readInt();
        this.rating_description = sqlInput.readString();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeInt(this.rating_id);
        sqlOutput.writeString(this.rating_description);
    }
}
