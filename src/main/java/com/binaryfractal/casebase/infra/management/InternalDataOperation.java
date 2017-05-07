package com.binaryfractal.casebase.infra.management;

import java.util.List;

import com.binaryfractal.casebase.infra.beans.BaseDataObject;

public class InternalDataOperation {
	
	private String tableName;
	
	public InternalDataOperation(String tableName){
		this.tableName = tableName;
	}
	
	public void internalCreate(List<String> columnsName, BaseDataObject object){
	 // proceso interno de creacion de objecto	
	}
}
