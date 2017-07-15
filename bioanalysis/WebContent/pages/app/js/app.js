/**
 * Created by gaohuan on 2017/5/25.
 */
app.config(['$controllerProvider', '$compileProvider', '$filterProvider', '$provide',
    function ($controllerProvider, $compileProvider, $filterProvider, $provide) {
        'use strict';
        // registering components after bootstrap
        app.controller = $controllerProvider.register;
        app.directive = $compileProvider.directive;
        app.filter = $filterProvider.register;
        app.factory = $provide.factory;
        app.service = $provide.service;
        app.constant = $provide.constant;
        app.value = $provide.value;

    }]);
app.provider('RouterHelper', ['APP_REQUIRES', function (appRequires) {
    this.basePath = function (uri) {
        return 'pages/app/views/' + uri;
    };
    this.resolveFor = function () {
        var _args = arguments;
        return {
            deps: ['$ocLazyLoad', '$q', function ($ocLL, $q) {
                var promise = $q.when(1);
                for (var i = 0, len = _args.length; i < len; i++) {
                    promise = andThen(_args[i]);
                }
                return promise;
                function andThen(_arg) {
                    if (typeof _arg == 'function')
                        return promise.then(_arg);
                    else
                        return promise.then(function () {
                            var whatToLoad = getRequired(_arg);
                            if (!whatToLoad) return alert('Route resolve: Bad resource name [' + _arg + ']');
                            return $ocLL.load(whatToLoad);
                        });
                }

                function getRequired(name) {
                    if (appRequires.modules)
                        for (var m in appRequires.modules)
                            if (appRequires.modules[m].name && appRequires.modules[m].name === name)
                                return appRequires.modules[m];
                    return appRequires.scripts && appRequires.scripts[name];
                }
            }]
        };
    };
    this.$get = function () {
    }
}]);
