
public class Platform {

	private Location location= new Location();
	private int width = 0;
	private int height = 0;
	
	public Platform(){
		
	}
	public Platform (Location location, int width, int height){
		this.setLocation(location);
		this.setWidth(width);
		this.setHeight(height);
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
}
