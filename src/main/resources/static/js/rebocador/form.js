$(document).ready(function() {
    mascaraNumeroDecimal("#bhp");
    mascaraNumeroDecimal("#bp");
    formatarCamposAntesDeGravar();
});

function formatarCamposAntesDeGravar(){
    $("#salvar").click(function() {
        transformarDecimaisAntesDeGravar("#bp");
        transformarDecimaisAntesDeGravar("#bhp");
    });
}

function mascaraNumeroDecimal(elemento){
    $(elemento).maskMoney({
        thousands:'.', decimal:','
    });
}

function transformarDecimaisAntesDeGravar(elemento){
    var valor = $(elemento).val().replace('.','').replace(',','.');
    $(elemento).val(valor);
}