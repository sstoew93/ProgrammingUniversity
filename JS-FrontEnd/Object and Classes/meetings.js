function meetings(input) {
    let calendar = {};

    for (const entry of input) {
        let dayOfWeek = entry.split(' ')[0];
        let person = entry.split(' ')[1];

        if(!calendar.hasOwnProperty(dayOfWeek)) {
            calendar[dayOfWeek] = person;
            console.log(`Scheduled for ${dayOfWeek}`);
        } else {
            console.log(`Conflict on ${dayOfWeek}!`);
        }
    }

    Object.keys(calendar).forEach(entry => {
        console.log(`${entry} -> ${calendar[entry]}`);        
    });

}

meetings(["Monday Peter", "Wednesday Bill", "Monday Tim", "Friday Tim"]);
meetings(["Monday Peter", "Wednesday Bill", "Monday Tim", "Friday Tim"]);
