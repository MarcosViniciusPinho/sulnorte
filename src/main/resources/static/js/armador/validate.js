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
    var array = ["#nome", "#contato", "#logradouro", "#bairro", "#numero"];
    for(var i = 0; i < array.length; i++){
        var valor = $(array[i]).val();
        if(valor.trim() == ""){
            $(array[i]).val("");
        }
    }
}