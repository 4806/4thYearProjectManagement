$( document ).ready(function() {

    console.log("refreshed");

    $("#loginLink").click(function () {
        console.log("calling GET_login");
        GET_login();
    });

    $("#registrationLink").click(function () {
        console.log("calling GET_register");
        GET_register();
    });

    $("#logoutLink").click(function () {
        console.log("calling GET_logout");
        GET_logout();
    });


//    $("#loginSubmit").click(function () {
//        console.log("calling GET_index");
//        GET_index();
//    });


})



function GET_login(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/login',
    }).then(function(data){
        console.log("LOGIN", data)
        displayLogin()
    })
}

function GET_logout(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/logout',
    }).then(function(data){
        console.log("LOGOUT", data)
        displayLogin()
    })
}

function GET_register(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/register',

    }).then(function(data){
        console.log("REGISTER", data)
        displayRegister()
    })
}

function GET_index(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/',
    }).then(function(data){
        console.log("INDEX", data)
        displayIndex()
    })
}

function displayLogin(){
    $("#loginComponent").attr("hidden", false)
    $("#registerComponent").attr("hidden", true)
    $("#indexComponent").attr("hidden", true)
    loggedOut()
}

function displayRegister(){
    $("#loginComponent").attr("hidden", true)
    $("#registerComponent").attr("hidden", false)
    $("#indexComponent").attr("hidden", true)
    loggedOut()
}

function displayIndex(){
    $("#loginComponent").attr("hidden", true)
    $("#registerComponent").attr("hidden", true)
    $("#indexComponent").attr("hidden", false)
    loggedIn()
}

function loggedIn(){
    $("#loginLink").hide()
    $("#registrationLink").hide()
    $("#logoutLink").attr("hidden", false)
}

function loggedOut() {
    $("#loginLink").attr("hidden", false)
    $("#registrationLink").attr("hidden", false)
    $("#logoutLink").hide()
}