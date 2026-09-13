# Write your MySQL query statement below
SELECT unique_id , name 
FROM EmployeeUNI empu
RIGHT JOIN Employees e
ON empu.id = e.id;