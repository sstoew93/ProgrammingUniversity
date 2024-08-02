function formatGrade(gradeInput) {
    
    const grade = gradeInput.toFixed(2);

    function check(grade) {
        
        if (grade < 3) {
            return `Fail (2)`;
        } else if (grade < 3.5) {
            return `Poor (${grade})`
        } else if (grade < 4.5) {
            return `Good (${grade})`
        } else if (grade < 5.5 ) {
            return `Very good (${grade})`
        } else {
            return `Excellent (${grade})`
        }

    }

    console.log(check(grade));

}