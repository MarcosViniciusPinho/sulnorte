$(document).ready( function() {
    $("#form").validate({
        rules:{
            'nome':{
                required: true, maxlength: 100
            },
            'situacaoRebocador':{
                required: true
            },
            'porto':{
                required: true
            },
            'armador':{
                required: true
            }
        },
        messages:{
            'nome':{
                required: "O campo Nome é obrigatório"
            },
            'situacaoRebocador':{
                required: "O campo Situação é obrigatório"
            },
            'porto':{
                required: "O campo Porto é obrigatório"
            },
            'armador':{
                required: "O campo Armador é obrigatório"
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
    var array = ["#nome", "#ano", "#bp", "#bhp", "#observacao"];
    for(var i = 0; i < array.length; i++){
        var valor = $(array[i]).val();
        if(valor.trim() == ""){
            $(array[i]).val("");
        }
    }
}