public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText){
      maze = new Maze(mazeText);
  }

  public boolean solve(){ return solve(0); }

  public boolean solve(int mode){
      if (mode == 0){
	    frontier = new FrontierQueue();
      }
      else{
	    frontier = new FrontierStack();
      }
      
	  Location[] neighbors = maze.getNeighbors(maze.getStart());
      for(int n = 0; n < neighbors.length && neighbors[n] != null; n++){
	    frontier.add(neighbors[n]);
	  }

	  while (frontier.hasNext()){
		Location next = frontier.next();
		maze.setSpot(next.getX(), next.getY(), '.');
		Location[] neighbors2 = maze.getNeighbors(next);
	    for(int n = 0; n < neighbors2.length && neighbors2[n] != null; n ++){
			if(neighbors2[n].getX() == maze.getEnd().getX() && neighbors2[n].getY() == maze.getEnd().getY()){
				Location current = neighbors2[n].getPrevious();
				while(current.getX() != maze.getStart().getX() || current.getY() != maze.getStart().getY()){
					maze.setSpot(current.getX(), current.getY(), '@');
					current = current.getPrevious();
				}
				return true;
			}
		frontier.add(neighbors2[n]);
		maze.setSpot(neighbors2[n].getX(), neighbors2[n].getY(), '?');
	    }	    
	  }
	return false;
  }

  public String toString(){
    return maze.toString();
  }

  public static void main(String[]args){
	MazeSolver test = new MazeSolver("data1.dat");
	test.solve();
	System.out.println(test);
	MazeSolver test2 = new MazeSolver("data2.dat");
	test2.solve();
	System.out.println(test2);
	MazeSolver test3 = new MazeSolver("data3.dat");
	test3.solve();
	System.out.println(test3);
	MazeSolver test4 = new MazeSolver("data4.dat");
	test4.solve();
	System.out.println(test4);
	MazeSolver test5 = new MazeSolver("data5.dat");
	test5.solve();
	System.out.println(test5);
	MazeSolver test6 = new MazeSolver("data6.dat");
	test6.solve();
	System.out.println(test6);
	MazeSolver test7 = new MazeSolver("data7.dat");
	test7.solve();
	System.out.println(test7);

	/*MazeSolver test = new MazeSolver("data1.dat");
	test.solve(1);
	System.out.println(test);
	MazeSolver test2 = new MazeSolver("data2.dat");
	test2.solve(1);
	System.out.println(test2);
	MazeSolver test3 = new MazeSolver("data3.dat");
	test3.solve(1);
	System.out.println(test3);
	MazeSolver test4 = new MazeSolver("data4.dat");
	test4.solve(1);
	System.out.println(test4);
	MazeSolver test5 = new MazeSolver("data5.dat");
	test5.solve(1);
	System.out.println(test5);
	MazeSolver test6 = new MazeSolver("data6.dat");
	test6.solve(1);
	System.out.println(test6);
	MazeSolver test7 = new MazeSolver("data7.dat");
	test7.solve(1);
	System.out.println(test7);*/
  }
}
