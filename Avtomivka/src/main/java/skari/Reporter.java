package skari;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reporter extends Thread{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000*60*60*24*7);
                stat1();
                stat2();
                stat3();
                stat4();
                stat5();
                stat6();
                stat7();
                stat8();
                stat9();
                stat10();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void stat1() throws SQLException {
        //Общ брой направени продажби на неговата скара
        String sql = "SELECT COUNT(*) AS total FROM sales WHERE shop_id = ?";//9
        Connection c = DBManager.getInstance().getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, 9);
        ResultSet rs = ps.executeQuery();
        rs.next();
        System.out.println(rs.getInt("total"));
    }

    private void stat2() throws SQLException {
        //Най-продавано месо на неговата скара
        String sql = "SELECT m.name AS meat_name, COUNT(s.id) AS total " +
                "FROM sales AS s " +
                "JOIN meat_types AS m ON m.id = s.meat_type_id " +
                "WHERE s.shop_id = ? " +
                "GROUP BY m.name " +
                "ORDER BY total DESC LIMIT 1";//9
        Connection c = DBManager.getInstance().getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, 9);
        ResultSet rs = ps.executeQuery();
        rs.next();
        System.out.println(rs.getString("meat_name"));
    }

    private void stat3() throws SQLException {
        //Обща печалба от всички продадени порции
        String ebatiSelecta = "" +
                "SELECT meat_type_id, COUNT(*) AS total FROM sales WHERE shop_id = ? GROUP BY meat_type_id" +
                "UNION " +
                "SELECT salad_type_id, COUNT(*) AS total FROM sales WHERE shop_id = ? GROUP BY salad_type_id" +
                "UNION " +
                "SELECT bread_type_id, COUNT(*) AS total FROM sales WHERE shop_id = ? GROUP BY bread_type_id";
        /*
                3, 14 -> 14 parjoli
                4, 12 -> 12 pleskavici
                5, 3  -> 3 kiufteta
                //...
         */
    }

    private void stat4(){
        String sql = "SELECT garnish_type_id, COUNT(*)*200/1000 AS kg FROM sales WHERE shop_id = ? GROUP BY garnish_type_id";
    }

    private void stat5(){
        String sql = "SELECT shop_id, COUNT(*) AS total FROM sales GROUP BY shop_id WHERE bread_type_id = ? ORDER BY total DESC LIMIT 1";
    }

    private void stat6(){
        String sql = "SELECT s.name, COUNT(sales.id) FROM shops AS s JOIN sales ON s.id = sales.shop_id";
    }

    private void stat7(){
        String sql = "SELECT shop_id, COUNT(*) AS total FROM sales GROUP BY shop_id WHERE bread_type_id = ? ORDER BY total DESC LIMIT 1";
    }

    private void stat8(){
        String sql = "SELECT COUNT(*) FROM sales WHERE meat_type_id = ?";
    }

    private void stat9(){
        String sql = "SELECT COUNT(*) AS total, garnish_type_id FROM sales GROUP BY garnish_type_id ORDER BY total DESC LIMIT 1";
    }

    private void stat10(){
        String sql = "SELECT COUNT(*) AS total, garnish_type_id FROM sales WHERE shop_id = ? GROUP BY garnish_type_id ORDER BY total LIMIT 1";
    }
}
