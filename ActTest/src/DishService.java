import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DishService {
	
	private Map<Integer, String> morningDishes;
	private Map<Integer, String> nightDishes;
	
	public DishService() {
		morningDishes = new HashMap<>();
		morningDishes.put(1, "eggs");
		morningDishes.put(2, "toast");
		morningDishes.put(3, "coffee");
		morningDishes.put(4, "not applicable");
		
		nightDishes = new HashMap<>();
		nightDishes.put(1, "steak");
		nightDishes.put(2, "potato");
		nightDishes.put(3, "wine");
		nightDishes.put(4, "cake");
	}

	public String outputBuilder(String input) {
		List<String> ioList = Arrays.asList(input.split("\\s*,\\s*"));
		String result = null;

		if (!ioList.isEmpty()) {
			switch (ioList.get(0).toUpperCase()) {
			case "MORNING":
				ioList = makeOutput(morningDishes, ioList);
				break;
			case "NIGHT":
				ioList = makeOutput(nightDishes, ioList);
				break;
			default:
				ioList = null;
			}
			
			if (ioList != null && !ioList.isEmpty()) {
				result = String.join(", ", ioList);
			} else {
				result = "Invalid Input";
			}
		}

		return result;
	}
	
	private List<String> makeOutput(Map<Integer, String> timeOfDayDishes, List<String> inputs) {
		List<String> dishes = new ArrayList<>();
		List<String> dishesResult = null;
		
		String dish;
		
		for (int i = 1; i < inputs.size(); i++) {
			try {
				dish = timeOfDayDishes.get(Integer.parseInt(inputs.get(i).trim()));
				
				if (dish == null || (!dish.equals("coffee") && !dish.equals("potato") && dishes.contains(dish))) {
					dish = "error";
				}
			} catch (NumberFormatException ex) {
				dish = "error";
			}
			
			dishes.add(dish);
			
			if (dish == "error") {
				break;
			}
		}
		
		if (!dishes.isEmpty()) {
			dishesResult = new ArrayList<>();
			
			for (String dishResult: dishes) {
				if (!dishesResult.contains(dishResult)) {
					dishesResult.add(dishResult);
				}
			}
			
			dish = null;
			
			if (dishesResult.contains("coffee")) {
				dish = "coffee";
			} else if (dishesResult.contains("potato")) {
				dish = "potato";
			}
			
			if (dish != null) {
				int dishesTotal = Collections.frequency(dishes, dish);
				
				if (dishesTotal > 0) {
					dishesResult.set(dishesResult.indexOf(dish), String.format("%s(x%d)", dish, dishesTotal));
				}
			}
		}
		
		return dishesResult;
	}

}
