package InMemoryDatabaseSystem.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import InMemoryDatabaseSystem.filtration_strategy.FilterStrategy;

public class Database {
	private String databaseId;
	private String databaseName;
	private Map<String, Table> tableMap;

	public Database(String databaseName) {
		this.databaseId = UUID.randomUUID().toString();
		this.databaseName = databaseName;
		this.tableMap = new HashMap<String, Table>();
	}

	public void createTable(String tableName, List<Column> columns) {
		if (tableMap.containsKey(tableName)) {
			System.out.println("TableName: " + tableName + " already exists!");
			return;
		}
		Table table = new Table(tableName, columns);
		tableMap.put(tableName, table);
	}

	public void dropTable(String tableName) {
		if (!tableMap.containsKey(tableName)) {
			System.out.println("TableName: " + tableName + " does not exist");
			return;
		}
		tableMap.remove(tableName);
		System.out.println("TableName: " + tableName + " dropped!");
	}

	public void truncate(String tableName) {
		Table table = tableMap.get(tableName);
		if (table == null) {
			System.out.println("TableName: " + tableName + " does not exist");
			return;
		}
		table.truncateRows();
	}

	public void insertTableRows(String tableName, Map<Column, Object> columnValues) throws IllegalAccessException {
		if (!tableMap.containsKey(tableName)) {
			System.out.println("TableName: " + tableName + " does not exist");
			return;
		}
		Table table = tableMap.get(tableName);
		table.insertRow(columnValues);
	}

	public void printTableAllRows(String tableName) {
		if (!tableMap.containsKey(tableName)) {
			System.out.println("TableName: " + tableName + " does not exist");
			return;
		}
		Table table = tableMap.get(tableName);
		table.printRows();
	}

	public void filterTableRecords(String tableName, Column column, Object filterValue, FilterStrategy strategy) {
		Table table = tableMap.get(tableName);
		if (table == null) {
			System.out.println("TableName: " + tableName + " does not exist");
			return;
		}
		table.filterRecords(column, filterValue, strategy);
	}

	public void deleteFromTable(String tableName, Column column, Object value) {
		if (!tableMap.containsKey(tableName)) {
			System.out.println("TableName: " + tableName + " does not exist");
			return;
		}
		Table table = tableMap.get(tableName);
		table.deleteRowsByColumnValue(column, value);
	}

	public String getDatabaseId() {
		return databaseId;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public Map<String, Table> getTableMap() {
		return tableMap;
	}

	public void getTables() {
		if (tableMap.size() == 0) {
			System.out.println("There is no table in the database");
			return;
		}

		System.out.println("The tables in the database are as follows");
		System.out.println("====================================");
		for (String tableName : tableMap.keySet()) {
			System.out.println(tableName);
		}
	}

}
