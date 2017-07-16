/**
 * Created by gaohu on 2017/7/15.
 */
app.service("loginService", function ($http) {
    this.login = function (user) {
        var promise = $http({
            method: "post",
            url: SERVERADDRESS + "/login_login",
            data: user
        });

        return promise.then(function (res) {
            return res.data;
        });
    };
});
