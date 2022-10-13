import java.util.*;

public class NumBusesToDestination {
  public boolean contains (int[] route, int source) {
    for (int i = 0; i < route.length; i++) {
      if (route[i] == source) {
        return true;
      }
    }
    return false;
  }
  public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target) {
      return 0;
    }
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Queue<Integer> q_route = new LinkedList<>();
    for (int k = 0; k < routes.length; k++) {
      int[] route = routes[k];
      int n = route.length;
      for (int i = 0; i < n; i++) {
        int stop = route[i];
        if (!graph.containsKey(stop)) {
          graph.put(stop, new ArrayList<>());
        }
        graph.get(stop).add(k);
      }
    }
    int buses = 1;
    Set<Integer> visited = new HashSet<>();
    boolean[] visited_bus = new boolean[routes.length];
    Queue<Integer> q_temp = new LinkedList<>();
    Queue<Integer> q = new LinkedList<>();
    int temp;
    visited.add(source);
    q.add(source);

    while (!q.isEmpty()) {
      while (!q.isEmpty()) {
        temp = q.poll();
        if (temp == target) {
          return buses;
        }
        q_temp.add(temp);
      }
      while (!q_temp.isEmpty()) {
        temp = q_temp.poll();
        for (int bus : graph.get(temp)) {
          if(!visited_bus[bus]) {
            visited_bus[bus] = true;
            for (int j = 0; j < routes[bus].length; j++) {
              if (!visited.contains(routes[bus][j])) {
                visited.add(routes[bus][j]);
                q.add(routes[bus][j]);
              }
            }
          }
        }
      }
      buses++;
    }

    return -1;
  }
  public int find_routes(int[][] routes, int[] route, Queue<Integer> q, int source, int target, int bus) {
    int buses = 1;
    ArrayList<Integer> visited = new ArrayList<>();
    boolean[] visited_bus = new boolean[routes.length];
    Queue<Integer> q_temp = new LinkedList<>();
    int temp;
    visited.add(source);
    visited_bus[bus] = true;
    for (int i = 0; i < route.length; i++){
      if(!visited.contains(route[i])) {
        q.add(route[i]);
        visited.add(route[i]);
      }
    }
    while (!q.isEmpty()) {
      while (!q.isEmpty()) {
        temp = q.poll();
        if (temp == target) {
          return buses;
        }
        q_temp.add(temp);
      }
      while (!q_temp.isEmpty()) {
        temp = q_temp.poll();
        for (int i = 0; i < routes.length; i++) {
          if (!visited_bus[i] && contains(routes[i], temp)) {
            visited_bus[i] = true;
            for (int j = 0; j < routes[i].length; j++) {
              if (!visited.contains(routes[i][j])) {
                visited.add(routes[i][j]);
                q.add(routes[i][j]);
              }
            }
          }
        }
      }
      buses++;
    }
    return 10000000;
  }
  public static void main(String args[]) {

  }
}
