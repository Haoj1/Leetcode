public class FindOrder {
  int index;
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] courses = new int[numCourses];
    boolean[] inList = new boolean[numCourses];

    index = 0;
    for (int i = 0; i < numCourses; i++) {
      boolean[] visited = new boolean[numCourses];
      if (!addList(i, prerequisites, inList, visited, courses)) {
        return new int[]{};
      }
    }
    return courses;
  }
  public boolean addList(int course, int[][] prerequisites, boolean[] inList, boolean[] visited, int[] courses) {
    if (inList[index]) {
      return true;
    }
    if (visited[course]) {
      return false;
    }
    visited[course] = true;
    boolean is_add = true;
    for (int i = 0; i < prerequisites.length; i++) {
      if (prerequisites[i][0] == course) {
        is_add = is_add && addList(prerequisites[i][1], prerequisites, inList, visited, courses);
      }
    }
    if (is_add) {
      inList[course] = true;
      courses[index] = course;
      index++;
    }
    return is_add;
  }
}
