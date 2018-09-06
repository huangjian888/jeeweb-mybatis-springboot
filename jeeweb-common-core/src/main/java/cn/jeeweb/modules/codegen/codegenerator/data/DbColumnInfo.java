package cn.jeeweb.modules.codegen.codegenerator.data;

import java.io.Serializable;

public class DbColumnInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	// 获得字段名称
	private String columnName = "";
	// 获得字段类型名称
	private String typeName = "";
	// 获得字段大小
	private String columnSize = "";
	// 获得字段备注
	private String remarks = "";
	// 是否为主键
	private Boolean parmaryKey = false;
	// 是否为外键
	private Boolean importedKey = false;
	// 是否允许为空
	private Boolean nullable = false;
	// 默认值
	private String columnDef = "";
	// 小数部分的位数
	private String decimalDigits = "";

	public DbColumnInfo() {

	}

	public DbColumnInfo(String columnName, String typeName, String columnSize, String remarks, boolean nullable,
			boolean parmaryKey, boolean importedKey, String columnDef, String decimalDigits) {
		this.columnName = columnName;
		this.typeName = typeName;
		this.columnSize = columnSize;
		this.remarks = remarks;
		this.nullable = nullable;
		this.parmaryKey = parmaryKey;
		this.importedKey = importedKey;
		this.columnDef = columnDef;
		this.decimalDigits = decimalDigits;

	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(String columnSize) {
		this.columnSize = columnSize;
	}

	public String getRemarks() {
		if ("".equals(remarks)) {
			remarks = columnName;
		}
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean isParmaryKey() {
		return parmaryKey;
	}

	public void setParmaryKey(Boolean parmaryKey) {
		this.parmaryKey = parmaryKey;
	}

	public Boolean isImportedKey() {
		return importedKey;
	}

	public void setImportedKey(Boolean importedKey) {
		this.importedKey = importedKey;
	}

	public Boolean isNullable() {
		return nullable;
	}

	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
	}

	public String getColumnDef() {
		return columnDef;
	}

	public void setColumnDef(String columnDef) {
		this.columnDef = columnDef;
	}

	public String getDecimalDigits() {
		return decimalDigits;
	}

	public void setDecimalDigits(String decimalDigits) {
		this.decimalDigits = decimalDigits;
	}

}
