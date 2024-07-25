function checkLeap(year) {
    
    if (year % 4 == 0 && (year % 100 != 0) || (year % 400 == 0)) {
        console.log('yes');
    } else {
        console.log('no');
    }

}

checkLeap(1984);
checkLeap(2003);
checkLeap(4);
checkLeap(2000);