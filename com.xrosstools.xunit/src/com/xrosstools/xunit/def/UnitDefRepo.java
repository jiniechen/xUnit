package com.xrosstools.xunit.def;

import java.util.HashMap;
import java.util.Map;

import com.xrosstools.xunit.Unit;

public class UnitDefRepo {
	private Map<String, String> applicationProperties;
	private Map<String, UnitDef> defRepo = new HashMap<String, UnitDef>();
	
	public UnitDefRepo(Map<String, String> applicationProperties) {
		this.applicationProperties = applicationProperties;
	}
	
	public Map<String, String> getApplicationProperties() {
		return applicationProperties;
	}
	
	public void put(String key, UnitDef unitDef){
		defRepo.put(key, unitDef);
	}
	
	public UnitDef getDef(String id){
		return defRepo.get(id);
	}
	
	public Unit getUnit(String id) throws Exception{
		if(!defRepo.containsKey(id))
			throw new RuntimeException("Can not found unit \"" + id + "\"");
		return defRepo.get(id).getInstance();
	}
}
