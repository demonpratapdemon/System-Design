package InMemoryDatabaseSystem.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import InMemoryDatabaseSystem.filtration_strategy.FilterStrategy;

public class Table {
	private Integer autoIncrementId;
	protected String tableId;
	private String tableName;
	private List<Row> rows;
	private Map<String, Column> columnMap;

	public Table(String tableName, List<Column> columns) {
		this.tableId = UUID.randomUUID().toString();
		this.autoIncrementId = 1;
		this.tableName = tableName;
		this.columnMap = new HashMap<String, Column>();
		this.rows = new ArrayList<Row>();

		for (Column col : columns) {
			this.columnMap.put(col.getColumnName(), col);
		}
	}

	public String getTableName() {
		return tableName;
	}

	protected synchronized Integer getAutoIncrementId() {
		return autoIncrementId++;
	}

	public void truncateRows() {
		rows.clear();
	}

	public void insertRow(Map<Column, Object> columnValues) throws IllegalAccessException {
		for (Column col : columnValues.keySet()) {
			if (!columnMap.containsKey(col.getColumnName())) {
				throw new IllegalAccessException(
						"TableName: " + tableName + " does not contain column: " + col.getColumnName());
			}
		}

		Integer rowId = getAutoIncrementId();
		Map<Column, Object> columnData = new HashMap<>(columnValues);
		Row row = new Row(rowId, columnData);
		rows.add(row);
	}

	public void printRows() {
		System.out.println("Printing all the rows for the table : " + tableName);
		System.out.println("===========================================================");
		printRecord(rows);
	}

	public void getRecordsByColumnValue(Column column, Object value) {
		List<Row> matchingRows = new ArrayList<Row>();
		for (Row row : rows) {
			Object obj = row.getColumnData().get(column);
			if (obj != null && obj.equals(value)) {
				matchingRows.add(row);
			}
		}
		System.out.println("Printing matching rows for Table: " + tableName);
		System.out.println("===========================================================");
		printRecord(matchingRows);
	}

	public void filterRecords(Column column, Object filterValue, FilterStrategy strategy) {
		List<Row> matchingRows = new ArrayList<>();

		for (Row row : rows) {
			Object colVal = row.getColumnData().get(column);
			if (strategy.matches(colVal, filterValue)) {
				matchingRows.add(row);
			}
		}

		System.out.println("Filtered rows for Table: " + tableName);
		System.out.println("===========================================================");
		printRecord(matchingRows);
	}

	public void deleteRowsByColumnValue(Column column, Object value) {
		Iterator<Row> itr = rows.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			if (row.getColumnData().containsKey(column) && row.getColumnData().get(column).equals(value)) {
				itr.remove();
			}
		}
	}

	private void printRecord(List<Row> rows) {
		// TODO Auto-generated method stub
		System.out.print("\t");
		for (String columnName : columnMap.keySet()) {
			System.out.print("\t" + columnName + "\t");
		}
		for (Row row : rows) {
			System.out.print("\n\t" + row.getRowId() + ".");
			for (Column col : columnMap.values()) {
				Object val = row.getColumnData().get(col);
				System.out.print("\t" + (val != null ? val : "NULL") + "\t");
			}
		}
		System.out.print("\n");
	}
}
