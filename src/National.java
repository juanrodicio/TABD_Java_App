import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class National extends Certificate {
    public String organisation_name;

    public National() {

    }

    public National(int certificate_id, String certificate_name, String organisation_name) {
        super(certificate_id, certificate_name);
        this.organisation_name = organisation_name;
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
