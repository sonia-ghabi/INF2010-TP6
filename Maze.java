import java.util.*;

// Classe a remplir pour realiser le TP en utilisant la classe DisjointSet fournie

public class Maze{

	public Maze(int w, int h, int seed){
		width = w;
		height = h;

		LASTROOM = width*height-1;

		// Initialisation du labyrinthe avec tous les murs
		maze = new Vector<Wall>();
	        // A completer
		int indice = 0;
		while(indice < LASTROOM)
		{
			if((indice+1)%w != 0)
			{
				maze.add(new Wall(indice, indice+1));
			}
			indice++;
		}
		indice = 0;
		while(indice+w <= LASTROOM)
		{
			maze.add(new Wall(indice, indice+w));
			indice++;
		}

		// Creation du graphe de la topologie du labyrinthe
		graph = new Vector<Room>(LASTROOM+1);
		for(int i = 0 ; i<= LASTROOM ; i++)
		{
			graph.add(new Room(i));
		}
		  // A completer		

		// On trie les murs de maniere aleatoire
		generator = new Random(seed);
		for(int i = 0; i < maze.size(); ++i)
		{
			// A completer
			int index = generator.nextInt(maze.size());
			// On swap
			Wall tmp = maze.get(index);
			maze.set(index, maze.get(i));
			maze.set(i, tmp);
		}

		// Initialisation des structures annexes
		ds = new DisjointSet(width*height);
		path = new Vector<Integer>();
	}

	public void generate(){
		// A completer
	}

	public void solve(){
		// A completer
	}

	public class Wall{
		
		public Wall(int r1, int r2){
			room1 = r1;
			room2 = r2;
		}

		public int room1;
		public int room2;
	}

	public class Room{
		
		public Room(int i){
			id = i;
			distance = -1;
			paths = new Vector<Integer>();
		}

		public int id;
		Vector<Integer> paths;
		int distance;		

	}

	public Vector<Wall> maze;
	public Vector<Room> graph;
	public Vector<Integer> path;

	public int LASTROOM;
	public int height;
	public int width;
	public Random generator;
	public DisjointSet ds;
}

