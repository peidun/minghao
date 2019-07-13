function download() {
    let url = "/download/submit"
    $("#message").empty();
    let email = $("#email").val();
    let code = $("#code").val();
    if (email == "" || code == "") {
        $("#message").text("请输入邮箱和下载码");
    } else {
        url = url + "?email=" + email + "&password=" + code;
        fetch(url).then(res => res.blob().then(blob => {
            let type = res.headers.get('Content-Type');
            if (type === "application/x-download") {
                let a = document.createElement('a');
                let url = window.URL.createObjectURL(blob);
                let filename = res.headers.get('Content-Disposition').split("=")[1];
                a.href = url;
                a.download = filename;
                a.click();
                //window.URL.revokeObjectURL(url);
            }
        }));
    }
}