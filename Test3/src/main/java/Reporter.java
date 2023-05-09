import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Reporter extends Thread {

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000*60*60*24*30);
                DBManager.getInstance().stat1();
                DBManager.getInstance().stats2();
                stat3();
                stat4();
                stat5();


            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
