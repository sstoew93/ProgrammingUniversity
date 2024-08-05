function solve(input) {
    let employeeList = {};

    input.forEach((employee, number) => {
        employeeList[employee] = employee.length;
    });

    Object.keys(employeeList).forEach(employee => {
        console.log(`Name: ${employee} -- Personal Number: ${employeeList[employee]}`);
    });
}

solve([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
    ]);