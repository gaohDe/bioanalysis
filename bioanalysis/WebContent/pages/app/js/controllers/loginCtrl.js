/**
 * Created by gaohuan on 2017/3/5.
 */
App.controller('loginCtrl',['$scope','$state',function($scope,$state){
    var contentHeight = $(window).height();
    $("#login").height(contentHeight);
    console.log(contentHeight);
    $scope.submit = function(){
        $state.go('app.singleview');
    };
}]);