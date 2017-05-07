package com.binaryfractal.casebase.infra.tools;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.binaryfractal.casebase.infra.annotations.Column;
import com.binaryfractal.casebase.infra.annotations.Table;
import com.binaryfractal.casebase.infra.beans.BaseDataObject;

public class RetrieveDataField {

	public static List<String> getColumnsName(Field[] fields,
			BaseDataObject object) {
		List<String> columnsName = new ArrayList<String>();

		for (Field field : fields) {
			String columnName = getColumnName(field, object);
			columnsName.add(columnName);
		}
		return columnsName;
	}

	public static String getTableName(Class typeClass, BaseDataObject object) {
		Class typeInterface = Table.class;

		if (typeClass.isAnnotationPresent(typeInterface)) {
			// La clase no cuenta con la anotación de la tabla
		}

		Annotation annotation = typeClass.getAnnotation(typeInterface);
		Class<? extends Annotation> typeAnnotation = annotation
				.annotationType();

		String tableName = "";

		try {
			Field fieldAnnotation = typeAnnotation.getDeclaredField("name");
			Object objNameTable = fieldAnnotation.get(object);
			tableName = objNameTable.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tableName;
	}

	public static String getColumnName(Field field, BaseDataObject object) {
		Class typeInterface = Column.class;

		if (field.isAnnotationPresent(typeInterface)) {
			// El campo no tiene la notacion con el nombre de la columna
		}

		Annotation annotation = field.getAnnotation(typeInterface);
		Class<? extends Annotation> typeAnnotation = annotation
				.annotationType();

		String columnName = "";

		try {
			Field fieldAnnotation = typeAnnotation.getDeclaredField("name");
			Object objColumnName = fieldAnnotation.get(object);
			columnName = objColumnName.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return columnName;
	}

	public static boolean getColumnIsRequired(Field field, BaseDataObject object) {
		Class typeInterface = Column.class;

		Annotation annotation = field.getAnnotation(typeInterface);
		Class<? extends Annotation> typeAnnotation = annotation
				.annotationType();

		boolean isRequired = false;

		try {
			Field fieldAnnotation = typeAnnotation
					.getDeclaredField("isRequired");

			if (null == fieldAnnotation) {
				return isRequired;
			}
			Object objIsRequired = fieldAnnotation.get(object);
			isRequired = (boolean) objIsRequired;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isRequired;
	}
}
