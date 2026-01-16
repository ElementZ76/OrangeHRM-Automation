package com.framework.utils;

import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.models.EmployeeData;
import com.framework.models.UserData;

import java.io.File;
import java.io.IOException;

public class JsonUtils {
	
	//for admin
	public static List<UserData> getUserData(String jsonFileName) throws StreamReadException, DatabindException, IOException {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + jsonFileName;
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(filePath), new TypeReference<List<UserData>>(){});
	}
	
	//for pim
	public static List<EmployeeData> getEmployeeData(String jsonfileName) throws StreamReadException, DatabindException, IOException {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + jsonfileName;
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.readValue(new File(filePath), new TypeReference<List<EmployeeData>>(){});
	}	
}
