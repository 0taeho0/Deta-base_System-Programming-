select count(*), count(emp_pay), sum(emp_pay)/9 , avg(nvl(emp_pay, 0)) from emp_master;
