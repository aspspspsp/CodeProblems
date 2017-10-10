package LeetCode.Easy;

import java.util.HashMap;
import java.util.List;

import LeetCode.Dependencies.Employee;

/*
//Employee info
class Employee {
 // It's the unique id of each node;
 // unique id of this employee
 public int id;
 // the importance value of this employee
 public int importance;
 // the id of direct subordinates
 public List<Integer> subordinates;
};
*/
public class EmployeeImportance {
 public int getImportance(List<Employee> employees, int id) {
     if(employees == null || employees.size() == 0)
         return 0;
     
     //建立hashMap
     HashMap<Integer, Employee> map = new HashMap<>();
     for(Employee employee : employees) {
         map.put(employee.id, employee);
     }
     
     //利用dfs進行查找
     int result = dfs(id, map);
     
     return result;
 }
 
 int dfs(int id, HashMap<Integer, Employee> map) {
     Employee e = map.get(id);
     int importance = e.importance;
     
     //若該員工沒有下屬員工，可以直接返回該員工的價值
     if(e.subordinates.size() == 0)
         return importance;
     
     //下屬員工的所有價值就是這個員工的價值
     for(int i = 0; i < e.subordinates.size(); i ++) {
         importance += dfs(e.subordinates.get(i), map);
     }
     
     return importance;
 }
}