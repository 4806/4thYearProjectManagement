$(document).ready(function(){
    $("#SearchContent").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#TableBody tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});