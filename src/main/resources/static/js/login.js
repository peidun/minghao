function userLogin(){
    $("#message").text("");
    let username = $("#username").val();
    let password = $("#password").val()
    if (username === "" || password === "") {
        $("#message").text("请输入用户名密码");
    } else {
        $("#login-form").submit();
    }
}