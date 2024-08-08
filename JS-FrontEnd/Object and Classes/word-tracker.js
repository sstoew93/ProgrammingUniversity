function track(input) {
    let trackedWords = {};

    const [words, ...rest] = input;
    
    const trackingWords = words.split(' ');
    trackingWords.forEach(word => {
        trackedWords[word] = 0;
    });

    rest.forEach(word => {
        if (trackedWords.hasOwnProperty(word)) {
            trackedWords[word]++;
        }
    });

    const trackedSorted = Object.keys(trackedWords)
    .sort((a, b) => trackedWords[b] - trackedWords[a])
    .reduce((sorted, key) => {
        sorted[key] = trackedWords[key];
        return sorted;
    }, {});

    Object.keys(trackedSorted).forEach(word => {
        console.log(`${word} - ${trackedSorted[word]}`);
    });
}


track([
    "this sentence go",
    "In",
    "this",
    "sentence",
    "you",
    "have",
    "to",
    "count",
    "the",
    "occurrences",
    "of",
    "the",
    "words",
    "this",
    "and",
    "sentence",
    "because",
    "this",
    "is",
    "your",
    "task",
]);

