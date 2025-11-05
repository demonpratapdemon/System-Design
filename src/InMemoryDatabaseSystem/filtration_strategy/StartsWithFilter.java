package InMemoryDatabaseSystem.filtration_strategy;

public class StartsWithFilter implements FilterStrategy {

	@Override
	public boolean matches(Object columnValue, Object filterValue) {
		// TODO Auto-generated method stub
		if (columnValue instanceof String && filterValue instanceof String) {
			return ((String) columnValue).startsWith((String) filterValue);
		}
		return false;
	}

}
