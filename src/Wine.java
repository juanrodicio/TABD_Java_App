import java.sql.*;

public class Wine implements SQLData {

    private String sql_type;
    public int wine_id;
    public Ref winemaker_id;
    public String wine_name;
    public String wine_description;
    public String good_years;
    public Double price_bottle;
    public Ref rated_by;
    public Ref has_color;
    public Array wines_at_merchants;
    public Array wines_go_with_food;
    public Array has_certificates;

    public Wine() {
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        this.wine_id = sqlInput.readInt();
        this.winemaker_id = sqlInput.readRef();
        this.wine_name = sqlInput.readString();
        this.wine_description = sqlInput.readString();
        this.good_years = sqlInput.readString();
        this.price_bottle = sqlInput.readDouble();
        this.rated_by = sqlInput.readRef();
        this.has_color = sqlInput.readRef();
        this.wines_at_merchants = sqlInput.readArray();
        this.wines_go_with_food = sqlInput.readArray();
        this.has_certificates = sqlInput.readArray();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeInt(this.wine_id);
        sqlOutput.writeRef(this.winemaker_id);
        sqlOutput.writeString(this.wine_name);
        sqlOutput.writeString(this.wine_description);
        sqlOutput.writeString(this.good_years);
        sqlOutput.writeDouble(this.price_bottle);
        sqlOutput.writeRef(this.rated_by);
        sqlOutput.writeRef(this.has_color);
        sqlOutput.writeArray(this.wines_at_merchants);
        sqlOutput.writeArray(this.wines_go_with_food);
        sqlOutput.writeArray(this.has_certificates);
    }
}
