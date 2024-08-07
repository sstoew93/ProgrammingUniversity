function lot(input) {
    let parkingLot = new Set();

    for (let command = 0; command < input.length; command++) {
        const [task, plate] = input[command].split(', ');
        
        if (task === 'IN') {
            parkingLot.add(plate);
        } else if (task === 'OUT') {
            parkingLot.delete(plate);
        }

    }

    const sorted = Array.from(parkingLot).sort((a, b) => a.localeCompare(b)); 

    if (sorted.length === 0) {
        console.log('Parking Lot is Empty');
    } else {
        sorted.forEach(car => {
            console.log(car);
        });
    }
}

lot (['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'IN, CA9999TT',
    'IN, CA2866HI',
    'OUT, CA1234TA',
    'IN, CA2844AA',
    'OUT, CA2866HI',
    'IN, CA9876HH',
    'IN, CA2822UU']);