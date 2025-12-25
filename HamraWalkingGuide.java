import java.util.Scanner;

public class HamraWalkingGuide
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		Graph g = new Graph();
		g.buildGraph();
		
		boolean found_start = false;
		boolean found_end = false;
		
		int start_id = -2;
		int end_id = -2;
		
		String start_loc;
		String end_loc;
		
		System.out.print("Enter your current location: ");
		do
		{
			start_loc = scanner.nextLine();
			start_id = g.getIDFromName(start_loc);
			if (start_id == -1)
			{
				System.out.print("Please enter a valid location: ");
				continue ;
			}
			found_start = true;
		} while (! found_start);
		
		System.out.print("Enter your destination location: ");
		do
		{
			end_loc = scanner.nextLine();
			end_id = g.getIDFromName(end_loc);
			if (end_id == -1)
			{
				System.out.print("Please enter a valid location: ");
				continue ;
			}
			found_end= true;
		} while (! found_end);
		
		if (start_id == end_id)
			System.out.println("\nStay where you are.");
		else
		{
			Dijkstra dijkstra = new Dijkstra(g, start_id, end_id);
	
			ConnectingPoint start_point = g.getPointFromID(dijkstra.path.get(0));
			System.out.printf("\nStart from: %s (%s)\n", start_point.getName(), start_point.getKind());
				
			for (int i = 0; i < dijkstra.path.size() - 1; i++)
			{
				int from = dijkstra.path.get(i);
				int to = dijkstra.path.get(i + 1);
				
				ConnectingPoint from_point = g.getPointFromID(from);
				ConnectingPoint to_point = g.getPointFromID(to);
				
				String direction = ConnectingPoint.getDirection(from_point, to_point);
				int distance = ConnectingPoint.getDistance(from_point, to_point);
				
				System.out.printf("Go %s to %s (%s): %dm\n", direction, to_point.getName(), to_point.getKind(), distance);
			}
			
			System.out.println("\nYou have reached your destination.\n");
			
			int total_distance = dijkstra.distance[end_id];
			if (total_distance < 1000)
				System.out.println("Total distance: " + total_distance + "m.");
			else
				System.out.println("Total distance: " + total_distance / 1000 + "km and " + total_distance % 1000 + "m.");
		}
		scanner.close();
	}
}
