$(document).ready(function() {
    $('#portoList').multiSelect({
        afterSelect: function(){
            validarCampoPortos();
        },
        afterDeselect: function(){
            validarCampoPortos();
        }
    });
});