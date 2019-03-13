$( document ).ready(function() {

    console.log("refreshed");

    $("#loginLink").click(function () {
        console.log("working");
        GET_login();
    });

    $("#registrationLink").click(function () {
        console.log("working");
        GET_register();
    });

    $("#logoutLink").click(function () {
        console.log("working");
        GET_index();
    });




})

//.attr("hidden", false)

    // $("#search-form").submit(function (event) {
    //     //stop submit the form, we will post it manually.
    //     event.preventDefault();
    //     fire_ajax_submit();
    // });


function GET_login(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/login',
    }).then(function(data){
        console.log("LOGIN", data)
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
    // $("#loginComponent").attr("hidden", false)
    // $("#registerComponent").attr("hidden", true)
    // $("#indexComponent").attr("hidden", true)
    $("#bodyComponent").replaceWith("login.html");
    console.log("should have replaced")
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
    loggedOut()
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