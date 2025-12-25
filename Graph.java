import java.util.LinkedList;

public class Graph
{
	public	int 							number_of_points = 0;
	public	int 							number_of_edges = 0;
	public	LinkedList<LinkedList<Node>> 	edges;
	public	LinkedList<ConnectingPoint> 	points;
	
	public void buildGraph() // adds all the points and the edges
	{
		ConnectingPoint p00 = new ConnectingPoint("Gate", "LAU Lower", 70, 0);
		ConnectingPoint p01 = new ConnectingPoint("Intersection", "Intersection 1", 350, 0);
		ConnectingPoint p02 = new ConnectingPoint("Intersection", "Intersection 2", 550, 0);
		ConnectingPoint p03 = new ConnectingPoint("Intersection", "Intersection 3", 1000, 25);
		ConnectingPoint p04 = new ConnectingPoint("Building", "Barbar", 550, 60);
		ConnectingPoint p05 = new ConnectingPoint("Building", "BHive Cafe", 70, 150);
		ConnectingPoint p06 = new ConnectingPoint("Building","Crepaway", 70, 250);
		ConnectingPoint p07 = new ConnectingPoint("Intersection", "Intersection 4", 350, 200);
		ConnectingPoint p08 = new ConnectingPoint("Buliding", "Starbucks", 575, 175);
		ConnectingPoint p09 = new ConnectingPoint("Building", "Bank of Beirut", 850, 175);
		ConnectingPoint p10 = new ConnectingPoint("Intersection", "Hamra Intersection", 950, 175);
		ConnectingPoint p11 = new ConnectingPoint("Intersection", "Intersection 7", 1000, 235);
		ConnectingPoint p12 = new ConnectingPoint("Intersection", "Intersection 5", 70, 425);
		ConnectingPoint p13 = new ConnectingPoint("Intersection", "Intersection 6", 350, 435);
		ConnectingPoint p14 = new ConnectingPoint("Building", "Spinneys", 625, 350);
		ConnectingPoint p15 = new ConnectingPoint("Intersection", "AUBMC Corner", 650, 500);
		ConnectingPoint p16 = new ConnectingPoint("Block", "AUBMC", 750, 400);
		ConnectingPoint p17 = new ConnectingPoint("Building", "McDonald's Bliss", 0, 510);
		ConnectingPoint p18 = new ConnectingPoint("Gate", "AUB Bliss Gate", 70, 530);
		ConnectingPoint p19 = new ConnectingPoint("Gate", "AUB Main Gate", 350, 620);
		ConnectingPoint p20 = new ConnectingPoint("Building", "Malak Al Tawouk", 675, 575);
		ConnectingPoint p21 = new ConnectingPoint("Intersection", "Clemanceau Intersection", 1100, 425);
		
		this.number_of_points = ConnectingPoint.getCount();
		this.points = ConnectingPoint.getAllPoints();
		
		this.edges = new LinkedList<LinkedList<Node>>();
		for (int i = 0; i < this.number_of_points; i++)
			this.edges.add(new LinkedList<Node>());
		
		this.addEdge(p00, p01); // LAU Lower - Intersection 1
		this.addEdge(p00, p05); // LAU Lower - BHive Cafe
		this.addEdge(p01, p02); // Intersection 1 - Intersection 2
		this.addEdge(p01, p07); // Intersection 1 - Intersection 4
		this.addEdge(p02, p04); // Intersection 2 - Barbar
		this.addEdge(p02, p03); // Intersection 2 - Intersection 3
		this.addEdge(p03, p10); // Intersection 3 - Hamra Intersection
		this.addEdge(p04, p08); // Barbar - Starbucks
		this.addEdge(p08, p07); // Starbucks - Intersection 4
		this.addEdge(p08, p14); // Starbucks - Spinneys
		this.addEdge(p08, p09); // Starbucks - Bank of Beirut
		this.addEdge(p09, p10); // Bank of Beirut - Hamra Intersection
		this.addEdge(p10, p11); // Hamra Intersection - Intersection 7
		this.addEdge(p05, p06); // BHive - Crepaway
		this.addEdge(p06, p07); // Crewpaway - Intersection 4
		this.addEdge(p06, p12); // Crepaway - Intersection 5
		this.addEdge(p07, p13); // Intersection 4 - Intersection 6
		this.addEdge(p12, p13); // Intersection 5 - Intersection 6
		this.addEdge(p13, p14); // Intersection 6 - Spinneys
		this.addEdge(p14, p11); // Spinneys - Intersection 7
		this.addEdge(p12, p18); // Intersection 5 - AUB Bliss Gate
		this.addEdge(p18, p17); // AUB Bliss Gate - McDonald's Bliss
		this.addEdge(p18, p19); // AUB Bliss Gate - AUB Main Gate
		this.addEdge(p13, p19); // Intersection 6 - AUB Main Gate
		this.addEdge(p14, p15); // Spinneys - AUBMC Corner
		this.addEdge(p15, p16); // AUBMC Corner - AUBMC
		this.addEdge(p11, p21); // Intersection 7 - Clemanceau Intersection
		this.addEdge(p16, p21); // AUBMC - Clemanceau Intersection
		this.addEdge(p15, p20); // AUBMC Corner - Malak Al Tawouk
		this.addEdge(p20, p21); // Malak Al Tawouk - Clemanceau Intersection
		this.addEdge(p19, p20); // AUB Main Gate - Malak Al Tawouk
	}
	
	private void addEdge(ConnectingPoint p1, ConnectingPoint p2)
	{
		int dist = ConnectingPoint.getDistance(p1, p2);
		this.edges.get(p1.getID()).add(new Node(p2.getID(), dist));
		this.edges.get(p2.getID()).add(new Node(p1.getID(), dist));
		this.number_of_edges++;
	}
	
	public void printAllPoints()
	{
		System.out.println("Points:\n");
		for (ConnectingPoint p: this.points)
			System.out.printf("%s: (%d, %d)\n", p.getName(), p.getX(), p.getY());
		System.out.printf("Number of points: %d", this.number_of_points);
		System.out.printf("\n\n");
	}
	
	public void printAllEdges()
	{
		System.out.println("Edges:\n");
		for (int i = 0; i < this.edges.size(); i++)
			for (Node w: this.getNeighbors(i))
				System.out.printf("(%s, %s, %dm)\n", this.getPointFromID(i).getName(), this.getPointFromID(w.id).getName(), w.distance);
		System.out.printf("Number of edges: %d", this.number_of_edges);
		System.out.printf("\n");
	}
	
	public ConnectingPoint getPointFromID(int id) // returns the point as an object according to the id
	{
		return (this.points.get(id));
	}
	
	private LinkedList<Node> getNeighbors(int id)
	{
		return (this.edges.get(id));
	}
	
	public int getIDFromName(String name)
	{
		for (ConnectingPoint p: this.points)
			if (p.getName().equals(name))
				return (p.getID());
		return (-1);
	}
}
