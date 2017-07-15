/**
 * Created by gaohuan on 2017/5/25.
 */
app.config(['$stateProvider', '$urlRouterProvider', 'RouterHelperProvider', function ($stateProvider, $urlRouterProvider, helper) {
    'use strict';
    $urlRouterProvider.otherwise('/login');
    $stateProvider
        .state('login', {
            url: '/login',
            title: 'Login View',
            controller:'loginCtrl',
            resolve:helper.resolveFor('login'),
            templateUrl: helper.basePath('login.html')
        })
        .state('app', {
            url: '/app',
            abstract: true,
            templateUrl: helper.basePath('app.html')
        })
        .state('app.processAnalysis', {
            url: '/processAnalysis',
            title: 'processAnalysis View',
            templateUrl: helper.basePath('processAnalysis.html')
        })
        .state('app.softwareAnalysis', {
            url: '/softwareAnalysis',
            title: 'softwareAnalysis',
            templateUrl: helper.basePath('softwareAnalysis.html')
        })
        .state('app.dataBase', {
            url: '/dataBase',
            title: 'dataBase',
            templateUrl: helper.basePath('dataBase.html')
        })
        .state('app.analysisResult', {
            url: '/analysisResult',
            title: 'analysisResult',
            templateUrl: helper.basePath('analysisResult.html')
        });
}]);