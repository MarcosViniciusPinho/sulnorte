$(document).ready(function() {
    desabilitarMenu();
    habilitarMenu();
});

function habilitarMenu(){
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
}

function desabilitarMenu(){
    $("#wrapper").toggleClass("toggled");
}