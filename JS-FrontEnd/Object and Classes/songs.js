function songs(input) {
    class Song {
        constructor(typeList, name, duration) {
            this.typeList = typeList;
            this.name = name;
            this.duration = duration;
        }

        getName() {
            return this.name;
        }
    }

    const songsCount = input[0];
    const type = input[input.length - 1];

    let playList = [];

    for (let entry = 1; entry < input.length - 1; entry++) {
        const element = input[entry].split("_");
        const typeOfSong = element[0];
        const nameOfSong = element[1];
        const durationOfSong = element[2];

        if (type === "all") {
            playList.push(new Song(typeOfSong, nameOfSong, durationOfSong));
        } else if (type === typeOfSong) {
            playList.push(new Song(typeOfSong, nameOfSong, durationOfSong));
        }
    }

    playList.forEach((song) => {
        console.log(song.getName());
    });
}

songs([
    3,
    "favourite_DownTown_3:14",
    "favourite_Kiss_4:16",
    "favourite_Smooth Criminal_4:01",
    "favourite",
]);

songs([
    4,
    "favourite_DownTown_3:14",
    "listenLater_Andalouse_3:24",
    "favourite_In To The Night_3:58",
    "favourite_Live It Up_3:48",
    "listenLater",
]);

songs([2, "like_Replay_3:15", "ban_Photoshop_3:48", "all"]);
