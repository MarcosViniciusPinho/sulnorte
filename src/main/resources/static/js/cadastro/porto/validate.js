$(document).ready( function() {
    $("#form").validate({
        rules:{
            'nome':{
                required: true, maxlength: 100
            },
            'endereco.pais': {
                required: true
            },
            'endereco.estado':{
                required: true
            },
            'endereco.municipio':{
                required: true
            },
            'endereco.logradouro':{
                required: true, maxlength: 50
            },
            'endereco.bairro':{
                required: true, maxlength: 100
            },
            'endereco.complemento':{
                required: true, maxlength: 80
            }
        },
        messages:{
            'nome':{
                required: "O campo Nome é obrigatório"
            },
            'endereco.pais': {
                required: "O campo País é obrigatório"
            },
            'endereco.estado':{
                required: "O campo Estado é obrigatório"
            },
            'endereco.municipio':{
                required: "O campo Município é obrigatório"
            },
            'endereco.logradouro':{
                required: "O campo Logradouro é obrigatório"
            },
            'endereco.bairro':{
                required: "O campo Bairro é obrigatório"
            },
            'endereco.complemento':{
                required: "O campo Complemento é obrigatório"
            }
        }
    });
    validarCamposAoSalvar();
    $('#cnpj').mask("99.999.999/9999-99");
});

function validarCamposAoSalvar(){
    $("#salvar").click(function() {
        retiraEspacosEmBranco();
    });
}

function retiraEspacosEmBranco(){
    var array = ["#nome", "#cnpj", "#logradouro", "#bairro", "#complemento"];
    for(var i = 0; i < array.length; i++){
        var valor = $(array[i]).val();
        if(valor.trim() == ""){
            $(array[i]).val("");
        }
    }
}