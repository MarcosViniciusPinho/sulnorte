$(document).ready(function() {
    mascaraNumeroDecimal("#bhp");
    mascaraNumeroDecimal("#bp");
    permitirSomenteNumeros($('input[id="ano"]'));
    loadPorto();
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

function loadPorto(){
    var id = $("#id").val();
    if(id === ""){
        carregarPortosAoSalvar();
    } else{
        carregarPortosAoAlterar();
    }
}

function carregarPortosAoSalvar(){
    $("#porto").html('<option value="" selected="selected">Selecione um porto</option>');
    $("#armador option:first").attr('selected','selected');
    trocarPortoComDeterminadoArmador();
}

function carregarPortosAoAlterar(){
    $("#porto").html('<option value="" selected="selected">Selecione um porto</option>');
    executarListagemPortos();
    trocarPortoComDeterminadoArmador();
}

function trocarPortoComDeterminadoArmador(){
    $("#armador").change(function() {
        $("#porto").html("");
        $("#porto").html('<option value="" selected="selected">Selecione um porto</option>');
        executarListagemPortos();
    });
}

function executarListagemPortos(){
    var armador = $("#armador").val();
    if(armador !== ""){
        executarJson($("#path").val() + $("#pathController").val() + '/listarPortoPorArmador', armador);
    }
}

function selecionarPortoAoEditar(){
    var id = $("#id").val();
    if(id !== ""){
        var idPorto = $("#portoId").val();
        $("#porto").val(idPorto);
        var result = $("#porto").val();
        if(result === null){
            $("#porto").val("");
        }
    }
}

function executarJson(urlMetodo, parametro) {
    $.ajax({
        url : urlMetodo,
        type: 'POST',
        dataType: 'json',
        data: parametro,
        contentType: 'application/json',
        mimeType: 'application/json',
        success : function(data) {
            var transform = {'tag':'option value=\"\${id}\"','html':'\${nome}'};
            $("#porto").append(json2html.transform(data,transform));
            selecionarPortoAoEditar();
        },
        error:function(data,status,er) {
            console.log('Erro ao enviar<br>' + data +'<br>'+status+'<br>'+er);
        }
    });
}