package maze_solver;

import java.util.*;

public class DepthFirstSearch {
    static class Pair {
		int x, y;
        Pair parent;

		Pair(int x, int y) {
			this.x = x;
            this.y = y;
            this.parent = null;
		}
	}

    static List<Integer> backtrackPath(Pair cur) {
        List<Integer> path = new ArrayList<>();
        Pair iter = cur;

        while (iter != null) {
            path.add(iter.x);
            path.add(iter.y);
    
            iter = iter.parent;
        }

        System.out.println(path);

        return path;
    }

    public static List<Integer> searchPath(int[][] maze) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 1)); 
        
        while (!q.isEmpty()) {
            Pair pt = q.remove();

            if (maze[pt.y][pt.x] == 9)
                return backtrackPath(pt);
            
            if (maze[pt.y][pt.x] == 2)
                continue;
            maze[pt.y][pt.x] = 2;
            
            for (int i = 0; i < 4; i++) {
                int nx = pt.x + dirs[i][0];
                int ny = pt.y + dirs[i][1];

                if (nx >= 0 && nx < maze[0].length && ny >= 0 && ny < maze.length && (maze[ny][nx] == 0 || maze[ny][nx] == 9)) {
                    Pair np = new Pair(nx, ny);
                    np.parent = pt;
                    q.add(np);
                }
            }
        }
    
        return Collections.emptyList();
    }
}