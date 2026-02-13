# I create this project to practice the servlet concept
## The Idea
### the prof submit grade of a module ( i onl use one for now ) and student can se his grade
their is three type of roles: 
- User (the basic user only have access to register.html, auth.html)
- Student (after login and check the role student will redirect to studentDashboard)
- Prof (after login and check the role student will redirect to profDashboard)

## DataBase 
- name : grade_db
- tables : 
  - users : id, full_name, role, email, password
  - module : id, student_id(fk), note
- tech : mySQL

## i made a simple schema that be dispo in /resources with name schema.png