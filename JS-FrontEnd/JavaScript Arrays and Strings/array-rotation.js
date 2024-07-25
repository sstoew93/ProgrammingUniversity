function rotate(array, rotations) {

    let modded = array;

    for (let rotation = 0; rotation < rotations; rotation++) {
        
        let element = modded.shift();

        modded.push(element);

    }
    
    console.log(modded.join(' '));
}

rotate([51, 47, 32, 61, 21], 2);