import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Certificate implements SQLData {

    private String sql_type;
    public int certificate_id;
    public String certificate_name;

    public Certificate() {
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        this.certificate_id = sqlInput.readInt();
        this.certificate_name = sqlInput.readString();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeInt(this.certificate_id);
        sqlOutput.writeString(this.certificate_name);
    }
}
