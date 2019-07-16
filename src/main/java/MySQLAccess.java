import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase(Product product) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart","root","root");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("INSERT INTO `shopping_cart`.`product` " +
                            "(`productId`, `productDescription`, `productName`, `categoryId`, `productImage`, `productPrice`) " +
                            "VALUES (?, ?, ?, ?, ?,?)");
            // Parameters start with 1
            preparedStatement.setInt(1,product.getProductId());
//            preparedStatement.setInt(1,5);
            preparedStatement.setString(2,product.getProductDescription());
            preparedStatement.setString(3,product.getProductName());
            preparedStatement.setInt(4, Main.categoryId);
            preparedStatement.setString(5,product.getImages());
            preparedStatement.setDouble(6,product.getProductPrice());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
