package maze_solver;

import java.util.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;

public class MazeSolver extends JFrame {
    private int[][] maze = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
        {1, 0, 1, 1, 0, 0, 1, 0, 1, 1},
        {1, 0, 1, 1, 0, 1, 1, 0, 0, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 9, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public List<Integer> path = new ArrayList<>();

    public MazeSolver() {
        setTitle("Maze Solver");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        path = DepthFirstSearch.searchPath(maze);
    }

    @Override
    public void paint(Graphics g) {
        g.translate(100, 100);

        for (int i = 0; i < maze.length; ++i)
            for (int j = 0; j < maze[0].length; ++j) {
                Color color;
                switch (maze[i][j]) {
                    case 1 : color = Color.BLACK; break;
                    case 9 : color = Color.RED; break;
                    default : color = Color.WHITE; break;
                }
                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30, 30);
                
                g.setColor(Color.BLUE);
                g.drawRect(30 * j, 30 * i, 30, 30);
            }
        
        for (int i = 0; i < path.size(); i += 2) {
            int pathx = path.get(i);
            int pathy = path.get(i + 1);

            g.setColor(Color.GREEN);
            g.fillRect(30 * pathx + 3, 30 * pathy + 3, 24, 24);

            System.out.print("(" + pathx + ", " + pathy + "), ");
        }
    }

    public static void main(String[] args) throws Exception {
        MazeSolver app = new MazeSolver();
        app.setVisible(true);
    }
}