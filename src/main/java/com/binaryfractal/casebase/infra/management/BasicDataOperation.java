package com.binaryfractal.casebase.infra.management;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.binaryfractal.casebase.infra.beans.BaseDataObject;
import com.binaryfractal.casebase.infra.interfaces.BaseDataOperation;
import com.binaryfractal.casebase.infra.tools.RetrieveDataField;

public class BasicDataOperation<TBaseDataObject> implements
		BaseDataOperation<TBaseDataObject> {

	public void create(BaseDataObject object) {
		Class typeClass = object.getClass();
		String tableName = RetrieveDataField.getTableName(typeClass, object);

		Field[] fields = typeClass.getDeclaredFields();
		List<String> columnsName = new ArrayList<String>();
		columnsName = RetrieveDataField.getColumnsName(fields, object);
		
		InternalDataOperation internal = new InternalDataOperation(tableName);
		internal.internalCreate(columnsName,object);
	}

	public void update(BaseDataObject object) {
		// TODO Auto-generated method stub

	}

	public void delete(BaseDataObject object) {
		// TODO Auto-generated method stub

	}

	public TBaseDataObject findOne(String condition, Collection<Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<TBaseDataObject> find(String condition,
			Collection<Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<TBaseDataObject> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
