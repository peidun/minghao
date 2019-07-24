"use strict";

new Vue({
    el: '#mainContent',
    list: [],
    data: {
        list: [],
        loading: true,
        page: {
            curPage: 1,
            pageSize: 5 // total: 1

        }
    },
    mounted: function mounted() {
        this.onSearch(1);
    },
    methods: {
        onSearch: function onSearch(page) {
            var _this = this;

            page = page ? page : 1;
            this.page.curPage = page;
            setTimeout(function () {
                ajaxForPageData(_this.page.curPage, _this.page.pageSize).then(function (data) {
                    // let responseData = data;
                    _this.page.total = data.data.total;
                    var dataList = data.data.list;

                    for (var p in dataList) {
                        var time = moment(dataList[p].uploadTime).format('YYYY-MM-DD HH:mm:ss');
                        dataList[p].uploadTime = time;
                    }

                    _this.list = dataList;
                    _this.loading = false;
                });
            });
        },
        onDelete: function onDelete(id) {
            let _this = this;
            _this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {

                setTimeout(function () {
                    ajaxForDelete(id).then(function (data) {
                        if (data.status === 0) {
                            _this.$message({
                                type: 'success',
                                message: '删除成功!'
                            });
                            _this.onSearch();
                        } else {
                            _this.$message({
                                type: 'error',
                                message: data.message
                            });
                        }
                    });
                });


            });
        },
        download: function download(password) {
            $("#download-form input[name='password']").val(password);
            $("#download-form").submit();
        }
    }
});

function ajaxForPageData(curPageNum, pageSize) {
    var p = new Promise(function (resolve, reject) {
        $.ajax({
            url: "/upload/list/page",
            type: "post",
            data: JSON.stringify({
                "pageNum": curPageNum,
                "pageSize": pageSize
            }),
            contentType: 'application/json',
            dataType: "json",
            async: false,
            success: function success(result) {
                resolve(result);
            }
        });
    });
    return p;
}

function ajaxForDelete(id) {
    var p = new Promise(function (resolve, reject) {
        $.ajax({
            url: "/upload/delete/" + id,
            type: "post",
            dataType: "json",
            async: false,
            success: function success(result) {
                resolve(result);
            }
        });
    });
    return p;
}