# Maze Solver
The **Maze Solver** is a Desktop application that finds the shortest path to the destination point in a Maze represented by a 2D grid.

The white cells represent traversable cells through which a path could be valid.

The black cells represent obstacles which can't be traversed through and hence there can't be a valid path passing through them. For all configurations, the grid is surrounded by a line of black cells on all sides.

The red cell is unique and represents the destination cell.

The source cell is taken to be the cell with coordinates (1, 1), where the coordinate indices are 0-based.

The solution path is graphically represented by a series of green squares tracing the path. Note that there can be multiple paths that satisfy the requirement, only one of them is displayed in the output.

# Instructions to run the Project locally
1. Open the project folder (Maze Solver) in any IDE or code editor such as IntelliJ IDEA, VS Code, Eclipse etc.  
2. Run the java file at the location Maze Solver/src/maze_solver/MazeSolver.java  
3. This java file contains the _main_ function and therefore the project can be thus run by running the aforementioned java file.  
4. The application will load in a new window.  
5. The maze pattern can be changed by changing the values of the _maze_ array in the main java file.
