package service.dbInit;

public interface DatabaseServer {
	public boolean connectToDatabase();
	
	public boolean createAllTables();
	
	public boolean closeAllConnections();
}
