/**
 * Created by gaohu on 2017/7/15.
 */
app.service("loginService", function ($http) {
    this.login = function (user) {
        var promise = $http({
            method: "post",
            url: "pages/server/user.json",
            data: {
                "name": "gh"
            }
        });
        return promise.then(function (res) {
            for (var i = 0; i < res.data.length; i++) {
                if (user.name == res.data[i].name && user.password == res.data[i].password) {
                    return true;
                } else {
                    return false
                }
            }
        });
    };
});
