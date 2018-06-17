public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText){
      maze = new Maze(mazeText);
	  animate = false;
  }

  public boolean solve(){ return solve(0); }

	private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
      public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }

	public  boolean animate;
    public void setAnimate(boolean a){
	animate = a;
    }

  public boolean solve(int mode){
      if (mode == 0){
	    frontier = new FrontierQueue();
      }
      else if (mode == 1){
	    frontier = new FrontierStack();
      }
	  else {
		maze.setAStar(true);
		if (mode == 2){
		  maze.setAStar(false);
		}
		frontier = new FrontierPriorityQueue();
	  }
      
	  Location[] neighbors = maze.getNeighbors(maze.getStart());
      for(int n = 0; n < neighbors.length && neighbors[n] != null; n++){
	    frontier.add(neighbors[n]);
	  }

	  while (frontier.hasNext()){
		if(animate){
            clearTerminal();
            System.out.println(this);
            wait(40);
        }
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
	MazeSolver test = new MazeSolver("data3.dat");
	test.setAnimate(true);
	test.solve(3);
	System.out.println(test);
	/*MazeSolver test2 = new MazeSolver("data2.dat");
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
	System.out.println(test7);*/

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
