package InMemoryDatabaseSystem.filtration_strategy;

public class EqualsFilter implements FilterStrategy {

	@Override
	public boolean matches(Object columnValue, Object filterValue) {
		// TODO Auto-generated method stub
		return columnValue != null && columnValue.equals(filterValue);
	}

}
