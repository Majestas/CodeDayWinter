import java.io.IOException;
import java.sql.SQLException;

public class RobotRescue {

	public static void main(String[] args) throws IOException, SQLException {
		Database.saveForm();
		Display.initDisplay();

	}
}
