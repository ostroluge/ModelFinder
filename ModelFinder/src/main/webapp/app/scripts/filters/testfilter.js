'use strict';

/**
 * @ngdoc filter
 * @name modelFinderApp.filter:testFilter
 * @function
 * @description
 * # testFilter
 * Filter in the modelFinderApp.
 */
angular.module('modelFinderApp')
  .filter('testFilter', function () {
    return function (input) {
      return 'testFilter filter: ' + input;
    };
  });
