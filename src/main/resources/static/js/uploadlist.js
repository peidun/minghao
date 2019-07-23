"use strict";

new Vue({
    el: '#mainContent',
    list: [],
    data: {
        list: [],
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
                });
            });
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