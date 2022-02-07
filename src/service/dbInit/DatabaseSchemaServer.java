package service.dbInit;

public interface DatabaseSchemaServer {
	public static final String DATABASE_NAME = "blurtable";

	public static final String USER_TAB_NAME = "usertable";

	public static final String PASSWORD_TAB_NAME = "passowrdtable";

	public static final String CREATE_USER_TAB_QUERY = "CREATE TABLE IF NOT EXISTS " + USER_TAB_NAME + "("
			+ "u_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "username TEXT NOT NULL UNIQUE, "
			+ "email TEXT NOT NULL UNIQUE, " + " passwordhash TEXT NOT NULL UNIQUE, " + "nickname TEXT NOT NULL, " + "schoolname TEXT NOT NULL" + ")";

	public static final String CREATE_PASSWORD_TAB_QUERY = "CREATE TABLE IF NOT EXISTS " + PASSWORD_TAB_NAME + "("
			+ "p_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "passwordtitle TEXT NOT NULL, "
			+ "passwordvalue TEXT NOT NULL, " + "u_id INTEGER NOT NULL, FOREIGN KEY(u_id) REFERENCES " + USER_TAB_NAME
			+ " ON DELETE CASCADE ON UPDATE CASCADE)";
}
