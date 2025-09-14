package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

import CarRentalSystem.entities.Store;

public class RentalSystem {

	private List<Store> stores = new ArrayList<Store>();

	public void addStore(Store store) {
		this.stores.add(store);
	}

	public List<Store> getStoresByCity(String city) {
		List<Store> as = new ArrayList<>();
		for (Store s : stores) {
			if (s.getLocation().getCity().equalsIgnoreCase(city))
				as.add(s);
		}
		return as;
	}
}
