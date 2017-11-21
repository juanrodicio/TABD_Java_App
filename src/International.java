import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class International extends Certificate {
    public String congress_name;

    public International() {

    }

    public International(int certificate_id, String certificate_name, String congress_name) {
        super(certificate_id, certificate_name);
        this.congress_name = congress_name;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {
        super.readSQL(sqlInput, s);
        this.congress_name = sqlInput.readString();
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        super.writeSQL(sqlOutput);
        sqlOutput.writeString(this.congress_name);
    }
}
