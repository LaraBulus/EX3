package gameClient;

import java.util.List;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.GraphFruit;
import dataStructure.GraphRobot;

public class AutoGame {

		/**
	 * Finds the robot closest to each fruit and  build a path.
	 * 
	 * @param graph - graph 
	 * @param robots - list of game fruits
	 * @param fruits - list of game fruits
	 */
	public void buildRobotsPath(DGraph graph, List<GraphRobot> robots, List<GraphFruit> fruits) {
		GraphFruit temp = new GraphFruit();
		Graph_Algo algo = new Graph_Algo();
		algo.init(graph);
		for(GraphRobot r : robots) {
			double dist = Double.MAX_VALUE;
			for(GraphFruit f : fruits) {
				if(dist > (algo.shortestPathDist(r.getSrc(), f.getEdge().getSrc()) + f.getEdge().getWeight()) 
						&&(!f.getVisited())) {
					dist = algo.shortestPathDist(r.getSrc(), f.getEdge().getSrc())+f.getEdge().getWeight();
					temp = f;
				}
			}
			if(r.getId() != -1) {
				temp.setVisited(true);;
				r.setPath(algo.shortestPath(r.getSrc(), temp.getEdge().getSrc()));
				r.getPath().remove(0); //Remove robot current node
				r.getPath().add(graph.getNode(temp.getEdge().getDest()));
				//r.getPath().add(graph.getNode(temp.getEdge().getSrc()));
				for(GraphFruit fruit : fruits) {
					if(fruit.getPos() == fruit.getPos()) 
						fruit = temp;
				}
			}
		}

	}

}
