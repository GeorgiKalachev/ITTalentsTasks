-- task 1
SELECT * FROM departments;

-- task 2
SELECT department_name FROM departments;

-- task3
SELECT CONCAT(first_name,' ',last_name) AS full_name,
salary AS monthly,
salary/20 AS daily,
salary/160 AS hourly 
FROM employees;

-- task4
SELECT CONCAT(email,'@mail.somecompany.com') AS 'Full email address'
 FROM employees;

-- task 5
SELECT DISTINCT salary 
FROM employees;

-- task 6
/*Write a SQL query to find all departments and all region
names, country names and city names as a single list. Use UNION.*/
SELECT department_name
FROM departments d
UNION 
SELECT region_name
FROM regions
UNION
SELECT country_name
FROM countries
UNION
SELECT city
FROM locations;
  
  -- task 7
  /*. Write a SQL query to find all information about the
employees whose position is "AC_MGR" (Accounting Manager).*/
SELECT *
FROM employees
JOIN jobs
ON employees.job_id = jobs.job_id
WHERE jobs.job_title = 'Accounting Manager';

-- task 8
/*Write a SQL query to find the names of all employees whose
first name starts with "Sa". Use LIKE.*/
SELECT CONCAT(first_name,' ',last_name) AS full_name
FROM employees
WHERE first_name LIKE 'Sa%';

-- task 9
/*Write a SQL query to find the names of all employees whose last name
contains the character sequence "ei". Use LIKE.*/
SELECT CONCAT(first_name,' ',last_name) AS full_name
FROM employees
WHERE last_name LIKE '%ei%';

/* 10. Write a SQL query to find the names of all employees whose
salary is in the range [3000...5000]. Use BETWEEN.*/
SELECT CONCAT(first_name,' ',last_name) AS full_name,
	salary AS salary
FROM employees
WHERE salary BETWEEN 3000 AND 5000;

/* 11. Write a SQL query to find the names of all employees whose
salary is in the range [2000...15000] but is not in range [5000 … 10000].
Use MINUS.*/
SELECT CONCAT(first_name,' ',last_name) AS full_name,
	salary AS salary
FROM employees
WHERE salary BETWEEN 2000 AND 15000 
AND employee_id NOT IN (
SELECT employee_id
FROM employees
WHERE salary BETWEEN 5000 AND 10000
)
ORDER BY salary DESC;



/*12. Write a SQL query to find the names of all employees whose
salary is 2500, 4000 or 5000. Use IN.*/
SELECT CONCAT(first_name,' ',last_name) AS full_name,
	salary AS salary
FROM employees
WHERE salary IN (2500,4000,5000);


/*13. Write a SQL query to find all locations that have no state or
post code defined. Use IS NULL.*/
SELECT * 
FROM locations
WHERE state_province IS NULL OR postal_code IS NULL;

/*14. Write a SQL query to find all employees that are paid more
than 10 000. Order them in decreasing order by salary. Use ORDER BY*/
SELECT CONCAT(first_name,' ',last_name) AS full_name,
	salary AS salary
FROM employees
WHERE salary>10000 
ORDER BY salary DESC;

/*15. Write a SQL query to find the first 10 employees joined the
company (most senior people).*/
SELECT 
    d.department_name,
    e.full_name,
    e.hire_date
FROM 
    departments d
JOIN 
    (
        SELECT 
            department_id, 
            CONCAT(first_name, ' ', last_name) AS full_name, 
            hire_date, 
            ROW_NUMBER() OVER (PARTITION BY department_id ORDER BY hire_date ASC) AS rn
        FROM 
            employees
    ) e ON d.department_id = e.department_id AND e.rn <= 10
ORDER BY 
    d.department_name, 
    e.hire_date ASC;
    
    
    /*16. Write a SQL query to find all departments and the town of
their location. Use NATURAL JOIN.*/
SELECT departments.department_name, locations.city
FROM departments
NATURAL JOIN locations;

/*17. Write a SQL query to find all departments and the town of
their location. Use join with USING clause.*/
SELECT departments.department_name, locations.city
FROM departments
JOIN locations 
USING (location_id);

