import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.*;
public class Main {
    public static void main(String[] parameter) {
        // 1st query
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/demo1";
            String userName = "root";
            String password = "Abhishek";
            Connection con = DriverManager.getConnection(url,userName,password);
            String q = "select season,count(season) from matches group by season";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            System.out.print("{");
            while(set.next()){
                int id = set.getInt(1);
                String season = set.getString(2);
                System.out.print(id+"="+season+" , ");
            }
            System.out.print("}");
            System.out.println();
        }
        catch (Exception e){
            e.printStackTrace(System.out);
        }

        // 2nd query

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/demo1";
            String userName = "root";
            String password = "Abhishek";
            Connection con = DriverManager.getConnection(url,userName,password);

            String q = "select winner,count(winner) from matches group by winner";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            System.out.print("{");
            while(set.next()){
                String team = set.getString(1);
                int matchesWon = set.getInt(2);
                System.out.print(team+"="+matchesWon+" , ");
            }
            System.out.print("}");
            System.out.println();
        }
        catch (Exception e){
            e.printStackTrace(System.out);
        }

        // 3 query

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/demo1";
            String userName = "root";
            String password = "Abhishek";
            Connection con = DriverManager.getConnection(url,userName,password);

            String q = "select batting_team as team,sum(extra_runs) as total_run from deliveries join matches where season = 2016 group by batting_team;";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            System.out.print("{");
            while(set.next()){
                String team = set.getString(1);
                int run = set.getInt(2);
                System.out.print(team+"="+run+" , ");
            }
            System.out.print("}");
            System.out.println();
        }
        catch (Exception e){
            e.printStackTrace(System.out);
        }

        // 4 query
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/demo1";
            String userName = "root";
            String password = "Abhishek";
            Connection con = DriverManager.getConnection(url,userName,password);

            String q = "select bowler,sum(total_runs)/(count(bowler)/6.0) as economy from deliveries join matches where season = 2015 group by bowler order by economy;";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            System.out.print("{");
            while(set.next()){
                String bowler = set.getString(1);
                double economy = set.getInt(2);
                System.out.print(bowler+"="+economy+" , ");
           }
            System.out.print("}");
        }
        catch (Exception e){
            e.printStackTrace(System.out);
        }

    }
}

