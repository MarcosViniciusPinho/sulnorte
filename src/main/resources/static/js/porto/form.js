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

function executarListagemEstados(){
    var pais = $("#pais").val();
    if(pais !== ""){
        executarJson("#estado", $("#path").val() + '/porto/listarEstadoPorPais', pais);
        var estado = $("#estado").val();
        var id = $("#id").val();
        if(id !== "" && estado === ""){
            executarListagemMunicipios("#estadoId");
        }
    }
}

function executarListagemMunicipios(elemento){
    var estado = $(elemento).val();
    if(estado !==  ""){
        executarJson("#municipio", $("#path").val() + '/porto/listarMunicipioPorEstado', estado);
    }
}

function selecionarEstadoAoEditar(){
    var id = $("#id").val();
    if(id !== ""){
        var idEstado = $("#estadoId").val();
        $("#estado").val(idEstado);
    }
}

function selecionarMunicipioAoEditar(){
    var id = $("#id").val();
    var idEstado = $("#estadoId").val();
    var estado = $("#estado").val();
    if(id !== "" && idEstado === estado){
        var idMunicipio = $("#municipioId").val();
        $("#municipio").val(idMunicipio);
    } else if(id !== "" && idEstado !== estado){
        $("#municipio").val("");
    }
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