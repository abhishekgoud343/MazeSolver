package maze_solver;

import java.util.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class MazeSolver extends JFrame {
    private final int[][] maze = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
        {1, 0, 1, 1, 0, 0, 1, 0, 1, 1},
        {1, 0, 1, 1, 0, 1, 1, 0, 0, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 9, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    List<Integer> path;

    public MazeSolver() {
        this.setTitle("Maze Solver");
        this.setSize(600, 600);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.PINK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        path = DepthFirstSearch.searchPath(maze);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(100, 100);

        for (int i = 0; i < maze.length; ++i)
            for (int j = 0; j < maze[0].length; ++j) {
                Color color = switch (maze[i][j]) {
                    case 1 -> Color.BLACK;
                    case 9 -> Color.RED;
                    default -> Color.WHITE;
                };
                g.setColor(color);
                g.fillRect(40 * j, 40 * i, 40, 40);
                
                g.setColor(Color.BLUE);
                g.drawRect(40 * j, 40 * i, 40, 40);
            }
        
        for (int i = 0; i < path.size(); i += 2) {
            int pathx = path.get(i);
            int pathy = path.get(i + 1);

            g.setColor(Color.GREEN);
            g.fillRect(40 * pathx + 4, 40 * pathy + 4, 33, 33);

            // System.out.print("(" + pathx + ", " + pathy + "), ");
        }
    }

    public static void main(String[] args) {
        MazeSolver app = new MazeSolver();
        app.setVisible(true);
    }
}
