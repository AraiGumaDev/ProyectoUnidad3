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
}

function add() {
    if (validateForm() == true) {
        console.log("Adicionando");
        var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        xmlhttp.open("POST", "http://localhost:8080/registers/", true);

        xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

        var direccion = document.getElementById("direccion");
        var estrato = document.getElementById("estrato");
        var numeroHabitantes = document.getElementById("numeroHabitantes");
        var fechaUltimaMedicion = document.getElementById("fechaUltimaMedicion");
        var consumoAguaMes = document.getElementById("consumoAguaMes");


        var newRegister = {
            "direccion": direccion.value,
            "estrato": estrato.value,
            "numeroHabitantes": numeroHabitantes.value,
            "fechaUltimaMedicion": fechaUltimaMedicion.value,
            "consumoAguaMes": consumoAguaMes.value,
        }

        xmlhttp.send(JSON.stringify(newRegister));
    }
}

function validateForm() {
    const form = document.querySelector('form');
    if (!form.checkValidity()) {
        alert('Por favor, completa todos los campos requeridos.');
        return false;
    }
    return true;
}



