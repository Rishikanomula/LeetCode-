select(
    select distinct salary
    from Employee
    where salary is NOT NULL 
    order by salary desc
    limit  1 offset  1) as SecondHighestSalary