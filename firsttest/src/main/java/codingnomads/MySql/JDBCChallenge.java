package codingnomads.MySql;


import java.sql.*;
import java.util.ArrayList;

/**
 * Create a new, simple, relational DB and integrate with that DB here in this class
 */
public class JDBCChallenge {

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public static void main(String[] args) {
        JDBCChallenge races = new JDBCChallenge();
        // controller
        try {
            races.readDataBase("Budapest Spring Half Marathon", "Hungary");
        } catch (Exception e) {
            System.out.println("error in readDateBase()" + e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    public void readDataBase(String Half_name, String Half_Country)
            throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Races?" +
                    "user=root&password=Leander97&useSSL=false");


            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from Races.HalfMarathons;");

            writeResultSet(resultSet);
            ArrayList<HalfMarathon> half = mapResultSetToObjects(resultSet);

            for (HalfMarathon h : half) {
                System.out.println(h.toString());
            }


            // PreparedStatements can use variables and are more efficient
            preparedStatement = connection
                    .prepareStatement("insert into  Races.HalfMarathons (Half_name, Half_Country) " +
                            "values (?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, Half_name);
            // preparedStatement.setString(2, credits);
            preparedStatement.setString(2, Half_Country);
            //preparedStatement.setString(4, department);
            preparedStatement.executeUpdate();


            preparedStatement = connection
                    .prepareStatement("SELECT * from Races.HalfMarathons");
            resultSet = preparedStatement.executeQuery();

            //writeResultSet(resultSet);


            //Remove again the insert comment
            preparedStatement = connection
                    .prepareStatement("delete from Races.HalfMarathons where Half_name = ? ; ");
            preparedStatement.setString(1, "JDBC Half Marathon 1");
            preparedStatement.executeUpdate();

            resultSet = statement.executeQuery("select * from Races.HalfMarathons");

            writeMetaData(resultSet);

            writeResultSet(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //         Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));

        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String Half_name = resultSet.getString("Half_name");
            //String description = resultSet.getString("description");
            String Half_country = resultSet.getString("Half_Country");
            //String department = resultSet.getString("department");
            System.out.println("Half Marathon name: " + Half_name);
            // System.out.println("Description: " + description);
            System.out.println("Half Marathon country: " + Half_country);
            // System.out.println("Department: " + department);
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");

        }
    }


    // select one or more records from the DB

    // call the mapResultSetToObjects()
    //mapResultSetToObjects();
    //}

    // demonstrate a join query and map the results to another custom object
//    public YOUR_JOIN_OBJECT joinQuery(){
//
//    }

    // insert a record from the db
    public void insert(String arg1, String arg2) {

    }

    // delete a record from the db
    public void delete() {

    }


    private ArrayList<HalfMarathon> mapResultSetToObjects(ResultSet resultSet) throws SQLException {
        ArrayList<HalfMarathon> retList = new ArrayList();

//        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            HalfMarathon h = new HalfMarathon();
            h.setId(resultSet.getInt("id"));
            h.setHalf_name(resultSet.getString("name"));
            h.setHalf_Country(resultSet.getString("country"));

            retList.add(h);
        }

        return retList;
    }



    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {

        }
    }

}