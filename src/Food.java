import java.sql.*;

public class Food implements SQLData {
    private String sql_type;
    public String food_name;
    public String food_description;
    public Array go_with;

    public Food() {
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        this.food_name = sqlInput.readString();
        this.food_description = sqlInput.readString();
        this.go_with = sqlInput.readArray();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeString(this.food_name);
        sqlOutput.writeString(this.food_description);
        sqlOutput.writeArray(this.go_with);
    }
}
