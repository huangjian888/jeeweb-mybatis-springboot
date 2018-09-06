package cn.jeeweb.modules.codegen.codegenerator.data;

import cn.jeeweb.core.utils.BeanUtils;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.codegen.codegenerator.utils.type.DbTypeConvert;
import cn.jeeweb.modules.codegen.codegenerator.xml.definition.Type;
import cn.jeeweb.modules.codegen.entity.Column;

import java.io.Serializable;

public class AttributeInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name = "";
	private String dbName = "";
	private String type = "";
	private String importType = "";
	private String precision = "";
	private String length = "";
	private String remarks = "";
	private Boolean parmaryKey = false;
	private Boolean importedKey = false;
	private Boolean nullable = false;
	private String columnDef = "";
	private String decimalDigits = "";
	private Boolean isBaseType = Boolean.FALSE;

	private String[] baseTypes = { "String", "Double", "Text", "Date", "Blob", "Short", "Integer", "Boolean" };

	// 精度为12位，小数点位数为2位。
	public AttributeInfo() {

	}

	public AttributeInfo(Column column) {
		this.name = column.getJavaField();
		this.dbName = column.getColumnName();
		this.type = column.getJavaType();
		if (this.type.contains("|")) {
			String[] types = this.type.split("\\|");
			if (types.length == 2) {
				this.importType = this.type.replace("|", ".");
				this.type = types[1];
			}
		} else {
			Type type = DbTypeConvert.getTypeConvert(DbTypeConvert.JAVA_TO_CLASS).getType(this.type);
			if (type != null) {
				this.importType = type.getFullType();
			}
		}
		if (!StringUtils.isEmpty(column.getTypeName()) && column.getTypeName().equals(Double.class.getSimpleName())) {
			this.precision = column.getColumnSize();
		} else {
			this.length = column.getColumnSize();
		}
		this.remarks = column.getRemarks();
		this.nullable = column.getNullable();
		this.parmaryKey = column.getParmaryKey();

		// 这里目前写死，以后升级再完善
		this.importedKey = column.getImportedKey();
		try {
			if (!StringUtils.isEmpty(this.importType)) {
				Class<?> clazz = Class.forName(this.importType);
				if (!BeanUtils.isBaseDataType(clazz)) {
					this.importedKey = Boolean.TRUE;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.columnDef = column.getColumnDef();
		this.decimalDigits = column.getDecimalDigits();

		for (String baseType : baseTypes) {
			if (baseType.equals(this.type)) {
				this.isBaseType = Boolean.TRUE;
				break;
			}
		}
	}

	public AttributeInfo(DbColumnInfo columnInfo) {
		this.name = columnInfo.getColumnName();
		this.dbName = columnInfo.getColumnName();
		this.type = DbTypeConvert.getTypeConvert(DbTypeConvert.TYPE_DB_TO_JAVA).getType(columnInfo.getTypeName())
				.getJavaType();
		this.importType = DbTypeConvert.getTypeConvert(DbTypeConvert.TYPE_DB_TO_JAVA).getType(columnInfo.getTypeName())
				.getFullType();
		if (columnInfo.getTypeName().equals(Double.class.getSimpleName())) {
			this.precision = columnInfo.getColumnSize();
		} else {
			this.length = columnInfo.getColumnSize();
		}
		this.remarks = columnInfo.getRemarks();
		this.nullable = columnInfo.isNullable();
		this.parmaryKey = columnInfo.isParmaryKey();
		this.importedKey = columnInfo.isImportedKey();
		this.columnDef = columnInfo.getColumnDef();
		this.decimalDigits = columnInfo.getDecimalDigits();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImportType() {
		return importType;
	}

	public void setImportType(String importType) {
		this.importType = importType;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean getParmaryKey() {
		return parmaryKey;
	}

	public void setParmaryKey(Boolean parmaryKey) {
		this.parmaryKey = parmaryKey;
	}

	public Boolean getImportedKey() {
		return importedKey;
	}

	public void setImportedKey(Boolean importedKey) {
		this.importedKey = importedKey;
	}

	public Boolean getNullable() {
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

	public Boolean getIsBaseType() {
		return isBaseType;
	}

}
