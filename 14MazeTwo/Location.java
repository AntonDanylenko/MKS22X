public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
	private int distGone, dist;

    public Location(int _x, int _y, Location prev, int distance, int distanceGone){
		x=_x;
		y=_y;
		previous=prev;
		dist = distance;
		distGone = distanceGone;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public Location getPrevious(){
	return previous;
    }

	public int getDistGone(){
	return distGone;
    }

    public int getDist(){
    return dist;
    }

	public boolean equals(Location other){
	return other.getX() == x && other.getY() == y;
	}

	public int compareTo(Location other){
	return dist + distGone - (other.getDist() + other.getDistGone());
	}
}