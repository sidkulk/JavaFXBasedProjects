package service.appFunctionalService;

import model.Password;

public interface FeatureServer {
	public boolean addNewPasswordEntry(Password password);
	
	public boolean removePasswordEntry(Password password);
	
	public boolean updateSelectedEntry(Password password);
}
