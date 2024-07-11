select em.emp_id as 사원번호, em.emp_name as 성명, em.emp_job as 직무코드, 
       em.emp_grade as 호봉코드, em.emp_pay as 시간급여, 
       hm.ho_start as 최저금액, hm.ho_end as 최고금액
from emp_master em join ho_master hm
on em.emp_grade = hm.ho_grade;
