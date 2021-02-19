package dev.manolovn.employeeimportance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * source: https://leetcode.com/problems/employee-importance
 * difficulty: EASY
 * topic: DFS + RECURSION
 */
public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        return dfs(id, map);
    }

    private int dfs(int id, Map<Integer, Employee> map) {
        Employee employee = map.get(id);
        int importance = employee.importance;
        for (int subordinate : employee.subordinates) {
            importance += dfs(subordinate, map);
        }
        return importance;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
