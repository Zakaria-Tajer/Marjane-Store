const labels = ["January", "February", "March", "April", "May", "June"];

const data = {
    labels: labels,
    datasets: [
        {
            label: "New Promos",
            backgroundColor: "#84BCBC",
            borderColor: "#84BCBC",
            data: [0, 10, 5, 2, 20, 30, 45],
        },
        {
            label: "Recent Promos",
            backgroundColor: "#EA7651",
            borderColor: "#EA7651",
            data: [0, 120, 53, 21, 27, 30, 45],
        },
    ],
};

const config = {
    type: "line",
    data: data,
    options: {
        responsive: true,

        scales: {
            y: {
                // the data minimum used for determining the ticks is Math.min(dataMin, suggestedMin)
                suggestedMin: 30,

                // the data maximum used for determining the ticks is Math.max(dataMax, suggestedMax)
                suggestedMax: 50,
            },
        },
    },
};

new Chart(document.getElementById("myChart"), config);


const date = new Date();

// request a weekday along with a long date
const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
console.log(date.toLocaleDateString('en-US', options));

document.querySelectorAll("#dates").forEach(e => {
    e.textContent = date.toLocaleDateString('en-US', options)
})