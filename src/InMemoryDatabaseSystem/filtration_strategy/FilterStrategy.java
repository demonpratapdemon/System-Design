package InMemoryDatabaseSystem.filtration_strategy;

public interface FilterStrategy {
	boolean matches(Object columnValue, Object filterValue);
}
