$(document).ready( function() {
    $("#form").validate({
        rules:{
            'nome':{
                required: true, maxlength: 100
            },
            'ano':{
                required: true, maxlength: 4
            },
            'bp':{
                required: true, maxlength: 10
            },
            'bhp':{
                required: true, maxlength: 10
            },
            'situacaoRebocador':{
                required: true
            },
            'propulsao':{
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
            'ano': {
                required: "O campo Ano é obrigatório"
            },
            'bp':{
                required: "O campo BP é obrigatório"
            },
            'bhp':{
                required: "O campo BHP é obrigatório"
            },
            'situacaoRebocador':{
                required: "O campo Situação é obrigatório"
            },
            'propulsao':{
                required: "O campo Propulsão é obrigatório"
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