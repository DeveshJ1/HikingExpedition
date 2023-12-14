
import java.util.List;


public class RestStop implements Comparable<RestStop> {
	private String label;
	private List<String> supplies;
	private List<String> obstacles;
	public RestStop(String label, List<String> supplies, List<String> obstacles) 
	{
		this.label=label;
		this.supplies=supplies;
		this.obstacles=obstacles;
	}
	public String getLabel() 
	{
		return label;
	}
	public List<String> getSupplies()
	{
		return supplies;
	}
	public List<String> getObstacle()
	{
		return obstacles;
	}
	@Override
	public int compareTo(RestStop other) 
	{
		return this.label.compareTo(other.label);
	}
}
