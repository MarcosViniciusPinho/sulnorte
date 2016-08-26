$(document).ready(function() {
    var id = $("#id").val();
    if(id === ""){
        carregarEstadosAoSalvar();
        carregarMunicipiosAoSalvar();
    } else{
        carregarEstadosAoAlterar();
        carregarMunicipiosAoAlterar();
    }
});

function executarListagemEstados(){
    var pais = $("#pais").val();
    if(pais !== ""){
        executarJson("#estado", '/porto/listarEstadoPorPais', pais);
    }
}

function executarListagemMunicipios(elemento){
    var estado = $(elemento).val();
    executarJson("#municipio", '/porto/listarMunicipioPorEstado', estado);
}

function selecionarEstadoAoEditar(){
    var id = $("#id").val();
    if(id !== ""){
        var idEstado = $("#estadoId").val();
        $("#estado").val(idEstado);
        // $("select#estado option:eq("+idEstado+")").attr('selected','selected');
    }
}

function selecionarMunicipioAoEditar(){
    var id = $("#id").val();
    if(id !== ""){
        var idMunicipio = $("#municipioId").val();
        $("#municipio").val(idMunicipio);
        // $("select#municipio option:eq("+idMunicipio+")").attr('selected','selected');
    }
}

function carregarEstadosAoAlterar(){
    $("#estado").html('<option value="" selected="selected">Selecione um estado</option>');
    executarListagemEstados();
    trocarEstadoComDeterminadoPais();
}

function carregarMunicipiosAoAlterar(){
    $("#municipio").html('<option value="" selected="selected">Selecione um município</option>');
    executarListagemMunicipios("#estadoId");
    trocarMunicipioComDeterminadoEstado();
}

function carregarEstadosAoSalvar(){
    $("#estado").html('<option value="" selected="selected">Selecione um estado</option>');
    $("#pais option:first").attr('selected','selected');
    trocarEstadoComDeterminadoPais();
}

function carregarMunicipiosAoSalvar(){
    $("#municipio").html('<option value="" selected="selected">Selecione um município</option>');
    $("#estado option:first").attr('selected','selected');
    trocarMunicipioComDeterminadoEstado();
}

function trocarEstadoComDeterminadoPais(){
    $("#pais").change(function() {
        $("#estado").html("");
        $("#estado").html('<option value="" selected="selected">Selecione um estado</option>');
        $("#municipio").html("");
        $("#municipio").html('<option value="" selected="selected">Selecione um município</option>');
        executarListagemEstados();
    });
}

function trocarMunicipioComDeterminadoEstado() {
    $("#estado").change(function() {
        $("#municipio").html("");
        $("#municipio").html('<option value="" selected="selected">Selecione um município</option>');
        executarListagemMunicipios("#estado");
    });
}



function executarJson(element, urlMetodo, parametro) {
    $.ajax({
        url : urlMetodo,
        type: 'POST',
        dataType: 'json',
        data: parametro,
        contentType: 'application/json',
        mimeType: 'application/json',
        success : function(data) {
            var transform = {'tag':'option value=\"\${id}\"','html':'\${nome}'};
            $(element).append(json2html.transform(data,transform));
            if(element === "#estado"){
                selecionarEstadoAoEditar();
            } else{
                selecionarMunicipioAoEditar();
            }
        },
        error:function(data,status,er) {
            console.log('Erro ao enviar<br>' + data +'<br>'+status+'<br>'+er);
        }
    });
}