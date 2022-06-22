Game = (function (){
    var _count = 0;
    var _nPicas = 0;
    var _nFamas = 0;
    var _number = ['9','8','7','6'];
    var _input = [];

    return {

        tryNumber: function (ntry) {
            var url = '/game?input=' + ntry;
            fetch(url, {
                method: 'GET'
            })
                .then(response => response.text())
                .then(res => $("table").append($('<tr><td>' + _count + '</td><td>' + ntry + '</td><td>' + res + '</td>')));
        }
    }
})();