function censoredFilter(text, filter) {
    
    let filtered = text;

    while(filtered.includes(filter)) {
        filtered = filtered.replace(filter, '*'.repeat(filter.length));
    }

    console.log(filtered);

}

censoredFilter('A small sentence with some small words', 'small');