function download() {
    let url = "/download/submit"
    $("#message").empty();
    let code = $("#code").val();
    if (code == "") {
        $("#message").text("请输入下载码");
    } else {
        $("#download-form").submit();
    }
}