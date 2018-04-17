weatherApp.factory("weatherService", function ($http) {
    'use strict';
    return {
        doSomething: function ($scope) {
        },

        getWeather: function ($scope) {
            $scope.cities = [{ name: "Vancouver", code: 'CAXX0518' },
                             { name: "Honolulu", code: 'USHI0026' },
                             { name: "San Diego", code: 'USCA0982' },
                             { name: "Havana Cuba", code: 'CUXX0003' }];

            var forecast = []; //init forecast
            var forecastOfAll = [];
            var yahooAPI = "'http://weather.yahooapis.com/forecastrss?p=";
            var format   = "'&format=json&diagnostics=true&callback=";
            var yql      = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20rss%20where%20url%3D";

            var convertUnit = function (unit, value) {
                if (unit === 'celsius') {
                    return value * 9 / 5 + 32;
                } else if (unit === 'fahrenheit') {
                    return (value - 32) * 5 / 9;
                } else {
                    return null;
                }
            };

            // Call and wait for each data set to return before going to next city.
            angular.forEach($scope.cities, function (city) {
                var url = yql + yahooAPI + city.code + format;

                $http.get(url).success(function (data) {
                    try {
                        var stringified = JSON.stringify(data);          // Convert to a string.
                        stringified = stringified.split("\\n").join(""); // Remove new line '/n'.
                        var listing = JSON.parse(stringified);           // Convert to object.

                        for (var i = 0; i < listing.query.results.item.forecast.length; i++) {
                            listing.query.results.item.forecast[i].highCelsius = Math.round(convertUnit('fahrenheit', listing.query.results.item.forecast[i].high));
                            listing.query.results.item.forecast[i].lowCelsius = Math.round(convertUnit('fahrenheit', listing.query.results.item.forecast[i].low));
                        }

                        var currentWeather = listing.query.results.item.forecast[0];
                        currentWeather.cityCode = city.code;
                        currentWeather.cityName = city.name;
                        forecast.push(currentWeather);

                        var allWeather = listing.query.results.item.forecast;
                        allWeather.cityCode = city.code;
                        allWeather.cityName = city.name;
                        forecastOfAll.push(allWeather);
                    }
                    catch (error) {
                        alert("Weather reading error:" + error.name + ": "
                        + error.message);
                    }
                });
            });
            $scope.forecast = forecast;
            $scope.forecastOfAll = forecastOfAll;
        }
    }
});

weatherApp.service('noteService', function() {
    var currentData = '';
    var allData = '';
    var unit = '';

    return {
        setCurrentData: function (value) {
            currentData = value;
        },
        getCurrentData: function () {
            return currentData;
        },
        setAllData: function (value) {
            allData = value;
        },
        getAllData: function () {
            return allData;
        },
        setUnit: function (value) {
            unit = value;
        },
        getUnit: function () {
            return unit;
        }
    };
});
