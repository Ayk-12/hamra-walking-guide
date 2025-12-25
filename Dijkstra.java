import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra
{
	public int distance[];
	public int previous[];
	public ArrayList<Integer> path = new ArrayList<>();

    public Dijkstra(Graph graph, int source, int destination)
    {
        distance = new int[graph.number_of_points];
        previous = new int[graph.number_of_points];
        previous[source] = -1;

        // initialize distances from source to all others to max
        Arrays.fill(distance, Integer.MAX_VALUE); 
        distance[source] = 0; // distance from start to itself is 0

        // using a priority Q to choose the next element to branch
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0)); // adding source to the priority queue

        while (! pq.isEmpty())
        {
            Node current = pq.poll();
            int current_id = current.id;
            int current_distance = current.distance;

            if (current_distance > distance[current_id]) 
            	continue;

            for (Node neighbor: graph.edges.get(current_id))
            {
                int neighbor_id = neighbor.id;
                int cost = neighbor.distance;
                
                //relaxing the edge
                if (distance[current_id] + cost < distance[neighbor_id])
                {
                    distance[neighbor_id] = distance[current_id] + cost;
                    previous[neighbor_id] = current_id;
                    pq.add(new Node(neighbor_id, distance[neighbor_id]));
                }
            }
        }
        
        Stack<Integer> stack = new Stack<>();
        int vertex = destination;
        while (vertex != source)
        {
        	stack.push(vertex);
        	vertex = previous[vertex];
        }
        stack.push(source);
        int popped;
        while (! stack.isEmpty())
        {
        	popped = stack.pop();
        	path.add(popped);
        }
        return ;
    }
}
