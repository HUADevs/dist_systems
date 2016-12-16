package com.huaDevelopers.dao.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.External.ExternalCitizen;
import com.huaDevelopers.data.Entities.External.ExternalHistory;
import com.huaDevelopers.data.Entities.External.ExternalVehicle;

public interface ExternalDAO {

	public ExternalCitizen getCitizen(String id);

	public ExternalVehicle getVehicle(String lp);

	public List<ExternalHistory> getHistoryList(String id);
}
