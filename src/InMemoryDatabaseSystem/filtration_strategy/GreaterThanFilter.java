package InMemoryDatabaseSystem.filtration_strategy;

public class GreaterThanFilter implements FilterStrategy {

	@Override
	public boolean matches(Object columnValue, Object filterValue) {
		// TODO Auto-generated method stub
		if (columnValue instanceof Number && filterValue instanceof Number) {
			return ((Number) columnValue).doubleValue() > ((Number) filterValue).doubleValue();
		}
		return false;
	}

}
