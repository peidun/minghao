function download() {
    let url = "/download/submit"
    $("#message").empty();
    let code = $("#code").val();
    if (code == "") {
        $("#message").text("请输入下载码");
    } else {
        url = url + "?password=" + code;
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
            } else {
                $("#message").text("请输入正确的下载码");
            }
        }));
    }
}