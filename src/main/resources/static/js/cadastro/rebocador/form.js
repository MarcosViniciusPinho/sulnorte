$(document).ready(function() {
    mascaraNumeroDecimal("#bhp");
    mascaraNumeroDecimal("#bp");
    permitirSomenteNumeros($('input[id="ano"]'));
});

function mascaraNumeroDecimal(elemento){
    $(elemento).maskMoney({
        thousands:'.', decimal:','
    });
}

function permitirSomenteNumeros(input){
    $(input).unbind('keyup').bind('keyup',function(e){
        var thisVal = $(this).val();
        var tempVal = "";
        for(var i = 0; i<thisVal.length; i++){
            if(RegExp(/^[0-9]$/).test(thisVal.charAt(i))){
                tempVal += thisVal.charAt(i);
                if(e.keyCode == 8){
                    tempVal = thisVal.substr(0,i);
                }
            }
        }
        $(this).val(tempVal);
    });
}