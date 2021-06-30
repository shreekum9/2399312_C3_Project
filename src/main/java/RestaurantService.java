import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
    	for(Restaurant restaurant : restaurants) {
    		if(restaurantName.equalsIgnoreCase(restaurant.getName())) {
    			return restaurant;
    		}
    	}
        throw new restaurantNotFoundException(restaurantName);
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
    
    public double getTotalOrderValue(List<String> itemNames) {
    	double totalOrderValue = 0;
		for(Restaurant restaurant : restaurants) {
			for(Item item : restaurant.getMenu()) {
				if(itemNames.contains(item.getName())) {
					totalOrderValue = totalOrderValue + item.getPrice();
				}
			}
		}
    	return totalOrderValue;
    }
	
}
