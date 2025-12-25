import java.util.LinkedList;

public class ConnectingPoint
{
	private String 		kind;
	private String 		name;
	private int 		x;
	private int 		y;
	private int 		id;
	private static int 	count = 0;
	private	static 		LinkedList<ConnectingPoint> points = new LinkedList<ConnectingPoint>();
	
	public ConnectingPoint(String kind, String name, int x, int y)
	{
		setKind(kind);
		setName(name);
		setX(x);
		setY(y);
		setID(getCount());
		incrementCount();
		addToList();
	}
	
	public ConnectingPoint(String name, int x, int y)
	{
		this("Default", name, x, y);
	}
	
	public static int getDistanceX(ConnectingPoint p1, ConnectingPoint p2)
	{ 
		return (Math.abs(p1.getX() - p2.getX()));
	}
	
	public static int getDistanceY(ConnectingPoint p1, ConnectingPoint p2)
	{ 
		return (Math.abs(p1.getY() - p2.getY()));
	}
	
	public static int getDistance(ConnectingPoint p1, ConnectingPoint p2)
	{
		return (int)(Math.sqrt(Math.pow(getDistanceX(p1, p2), 2) + Math.pow(getDistanceY(p1, p2), 2)));
	}
	
	public static String getDirection(ConnectingPoint from, ConnectingPoint to)
	{
		 int xDist = from.getX() - to.getX();
		 int yDist = from.getY() - to.getY();
		 if (Math.abs(xDist) >= Math.abs(yDist)) // more x variation than y
		 {
			 if (xDist >= 0) // from.x > to.x => to is west of from
				 return "West";
			 else			// to is to the east of from
				 return "East";
		 }
		 else // more y variation that x
		 {
			 if (yDist >= 0) // from.y > to.y => to south of from
				 return "South";
			 else			// to is to the north of from
				 return "North";
		 }
	}
	
	public String getKind()
	{
		return this.kind;
	}

	public String getName()
	{
		return this.name;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public int getID()
	{
		return id;
	}

	public static int getCount()
	{
		return count;
	}

	public void setKind(String kind)
	{
		this.kind = kind;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	private void setX(int x)
	{
		this.x = x;
	}

	private void setY(int y)
	{
		this.y = y;
	}

	private void setID(int id)
	{
		this.id = id;
	}

	private static void incrementCount()
	{
		ConnectingPoint.count++;
	}
	
	private void addToList()
	{
		ConnectingPoint.points.add(this);
	}
	
	public static LinkedList<ConnectingPoint> getAllPoints()
	{
		return ConnectingPoint.points;
	}

	@Override
	public String toString()
	{
		return String.format("{Kind = %12s,\tName = %23s,\tx = %4d,\ty = %4d,\tID = %2d}", this.getKind(), this.getName(), this.getX(), this.getY(), this.getID());
	}
}
