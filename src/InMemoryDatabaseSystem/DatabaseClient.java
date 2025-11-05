package InMemoryDatabaseSystem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import InMemoryDatabaseSystem.entities.Column;
import InMemoryDatabaseSystem.entities.Database;
import InMemoryDatabaseSystem.enums.Type;
import InMemoryDatabaseSystem.filtration_strategy.EqualsFilter;

public class DatabaseClient {

	public static void main(String[] args) throws IllegalAccessException {
		// TODO Auto-generated method stub
		Database db = new Database("EmployeeDB");
		System.out.println("Database 'EmployeeDB' created!\n");

		Column idCol = new Column("id", Type.INT);
		Column nameCol = new Column("name", Type.STRING);
		Column deptCol = new Column("department", Type.STRING);

		List<Column> columns = Arrays.asList(idCol, nameCol, deptCol);

		db.createTable("Employee", columns);

		Map<Column, Object> row1 = new HashMap<>();
		row1.put(idCol, 101);
		row1.put(nameCol, "Alice");
		row1.put(deptCol, "HR");
		db.insertTableRows("Employee", row1);

		Map<Column, Object> row2 = new HashMap<>();
		row2.put(idCol, 102);
		row2.put(nameCol, "Bob");
		row2.put(deptCol, "Engineering");
		db.insertTableRows("Employee", row2);

		Map<Column, Object> row3 = new HashMap<>();
		row3.put(idCol, 103);
		row3.put(nameCol, "Charlie");
		row3.put(deptCol, "Engineering");
		db.insertTableRows("Employee", row3);

		db.printTableAllRows("Employee");

		System.out.println("\n--- Filter: Department = Engineering ---");
		db.filterTableRecords("Employee", deptCol, "Engineering", new EqualsFilter());
		
		db.deleteFromTable("Employee", deptCol, "HR");

		db.printTableAllRows("Employee");
		
		db.getTables();
		
		db.dropTable("Employee");
		
		db.getTables();
		
	}

}
