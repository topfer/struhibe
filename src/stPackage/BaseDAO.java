package stPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * Abstract superclass for Data Access Objects. Contains code to create a JDBC
 * <code>Connection</code> object from a JNDI data source and resource clean-up
 * code.
  */
public class BaseDAO {
  /**
   * The name of the JNDI data source.
   */
  private static final String JNDI_DATASOURCE = "java:comp/env/jdbc/STTestDS";
  private static Logger logger = Logger.getLogger("sttest");

  /**
   * The JNDI data source.
   */
  private DataSource dataSource;
  
  /**
   * No argument constructor for creating a new <code>BaseDAO</code>. Looks up
   * the data source from JNDI.
   * 
   * @throws NamingException if the JNDI lookup of the data source failed.
   */
  public BaseDAO() throws NamingException {
    logger.debug(getClass().getName() + "::BaseDAO()");
    Context ctx = new InitialContext();
    this.dataSource = (DataSource) ctx.lookup(BaseDAO.JNDI_DATASOURCE);
  }

  /**
   * Utility method for closing JDBC resources.
   * 
   * @param rset A JDBC <code>ResultSet</code> object to close.
   * @param stmt A JDBC <code>Statement</code> object to close.
   * @param conn A JDBC <code>Connection</code> object to close. 
   * @throws SQLException if a resource could not be closed.
   */
  public void closeResources(ResultSet rset, Statement stmt, Connection conn) throws SQLException {
    logger.debug(getClass().getName() + "::closeResources()");
    if (rset != null) {
      rset.close();
    }

    if (stmt != null) {
      stmt.close();
    }

    if (conn != null) {
      conn.close();
    }  
  }

  /**
   * Returns a JDBC <code>Connection</code> object created from the data source.
   * 
   * @return a JDBC <code>Connection</code>.
   * @throws SQLException if the <code>Connection</code> could not be obtained
   * from the data source.
   */
  public Connection getConnection() throws SQLException {
    logger.debug(getClass().getName() + "::getConnection()");
    return this.dataSource.getConnection();
  }

  /**
   * Executes a specified SQL statement
   * 
   * @return number of affected rows.
   * @throws SQLException in case of any SQL related error
   */
    public int execUpdateStatement( String stmt ) throws SQLException {
    logger.debug(getClass().getName() + "::execUpdateStatement(\"" + stmt  + "\")");
    return this.dataSource.getConnection().createStatement().executeUpdate( stmt );
  }  

  /**
   * Executes a specified SQL statement
   * 
   * @return number of affected rows.
   * @throws SQLException in case of any SQL related error
   */
    public ResultSet execQueryStatement( String stmt ) throws SQLException {
    logger.debug(getClass().getName() + "::execQueryStatement(\"" + stmt  + "\")");
    return this.dataSource.getConnection().createStatement().executeQuery( stmt );
  }  

}
