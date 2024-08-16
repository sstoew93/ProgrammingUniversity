function attachEventsListeners() {
    document.getElementById("daysBtn").addEventListener("click", () => convertTime("days"));
    document.getElementById("hoursBtn").addEventListener("click", () => convertTime("hours"));
    document.getElementById("minutesBtn").addEventListener("click", () => convertTime("minutes"));
    document.getElementById("secondsBtn").addEventListener("click", () => convertTime("seconds"));

    function convertTime(unit) {
        let days, hours, minutes, seconds;

        if (unit === "days") {
            days = Number(document.getElementById("days").value);
            hours = days * 24;
            minutes = hours * 60;
            seconds = minutes * 60;

        } else if (unit === "hours") {
            hours = Number(document.getElementById("hours").value);
            days = hours / 24;
            minutes = hours * 60;
            seconds = minutes * 60;

        } else if (unit === "minutes") {
            minutes = Number(document.getElementById("minutes").value);
            hours = minutes / 60;
            days = hours / 24;
            seconds = minutes * 60;

        } else if (unit === "seconds") {
            seconds = Number(document.getElementById("seconds").value);
            minutes = seconds / 60;
            hours = minutes / 60;
            days = hours / 24;
        }

        document.getElementById('days').value = days;
    document.getElementById('hours').value = hours;
    document.getElementById('minutes').value = minutes;
    document.getElementById('seconds').value = seconds;
    }
}
