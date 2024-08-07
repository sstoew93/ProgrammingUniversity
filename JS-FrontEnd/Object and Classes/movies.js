function solve(input) {
    let output = [];

    input.forEach((command) => {
        if (command.includes("addMovie")) {
            const movieName = command.split("addMovie ")[1];
            const movie = { name: movieName };
            output.push(movie);

        } else if (command.includes("directedBy")) {
            const [movieName, directorName] = command.split(" directedBy ");
            let movie = output.find((movie) => movie.name === movieName);

            if (movie) {
                movie.director = directorName;
            }

        } else if (command.includes("onDate")) {
            const [movieName, movieDate] = command.split(" onDate ");
            let movie = output.find((movie) => movie.name === movieName);

            if (movie) {
                movie.date = movieDate;
            }

        }
    });

    output.forEach((movie) => {
        if (movie.director && movie.date) {
            console.log(JSON.stringify(movie));
        }
    });
}

solve([
    "addMovie Fast and Furious",
    "addMovie Godfather",
    "Inception directedBy Christopher Nolan",
    "Godfather directedBy Francis Ford Coppola",
    "Godfather onDate 29.07.2018",
    "Fast and Furious onDate 30.07.2018",
    "Batman onDate 01.08.2018",
    "Fast and Furious directedBy Rob Cohen",
]);
