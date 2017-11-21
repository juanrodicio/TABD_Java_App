import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Local extends Certificate {
    public String partnership_name;

    public Local() {

    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        super.readSQL(sqlInput, s);
        this.partnership_name = sqlInput.readString();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        super.writeSQL(sqlOutput);
        sqlOutput.writeString(this.partnership_name);
    }
}
