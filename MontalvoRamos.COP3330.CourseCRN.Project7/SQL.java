//Bryan Montalvo Ramos
//Cop 3330-24217
//3/30/2025
// Database Connectivity and Programing using SQLite and Intellij for all changes done to the connected Database
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class SQL {
    public static void main(String[] args) {
        // Set the path to the SQLite database file
        String url = "jdbc:sqlite:C:/Users/shado/Downloads/module7.db";
        //Connecting to the SQlite file
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connected to database\n");

            // Create tables if they don't already exist Yes, I added this in case there is an issue when I created the Database using the SQLite studio
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Drivers (Driverid INTEGER PRIMARY KEY, name VARCHAR(50), Lastname VARCHAR(50), Age INTEGER);");
            stmt.execute("CREATE TABLE IF NOT EXISTS Cars (carid INTEGER PRIMARY KEY, make VARCHAR(50), model VARCHAR(50), year INTEGER);");
            stmt.execute("CREATE TABLE IF NOT EXISTS Students (Studentid INTEGER PRIMARY KEY, name VARCHAR(50), Lastname VARCHAR(50), Age INTEGER);");
            stmt.close();

            // Print out all table names in the database
            System.out.println("Tables in Database:");
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet tables = meta.getTables(null, null, "%", new String[] {"TABLE"});
            while (tables.next()) {
                System.out.println("- " + tables.getString("TABLE_NAME"));
            }
            tables.close();
            System.out.println();
            //Print out Initial table before changes
            DefaultTableModel carModel = fetchDataAsTableModel(conn, "SELECT * FROM Cars");
            System.out.println("Cars Table (Before Data Insertion - TableModel):");
            printTableModel(carModel);

            // Insert some sample data into the Cars table
            String carSQL = "INSERT INTO Cars (make, model, year) VALUES (?, ?, ?)";
            PreparedStatement carStmt = conn.prepareStatement(carSQL);
            // Constructor adding in the data into the table
            carStmt.setString(1, "Toyota");
            carStmt.setString(2, "Supra");
            carStmt.setInt(3, 1998);
            carStmt.executeUpdate();

            carStmt.setString(1, "Nissan");
            carStmt.setString(2, "Skyline GTR");
            carStmt.setInt(3, 1999);
            carStmt.executeUpdate();

            carStmt.setString(1, "Mazda");
            carStmt.setString(2, "RX-7");
            carStmt.setInt(3, 1995);
            carStmt.executeUpdate();
            //Closes the query and prints out that it has inserted New rowsinto Cars table
            carStmt.close();
            System.out.println("Inserted new rows into Cars.\n");

            // Show the Cars table after inserting data
            DefaultTableModel carModel0 = fetchDataAsTableModel(conn, "SELECT * FROM Cars");
            System.out.println("Cars Table (After Data Insertion - TableModel):");
            printTableModel(carModel0);
            //Prints table before changes
            DefaultTableModel model1 = fetchDataAsTableModel(conn, "SELECT * FROM Students");
            System.out.println("Students Table (Before changes - TableModel):");
            printTableModel(model1);


            // Insert sample student data into Students table
            String insertSQL = "INSERT INTO Students (name, lastname, age) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);

            insertStmt.setString(1, "Tony");
            insertStmt.setString(2, "JA");
            insertStmt.setInt(3, 40);
            insertStmt.executeUpdate();

            insertStmt.setString(1, "John");
            insertStmt.setString(2, "Doe");
            insertStmt.setInt(3, 99);
            insertStmt.executeUpdate();

            insertStmt.setString(1, "John");
            insertStmt.setString(2, "Michael");
            insertStmt.setInt(3, 56);
            insertStmt.executeUpdate();

            insertStmt.setString(1, "Michael");
            insertStmt.setString(2, "Angelo");
            insertStmt.setInt(3, 18);
            insertStmt.executeUpdate();

            insertStmt.setString(1, "Mike");
            insertStmt.setString(2, "Jones");
            insertStmt.setInt(3, 30);
            insertStmt.executeUpdate();

            insertStmt.close();
            System.out.println("Inserted new rows into Students.\n");

            DefaultTableModel model2 = fetchDataAsTableModel(conn, "SELECT * FROM Students");
            System.out.println("Students Table (After Deletion - TableModel):");
            printTableModel(model2);

            // Delete two students from the table
            String deleteSQL = "DELETE FROM Students WHERE name = ?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL);
            deleteStmt.setString(1, "Tony");
            deleteStmt.executeUpdate();
            deleteStmt.setString(1, "John");
            deleteStmt.executeUpdate();
            deleteStmt.close();
            System.out.println("Deleted two rows from Students.\n");

            stmt.execute("DROP TABLE IF EXISTS Drivers;"); // Deletes the Drivers table if it exists


            // Print the Students table after deletions
            DefaultTableModel model3 = fetchDataAsTableModel(conn, "SELECT * FROM Students");
            System.out.println("Students Table (After Deletion - TableModel):");
            printTableModel(model3);

            // Search for all students under age 50 and print results
            ArrayList<ArrayList<String>> searchResults = fetchDataAsArrayList(conn, "SELECT * FROM Students WHERE age < 50");
            System.out.println("Students under 50 (ArrayList):");
            printArrayList(searchResults);

            // Update some student records (if they exist)
            String updateSQL = "UPDATE Students SET age = ? WHERE lastname = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
            updateStmt.setInt(1, 22);
            updateStmt.setString(2, "Angelo");
            updateStmt.executeUpdate();
            updateStmt.setInt(1, 30);
            updateStmt.setString(2, "Doe");
            updateStmt.executeUpdate();
            updateStmt.setInt(1, 45);
            updateStmt.setString(2, "Smith");
            updateStmt.executeUpdate();
            updateStmt.close();
            System.out.println("Updated three student records.\n");

            // Final display of Students table after updates
            DefaultTableModel model4 = fetchDataAsTableModel(conn, "SELECT * FROM Students");
            System.out.println("Final Students Table (TableModel):");
            printTableModel(model4);

            // Close the connection
            conn.close();
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch query results and store them in an ArrayList of ArrayLists
    public static ArrayList<ArrayList<String>> fetchDataAsArrayList(Connection conn, String query) throws SQLException {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int colCount = rs.getMetaData().getColumnCount();

        while (rs.next()) {
            ArrayList<String> row = new ArrayList<>();
            for (int i = 1; i <= colCount; i++) {
                row.add(rs.getString(i));
            }
            data.add(row);
        }

        rs.close();
        stmt.close();
        return data;
    }

    // Print out a 2D ArrayList to the console
    public static void printArrayList(ArrayList<ArrayList<String>> data) {
        for (ArrayList<String> row : data) {
            System.out.println(row);
        }
    }

    // Converts a query result into a DefaultTableModel (used for displaying tables)
    public static DefaultTableModel fetchDataAsTableModel(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();

        String[] colNames = new String[columns];
        for (int i = 0; i < columns; i++) {
            colNames[i] = rsmd.getColumnName(i + 1);
        }

        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        while (rs.next()) {
            String[] row = new String[columns];
            for (int i = 0; i < columns; i++) {
                row[i] = rs.getString(i + 1);
            }
            model.addRow(row);
        }

        rs.close();
        stmt.close();
        return model;
    }

    // Print out a DefaultTableModel to the console
    public static void printTableModel(DefaultTableModel model) {
        int rowCount = model.getRowCount();
        int colCount = model.getColumnCount();

        for (int i = 0; i < colCount; i++) {
            System.out.print(model.getColumnName(i) + "\t");
        }
        System.out.println();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.print(model.getValueAt(i, j) + "\t");
            }
            System.out.println();
        }
    }
}