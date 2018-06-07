package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.gui.search.listeners.CVObject;

/**
 * Clasa care permite conectarea cu Baze de date de tip SQLite
 * 
 * <ol>
 * Contine functiile:
 * <li>{@link #checkConnection()}</li>
 * <li>{@link #connect()}</li>
 * <li>{@link #openConnection()}</li>
 * <li>{@link #createDatabase()}</li>
 * <li>{@link #setContent(String, String)}</li>
 * <li>{@link #contentList(String)}</li>
 * <li>{@link #contentByDate(String, String, String)}</li>
 * <li>{@link #numeClasa()}</li>
 * </ol>
 * 
 * @author Kocsis Lorand
 *
 */

public class SQLiteConnection implements Databases {

	Connection c = null;
	Statement stmt = null;

	/**
	 * Functie care se conecteaza la baza de date sqlite locala
	 */

	public void connect() {
		try {
			c = DriverManager.getConnection("jdbc:sqlite:" + System.getenv("APPDATA") + "\\CV-Reader\\cvdatabase.db");
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * 
	 */
	public void createDatabase() {
		connect();
		try {
			Class.forName("org.sqlite.JDBC");

			String sql = "CREATE TABLE IF NOT EXISTS `CvData` (\r\n"
					+ "	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" + "	`content`	TEXT NOT NULL,\r\n"
					+ "	`Filename`	TEXT NOT NULL,\r\n" + "	`Date`	DATETIME DEFAULT CURRENT_TIMESTAMP,\r\n" + "image TEXT NOT NULL)";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}

	@Override
	/**
	 * 
	 */
	public void setContent(String content, String name, String image) {
		connect();
		try {

			String sql = "INSERT INTO CvData (content,filename,image)" + " VALUES('" + content + "','" + name + "','" + image + "')";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	/**
	 * 
	 */
	public TreeMap<String, CVObject> contentList(String regex) {
		connect();
		try {
			ResultSet result = stmt.executeQuery("SELECT * FROM CvData;");

			TreeMap<String, CVObject> returndata = new TreeMap<String, CVObject>();

			Pattern r = Pattern.compile(regex);
			while (result.next()) {
				String content = result.getString("content");
				String name = result.getString("fileName");

				Matcher m = r.matcher(content);
				if (m.find()) {
					returndata.put(name, new CVObject(result.getString("id"), result.getString("Filename"),
							result.getString("content"), result.getString("date"),result.getString("image")));
				}

			}
			stmt.close();
			return returndata;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public TreeMap<String, CVObject> getAllContent() {
		connect();
		try {
			ResultSet result = stmt.executeQuery("SELECT * FROM CvData;");

			TreeMap<String, CVObject> returndata = new TreeMap<String, CVObject>();

			while (result.next()) {
				
				String name = result.getString("fileName");
				returndata.put(name, new CVObject(result.getString("id"), result.getString("Filename"),
						result.getString("content"), result.getString("date"),result.getString("image")));

			}
			stmt.close();
			return returndata;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	/**
	 * 
	 */
	public TreeMap<String, CVObject> contentByDate(String regex, String dateprev, String datenexts) {
		connect();
		try {
			ResultSet result = stmt.executeQuery("SELECT * FROM CvData WHERE DATE BETWEEN '" + dateprev
					+ " 00:00:01' AND '" + datenexts + " 23:59:59'");

			TreeMap<String, CVObject> returndata = new TreeMap<String, CVObject>();

			Pattern r = Pattern.compile(regex);
			while (result.next()) {
				String content = result.getString("content");
				String name = result.getString("fileName");

				Matcher m = r.matcher(content);
				if (m.find()) {
					returndata.put(name, new CVObject(result.getString("id"), result.getString("Filename"),
							result.getString("content"), result.getString("date"),result.getString("image")));
				}

			}
			stmt.close();
			return returndata;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	/**
	 * 
	 */
	public Boolean checkConnection() {
		try {
			c = DriverManager.getConnection("jdbc:sqlite:" + System.getenv("APPDATA") + "\\CV-Reader\\cvdatabase.db");
			stmt = c.createStatement();
		} catch (SQLException e) {
			if (e.getMessage() != null) {
				return false;
			}
		}
		return true;
	}

	@Override
	/**
	 * 
	 */
	public String numeClasa() {
		// TODO Auto-generated method stub
		return "Sqlite";
	}

}
