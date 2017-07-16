/**
 * Created by gaohu on 2017/7/15.
 */
app.service("loginService", function ($http) {
    this.login = function (user) {
        var promise = $http({
            method: "post",
            // url: ORIGINSERVERADDRESS + "/login_login",
            url: LOCALSERVERADDRESS + "/login_login",
            //headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            data: {login_name:'admin',password:'admin',is_remember:'0'}
        });

        return promise.then(function (res) {
            return res.data;
        });
    };
});
