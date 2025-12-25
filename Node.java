class Node implements Comparable<Node> // used in the edges adjacency list; holds the id of the neighbor and its distance from list[i]
{
	public int id;
	public int distance;
	
	public Node(int id, int distance)
	{
		this.id = id;
		this.distance = distance;
	}
	
	@Override
	public String toString()
	{
		return String.format("(%2d, %3d)", this.id, this.distance);
	}

	@Override
	public int compareTo(Node that) {
		if (this.distance > that.distance)
			return (1);
		if (this.distance < that.distance)
			return (-1);
		return 0;
	}
}
