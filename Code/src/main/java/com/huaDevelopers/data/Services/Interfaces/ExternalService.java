package com.huaDevelopers.data.Services.Interfaces;

import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Entities.External.ExternalVehicle;

public interface ExternalService {
	
	public Vehicle searchNationalDB(String lp);
	
	public ExternalVehicle getVehicle(String lp);

}
