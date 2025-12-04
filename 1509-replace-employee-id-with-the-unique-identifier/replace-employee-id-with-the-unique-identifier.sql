# Write your MySQL query statement below
Select unique_id, name from Employees e
left join EmployeeUNI u
on e.id = u.id 