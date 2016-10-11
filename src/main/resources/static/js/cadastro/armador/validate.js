$(document).ready( function() {
    $("#form").validate({
        rules:{
            'nome':{
                required: true, maxlength: 100
            },
            'portoList':{
                required: true
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
            'portoList':{
                required: ""
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
    $('#mensagemObrigatoriedadePorto').hide();
    validarCamposAoSalvar();
});

function validarCamposAoSalvar(){
    $("#salvar").click(function() {
        retiraEspacosEmBranco();
        validarCampoPortos();
    });
}

function retiraEspacosEmBranco(){
    var array = ["#nome", "#contato", "#logradouro", "#bairro", "#complemento"];
    for(var i = 0; i < array.length; i++){
        var valor = $(array[i]).val();
        if(valor.trim() == ""){
            $(array[i]).val("");
        }
    }
}

function validarCampoPortos(){
    var portos = $('#portoList').val();
    if(portos === null){
        $('#mensagemObrigatoriedadePorto').show();
        $('#mensagemObrigatoriedadePorto').html('É obrigatório selecionar pelo menos um Porto');
    } else{
        $('#mensagemObrigatoriedadePorto').hide();
    }
}