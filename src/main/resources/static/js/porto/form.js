$(document).ready(function() {
    $("#pais").change(function() {
        var pais = $("#pais").val();
        executarJson("#pais", '/porto/listarEstadoPorPais', pais);
    });
});

function executarJson(element,urlMetodo,pais) {
    $.ajax({
        url : urlMetodo,
        type: 'POST',
        dataType: 'json',
        data: "{\"id\": \"" + pais + "\"}",
        contentType: 'application/json',
        mimeType: 'application/json',
        success : function(data) {
            var transform = {'tag':'option id=\"\${pais}\"','html':'\${pais}'};
            if(data !== null && data.length === 1){
                $(element).html("");
            }
            $(element).append(json2html.transform(data,transform));
        },
        error:function(data,status,er) {
            var msg = 'Erro ao enviar<br>' + data +'<br>'+status+'<br>'+er;
            errorAlert(msg);
        }
    });
}