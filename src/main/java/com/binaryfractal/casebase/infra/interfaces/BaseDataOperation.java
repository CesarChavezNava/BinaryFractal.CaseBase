package com.binaryfractal.casebase.infra.interfaces;

import java.util.Collection;

import com.binaryfractal.casebase.infra.beans.BaseDataObject;

public interface BaseDataOperation<TBaseDataObject> {
	void create(BaseDataObject object);

	void update(BaseDataObject object);

	void delete(BaseDataObject object);

	TBaseDataObject findOne(String condition, Collection<Object> params);

	Collection<TBaseDataObject> find(String condition, Collection<Object> params);

	Collection<TBaseDataObject> find();
}
