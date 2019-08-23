package com.hk.controller;

import com.hk.dao.DepartmentDao;
import com.hk.dao.EmployeeDao;
import com.hk.entities.Department;
import com.hk.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Classname EmployeeController
 * @Description TODO
 * @Date 2019/8/22 22:31
 * @Created by 13055
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * @Description 查询所有的员工并返回到list.html页面
     * @param
     * @return java.lang.String
     * @date 2019/8/22 22:32
     * @author 13055
     */
    @GetMapping("emps")
    public String empList(ModelMap modelMap){
        Collection<Employee> all = employeeDao.getAll();
        modelMap.put("emps", all);
        return "emp/list";
    }


    /**
     * @Description 跳转到添加员工的页面
     * @param
     * @return java.lang.String
     * @date 2019/8/23 9:45
     * @author 13055
     */
    @GetMapping("emp")
    public String toAddPage(ModelMap modelMap){
        Collection<Department> departments = departmentDao.getDepartments();
        modelMap.put("depts", departments);
        return "emp/add";
    }


    /**
     * @Description 添加员工
     * @param
     * @return java.lang.String
     * @date 2019/8/23 10:12
     * @author 13055
     */
    @PostMapping("emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * @Description 先查出员工的信息，然后再编辑页面进行员工的信息回显
     * @param
     * @return java.lang.String
     * @date 2019/8/23 11:03
     * @author 13055
     */
    @GetMapping("emp/{empId}")
    public String toEditPage(@PathVariable("empId") Integer empId, ModelMap modelMap){
        Employee employee = employeeDao.get(empId);
        modelMap.put("editEmp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        modelMap.put("depts", departments);
        return "emp/edit";
    }

    /**
     * @Description 修改员工的信息
     * @param
     * @param employee
     * @return java.lang.String
     * @date 2019/8/23 11:49
     * @author 13055
     */
    @PutMapping("emp")
    public String editEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    @DeleteMapping("emp/{empId}")
    public String deleteEmp(@PathVariable("empId") Integer empId){
        employeeDao.delete(empId);
        return "redirect:/emps";
    }
}
