package InMemoryDatabaseSystem.entities;

import InMemoryDatabaseSystem.enums.Type;

public class Column {
	private String columnName;
	private Type type;

	public Column(String columnName, Type type) {
		this.columnName = columnName;
		this.type = type;
	}

	public String getColumnName() {
		return columnName;
	}

	public Type getType() {
		return type;
	}

}
