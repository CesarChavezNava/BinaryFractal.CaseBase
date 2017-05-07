package com.binaryfractal.casebase;

import com.binaryfractal.casebase.infra.annotations.Column;
import com.binaryfractal.casebase.infra.annotations.Table;
import com.binaryfractal.casebase.infra.beans.BaseDataObject;

@Table(name = "TBL_EMPRESA")
public class Empresa extends BaseDataObject{
	
	@Column(name = "Id_Empresa", isRequired = true, isKey = true)
	private String idEmpresa;
	
	public void setIdEmpresa(String idEmpresa){
		this.idEmpresa = idEmpresa;
	}
	
	public String getIdEmpresa(){
		return this.idEmpresa;
	}
}
