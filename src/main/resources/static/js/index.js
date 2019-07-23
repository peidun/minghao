$("#submit").click(function () {
    var name = $("#name").val();
    var email = $("#email").val();
    var phone = $("#phone").val();
    var message = $("#message").val();

    $("#tip").text("");
    $("#success-tip").hide();

    if (name.length > 20) {
        $("#tip").text("名字过长");
        return;
    }

    if (email === "" || phone === "") {
        $("#tip").text("请输入邮箱和手机号");
        return;
    }

    if (email.length > 100) {
        $("#tip").text("邮箱过长");
        return;
    }

    var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    if (!reg.test(email)) {
        $("#tip").text("请输入正确的邮箱");
        return;
    }

    if (phone.length !== 11) {
        $("#tip").text("请输入正确的手机号");
        return;
    }

    if (message.length > 500) {
        message = message.substring(0, 500);
    }

    $.ajax({
        url: '/contact',
        type: 'post',
        data: JSON.stringify({
            username: name,
            email: email,
            phone: phone,
            message: message
        }),contentType: 'application/json',
        dataType: 'json',
        success: function (data) {
            if (data.status === 0) {
                $("#success-tip").show();
            } else {
                $("#tip").text("提交失败");
            }
        }, error: function () {
            $("#tip").text("提交失败");
        }
    });


});