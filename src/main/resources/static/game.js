Game = (function (){
    var _count = 0;
    var _nPicas = 0;
    var _nFamas = 0;
    var _number = [9,8,7,6];
    var _input;

    var tryNumber = function (ntry) {
        _input = [];
        _input = ntry.split("");
        _count++;
        $("table").append($('<tr><td>'+_count+'</td><td>'+ntry+'</td>'));
    }

    return {
        tryNumber: tryNumber,

    }
})();