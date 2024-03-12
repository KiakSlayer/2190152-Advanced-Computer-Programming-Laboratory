async function generateChart() {
    // Write your code here. You can write your own function(s) if you want.

    if (window.chart) {
        window.chart.destroy();
    }
    const response = await fetch("https://restcountries.com/v3.1/all");
    const countryData = await response.json();
    const countryName = countryData.map(dummy => dummy.name.common);
    const countryPopulation = countryData.map(dummy => dummy.population);
    const number = document.getElementById("numberOfCountries").value;
    var nameList = [];
    var populationList = [];
    for (i=0; i<number; i++) {
        nameList.push(countryName[i]);
        populationList.push(countryPopulation[i]);
    }


    const ctx = document.getElementById('barChart');

    const graph = {
        type: 'bar',
        data: {
            labels: nameList,
            datasets: [{
                label: 'Total Population',
                data: populationList,
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    };

    window.chart = new Chart(ctx, graph)  
};