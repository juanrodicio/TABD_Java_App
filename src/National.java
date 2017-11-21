import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class National extends Certificate {
    public String organisation_name;

    public National() {

    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        super.readSQL(sqlInput, s);
        this.organisation_name = sqlInput.readString();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        super.writeSQL(sqlOutput);
        sqlOutput.writeString(this.organisation_name);
    }
}
