/* ***************************************************************************
 * EZ.JWAF/EZ.JCWAP: Easy series Production.
 * Including JWAF(Java-based Web Application Framework)
 * and JCWAP(Java-based Customized Web Application Platform).
 * Copyright (C) 2016-2017 the original author or authors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of MIT License as published by
 * the Free Software Foundation;
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the MIT License for more details.
 *
 * You should have received a copy of the MIT License along
 * with this library; if not, write to the Free Software Foundation.
 * ***************************************************************************/

angular.module('WebApp').controller('WhiteListCtrl', ['$rootScope', '$scope', "$listService", "$ajaxCall", function ($rootScope, $scope, $listService, $ajaxCall) {

    $scope.modifyDivId = "modifyModalDiv";

    $scope.condition = {};
    $listService.init($scope, {
        "controller": "WhiteController",
        "method": "query",
        callback: function (success) {
            $scope.list = success.data.result;
        }
    });

    /**
     * 刷新数据
     */
    $scope.load = function () {
        $scope.pageRequest.getResponse();
    };
    $scope.load();

    /**
     * 准备添加实体
     */
    $scope.prepareToAdd = function () {
        var scope = $("#" + $scope.modifyDivId).scope();
        scope.title = "添加短信息接收人信息";
        scope.method = "create";
        scope.entity = {
            isEnabled: true,
            bureau: {
                id: $rootScope.token.user.org.bureau.id,
                name: $rootScope.token.user.org.bureau.name
            }
        };

        scope.$on("submitted", function () {
            $scope.load();
        });
        scope.clear();
    };

    /**
     * 准备修改实体
     */
    $scope.prepareToUpdate = function (item) {
        var scope = $("#" + $scope.modifyDivId).scope();
        scope.title = "修改短信息接收人信息";
        scope.method = "update";
        scope.entity = item;

        scope.$on("submitted", function () {
            $scope.load();
        });
        scope.clear();
    };

}]);