/*18. Write a SQL query to find all departments and the town of
their location. Use inner join with ON clause.*/
SELECT d.department_name, l.city
FROM departments d
INNER JOIN locations l
ON d.location_id = l.location_id;
    
/*19. Modify the last SQL query to include also the name of the
manager for each department.*/
SELECT d.department_name, l.city,e.manager_id
FROM departments d
JOIN locations l
ON d.location_id = l.location_id
JOIN employees e
ON d.manager_id = e.manager_id;

/* 20. Write a SQL query to find all the locations and the
departments for each location along with the locations that do not have
department. User right outer join. */
SELECT d.department_name, l.city
FROM departments d
RIGHT OUTER JOIN locations l
ON d.location_id = l.location_id;

/*21. Rewrite the last SQL query to use left outer join.*/
SELECT l.city,d.department_name
FROM locations l
LEFT OUTER JOIN departments d
ON d.location_id = l.location_id;

/*22. Rewrite the last query to use WHERE instead of JOIN.*/
SELECT l.city, d.department_name 
FROM locations AS l, departments AS d 
WHERE l.location_id = d.location_id
UNION
SELECT l.city, null
FROM locations AS l
WHERE  l.location_id NOT IN (SELECT location_id FROM departments);


/*23. Write a SQL query to find the manager name of each
department.*/
SELECT d.department_name, e.first_name,e.last_name
FROM departments d
JOIN employees e
ON d.manager_id = e.manager_id;

/*24. Modify the last SQL query to find also the location of each
department manager.*/
SELECT d.department_name, e.first_name,e.last_name,l.city
FROM departments d
JOIN employees e
ON d.manager_id = e.manager_id
JOIN locations l
ON d.location_id = l.location_id;

/*25. Write a SQL query to find the names of all employees from
the departments "Sales" and "Finance" whose hire year is between 1995
and 2000.*/
SELECT e.first_name, e.last_name, d.department_name, l.city
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
WHERE d.department_name IN ('Sales', 'Finance')
AND YEAR(e.hire_date) BETWEEN 1995 AND 2000;


/*26. Find all employees that have worked in the past in the
department “Sales”. Use complex join condition.*/
SELECT e.first_name,d.department_name,j.start_date,j.end_date
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
JOIN job_history j
ON j.department_id = d.department_id
WHERE d.department_name = 'Sales'
AND j.end_date < now();


/*27. Write a SQL query to display all employees (first and last
name) along with their corresponding manager (first and last name). Use
self-join.*/
SELECT CONCAT(e.first_name,' ', e.last_name) AS full_name,
       CONCAT(m.first_name,' ', m.last_name) AS MGR_full_name
FROM employees e
JOIN employees m ON e.manager_id = m.employee_id;


-- 28
SELECT e1.first_name, e2.last_name
FROM employees e1
CROSS JOIN employees e2;

-- 29
SELECT e.first_name, e.last_name, j.job_title, d.department_name, l.city, c.country_name, r.region_name
FROM employees e
JOIN jobs j ON e.job_id = j.job_id
JOIN departments d ON e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
JOIN countries c ON l.country_id = c.country_id
JOIN regions r ON c.region_id = r.region_id;

-- 30
SELECT e.first_name, e.last_name, j.job_title, d.department_name, l.city, c.country_name, r.region_name, 
CASE WHEN m.first_name IS NULL THEN 'No manager' ELSE CONCAT(m.first_name, ' ', m.last_name) END AS manager_name
FROM employees e
JOIN jobs j ON e.job_id = j.job_id
JOIN departments d ON e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
JOIN countries c ON l.country_id = c.country_id
JOIN regions r ON c.region_id = r.region_id
LEFT JOIN employees m ON e.manager_id = m.employee_id;

-- 30
SELECT jh_a.employee_id, e.first_name, e.last_name, j.job_title
FROM job_history AS jh_a -- as accountant
JOIN job_history AS jh_m -- as manager
ON jh_a.employee_id = jh_m.employee_id AND jh_a.job_id = 'AC_ACCOUNT' AND jh_m.job_id = 'AC_MGR' AND jh_a.end_date < jh_m.start_date
JOIN employees AS e 
ON e.employee_id = jh_a.employee_id
JOIN jobs AS j
ON j.job_id = jh_a.job_id;
