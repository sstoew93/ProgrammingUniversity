function towns(input) {

    input.forEach((info) => {
        let [town, latitude, longitude] = info.split(' | ');
        const townInfo = {
            town,
            latitude: Number(latitude).toFixed(2),
            longitude: Number(longitude).toFixed(2)
        };

        console.log(townInfo);
    });
}

towns(["Sofia | 42.696552 | 23.32601", "Beijing | 39.913818 | 116.363625"]);
