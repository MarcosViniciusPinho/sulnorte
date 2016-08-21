$(document).ready(function() {
    carregarEstados();
    carregarMunicipios();
});

function carregarEstados(){
    $("#estado").html('<option value="" selected="selected">Selecione um estado</option>');
    $("#pais option:first").attr('selected','selected');
    $("#pais").change(function() {
        var pais = $("#pais").val();
        if(pais === ""){
            $("#estado").html("");
            $("#estado").html('<option value="" selected="selected">Selecione um estado</option>');
        } else{
            executarJson("#estado", '/porto/listarEstadoPorPais', pais);
        }
    });
}

function carregarMunicipios(){
    $("#municipio").html('<option value="" selected="selected">Selecione um estado</option>');
    $("#estado option:first").attr('selected','selected');
    $("#estado").change(function() {
        var estado = $("#estado").val();
        if(estado === ""){
            $("#municipio").html("");
            $("#municipio").html('<option value="" selected="selected">Selecione um estado</option>');
        } else{
            executarJson("#municipio", '/porto/listarMunicipioPorEstado', estado);
        }
    });
}

function executarJson(element, urlMetodo, parametro) {
    $(element).html('<option value="" selected="selected">Selecione um estado</option>');
    $.ajax({
        url : urlMetodo,
        type: 'POST',
        dataType: 'json',
        data: parametro,
        contentType: 'application/json',
        mimeType: 'application/json',
        success : function(data) {
            var transform = {'tag':'option id=\"\${id}\"','html':'\${nome}'};
            $(element).append(json2html.transform(data,transform));
        },
        error:function(data,status,er) {
            console.log('Erro ao enviar<br>' + data +'<br>'+status+'<br>'+er);
        }
    });
}