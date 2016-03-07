'use strict';

/**
 * @ngdoc function
 * @name modelFinderApp.decorator:Testdecorator
 * @description
 * # Testdecorator
 * Decorator of the modelFinderApp
 */
angular.module('modelFinderApp')
  .config(function ($provide) {
    $provide.decorator('testDecorator', function ($delegate) {
      // decorate the $delegate
      return $delegate;
    });
  });
