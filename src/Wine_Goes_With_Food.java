import java.sql.*;

public class Wine_Goes_With_Food implements SQLData {

    private String sql_type;
    public Ref wine_id;
    public Ref food_name;
    public String comments;

    public Wine_Goes_With_Food() {

    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        this.wine_id = sqlInput.readRef();
        this.food_name = sqlInput.readRef();
        this.comments = sqlInput.readString();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeRef(this.wine_id);
        sqlOutput.writeRef(this.food_name);
        sqlOutput.writeString(this.comments);
    }
}
