var app = angular.module('myApp', []);

app.controller('MainCtrl', function($scope) {

    $scope.mailOptions = { label: "Mail Options", required:true,  valueList: [{ text: "Do Not Mail", value: "No" },{text:"Mail", value:"yes"}] };
});

app.directive("csRadioField", function () {

    return {
        scope: { options: '=', ngModel: '=' },
        required: ['ngModel', '^form'],
        restrict: 'E',
        templateUrl: function (element, attr) { return 'views/mailOption.html' },
    };
});

