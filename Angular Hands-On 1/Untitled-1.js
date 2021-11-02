//Handson-1
var Employee = {
    Salary: 5000,
    firstName: "John",
    lastName: "Stoke",
    permanentStaff: true
}

console.log(Employee);


//Handson-2
var employee = '{"firstName": "John", "lastName": "Stoke", "Salary", 5000, "permanentStaff": true';
var employeeJS = JSON.parse(employee);
for(var object in employeeJS){
    console.log(object + ": " + employee[property])
}


//Handson-3
employee = '{"department id":3, "department name": "payroll"}';
employeeJS.department = JSON.parse(employee);
for(var object in employeeJS.department){
    console.log(object + ": " + employeeJS.department[object])
}

employee = '[{"id":1, "value": HTML"}, {"id":2, "value": "CSS"}, {"id":3, "value":"JavaScript"}]';
employeeJS.skill = JSON.parse(employee);
for(let o=0; o < employeeJS.skill.length; o++){
    
}