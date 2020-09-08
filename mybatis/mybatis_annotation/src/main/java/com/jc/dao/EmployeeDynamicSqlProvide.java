package com.jc.dao;

import com.jc.entity.Employee;
import org.apache.ibatis.jdbc.SQL;

/**
 * 动态sql
 */
public class EmployeeDynamicSqlProvide {

    public String select(final Employee employee) {

        return new SQL() {
            {

                SELECT("*");
                FROM("employee");

                StringBuilder whereClause = new StringBuilder();
                if (employee.getName() != null && !employee.getName().equals("")) {
                    whereClause.append(" and name like '").append(employee.getName()).append("' ");
                }
                if (employee.getSex() != null && !employee.getSex().equals("")) {
                    whereClause.append(" and sex like '").append(employee.getSex()).append("' ");
                }
                if (!"".equals(whereClause.toString())) {
                    WHERE(whereClause.toString().replaceFirst("and", ""));
                }

            }
        }.toString();
    }

}
