/**
 * Created by gaohu on 2017/7/15.
 */
app.service("loginService",function($http){
    this.test = function(user){
        return $http.get('pages/server/user.json').then(function(res){
            for(var i=0;i<res.data.length;i++){
                if(user.name==res.data[i].name&&user.password==res.data[i].password){
                    return true;
                }else{
                    return false
                }
            }
        });
    };
});
