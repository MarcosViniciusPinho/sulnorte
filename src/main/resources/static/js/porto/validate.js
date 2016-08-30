$(document).ready( function() {
    $("#form").validate({
        rules:{
            'nome':{
                required: true, maxlength: 100
            },
            'filial':{
                required: true, maxlength: 50
            },
            'cnpj':{
                number: true
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
                required: true, maxlength: 150
            },
            'endereco.bairro':{
                required: true, maxlength: 100
            },
            'endereco.numero':{
                required: true, maxlength: 10
            }
        },
        messages:{
            'nome':{
                required: "O campo Nome é obrigatório"
            },
            'filial':{
                required: "O campo Filial é obrigatório"
            },
            'cnpj':{
                number: "Informar somente números neste campo"
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
            'endereco.numero':{
                required: "O campo Número é obrigatório"
            }
        }
    });
    validarCamposAoSalvar();

});

function validarCamposAoSalvar(){
    $("#salvar").click(function() {
        retiraEspacosEmBranco();
    });
}

function retiraEspacosEmBranco(){
    var array = ["#nome", "#filial", "#cnpj", "#logradouro", "#bairro", "#numero"];
    for(var i = 0; i < array.length; i++){
        var valor = $(array[i]).val();
        if(valor.trim() == ""){
            $(array[i]).val("");
        }
    }
}