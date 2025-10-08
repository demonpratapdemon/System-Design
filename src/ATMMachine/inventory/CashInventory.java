package ATMMachine.inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashInventory {
	private Map<Integer, Integer> cashMap = new HashMap<>();

	public void addCash(int denomination, int count) {
		cashMap.put(denomination, cashMap.getOrDefault(denomination, 0) + count);
	}

	public boolean hasSufficientCash(int amount) {
		int total = cashMap.entrySet().stream().mapToInt(e -> e.getKey() * e.getValue()).sum();
		return total >= amount;
	}

	public Map<Integer, Integer> dispenseCash(int amount) {
		List<Integer> denominations = new ArrayList<Integer>(cashMap.keySet());
		denominations.sort(Collections.reverseOrder());

		Map<Integer, Integer> dispensed = new HashMap<>();
		for (int denom : denominations) {
			int needed = Math.min(amount / denom, cashMap.get(denom));
			if (needed > 0) {
				dispensed.put(denom, needed);
				amount -= needed * denom;
			}
		}
		if (amount != 0)
			return Collections.emptyMap();

		for (Map.Entry<Integer, Integer> entry : dispensed.entrySet()) {
			cashMap.put(entry.getKey(), cashMap.get(entry.getKey()) - entry.getValue());
		}
		return dispensed;
	}
}
