import java.sql.*;

public class Wine_Colour implements SQLData {
    private String sql_type;
    public String colour;
    public Array wines_with_color;
    public Array colours_rating_guides;

    public Wine_Colour() {
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        this.colour = sqlInput.readString();
        this.wines_with_color = sqlInput.readArray();
        this.colours_rating_guides = sqlInput.readArray();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeString(this.colour);
        sqlOutput.writeArray(this.wines_with_color);
        sqlOutput.writeArray(this.colours_rating_guides);
    }
}
