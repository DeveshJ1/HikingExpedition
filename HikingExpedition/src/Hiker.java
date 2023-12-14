
import java.util.ArrayList;
import java.util.List;

public class Hiker {
	private List<String> supplies;
	public Hiker() 
	{
		this.supplies=new ArrayList<>();
	}
	public List<String> getSupplies()
	{
		return this.supplies;
	}
	public void consumeSupplies(RestStop restStop) 
	{
		supplies.addAll(restStop.getSupplies());
		//supplies.removeAll(restStop.getObstacle());
	}
	public void undoConsumption(RestStop restStop) {
		for(String supply: restStop.getSupplies())
			supplies.remove(supply);
	}
	 public boolean canPassObstacles(RestStop restStop) {
	        List<String> obstacles = restStop.getObstacle();
	        if(!supplies.contains("food"))
	        {
	        	return false;
	        }
	        for (String obstacle : obstacles) {
	            if ((obstacle.equals("fallen tree") && !supplies.contains("axe"))
	                    || (obstacle.equals("river") && !supplies.contains("raft"))) {
	                return false;
	            }
	        }

	        return true;
	    }
	 public void useSupplies(RestStop restStop) 
	 {
		 List<String> obstacles=restStop.getObstacle();
		 supplies.remove("food");
		for(String obstacle: obstacles) 
		 {
			 if(obstacle.equals("fallen tree"))
			 {
				 supplies.remove("axe");
			 }
			 else if(obstacle.equals("river")) 
			 {
				 supplies.remove("raft");
			 }
		 }
	 }
	 public void undoUse(RestStop restStop) 
	 {
		 List<String> obstacles=restStop.getObstacle();
		 supplies.add("food");
		for(String obstacle: obstacles) 
		 {
			 if(obstacle.equals("fallen tree"))
			 {
				 supplies.add("axe");
			 }
			 else if(obstacle.equals("river")) 
			 {
				 supplies.add("raft");
			 }
		 }
	 }
}
