Game = (function (){
    var _count = 0;

    return {

        tryNumber: function (ntry) {
            var url = '/game?input=' + ntry;
            fetch(url, {
                method: 'GET'
            })
                .then(response => response.text())
                .then(res => {
                    console.log(res);
                    console.log(res === "ErrorAttempts");
                    console.log("ingreso");
                    if(res == "ErrorAttempts"){
                        alert("Numero de intentos completado")
                    }else {
                        $("table").append($('<tr><td>' + _count + '</td><td>' + ntry + '</td><td>' + res + '</td>'));
                    }
                });
            _count++;
        }
    }
})();