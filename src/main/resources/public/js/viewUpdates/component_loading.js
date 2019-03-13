function loggedIn(){
    $("#loginLink").hide()
    $("#registrationLink").hide()
    $("#logoutLink").attr("hidden", false)
}

function loggedOut(){
    $("#loginLink").attr("hidden", false)
    $("#registrationLink").attr("hidden", false)
    $("#logoutLink").hide()
}