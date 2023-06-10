layui.use('jquery', function () {
    const $ = layui.$
    $('.logout-btn').on('click', function () {
        window.sessionStorage.clear();
        location.href = "/employment/logout";
    });
});