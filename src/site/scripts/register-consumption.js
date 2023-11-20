function toList(){
    var xhttp = new XMLHttpRequest();
    xhttp.open('GET', 'http://localhost:8080/registers/', true);

    xhttp.onreadystatechange = function() {

        if (xhttp.readyState === XMLHttpRequest.DONE) {
            var status = xhttp.status;
            if (status === 0 || (status >= 200 && status < 400)) {
                var json = JSON.parse(xhttp.responseText);
                createTable(json);
            } else {
                console.log("Error");
            }
        }
    };
    xhttp.send();
}

function createTable(json){
    var tableBody = document.getElementById("table_body");

    var child = tableBody.childElementCount;
    for ( let row = 1; row < child; row++ ) {
        tableBody.deleteRow(child-row);
    }

    json.forEach((row) => {
        var tr = document.createElement("tr");
        Object.values(row).forEach((cell) => {
            var td = document.createElement("td");
            td.textContent = cell;
            tr.appendChild(td);
        });
        tableBody.appendChild(tr);
    });

    function add(){
        console.log("Adicionando");
        var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        xmlhttp.open( "POST", "http://localhost:8080/registers/", true );

        xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

        var addrees = document.getElementById("addrees");
        var socioeconomic_level = document.getElementById("socioeconomic_level");
        var number_inhabitants = document.getElementById("number_inhabitants");
        var last_measurement_date = document.getElementById("last_measurement_date");
        var water_consumption = document.getElementById("water_consumption");


        var newRegister = {
            "addrees": addrees.value,
            "socioeconomic_level": socioeconomic_level.value,
            "number_inhabitants": number_inhabitants.value,
            "last_measurement_date": last_measurement_date.value,
            "water_consumption": water_consumption.value,
        }

        xmlhttp.send(JSON.stringify(newRegister));
    }

}