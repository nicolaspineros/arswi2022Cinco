Game = (function (){
    let _count;

    return {
        init: function () {
            _count = 0;
            fetch('/count', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: 6
            }).then(r => console.log("Count add"+r))
         },

        tryNumber: function (ntry) {
            var url = '/game?input=' + ntry;
            fetch(url, {
                method: 'GET'
            })
                .then(response => response.text())
                .then(res => {
                    if(res == "ErrorAttempts"){
                        alert("Numero de intentos completado")
                    } else if (res == "Este es el numero correcto!"){
                        alert("Ganador")
                    } else {
                        $("table").append($('<tr><td>' + _count + '</td><td>' + ntry + '</td><td>' + res + '</td>'));
                    }
                });
            _count++;
        }
    }
})();