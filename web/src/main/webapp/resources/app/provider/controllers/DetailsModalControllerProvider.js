angular
    .module('employeeModule')
    .controller('DetailsModalControllerProvider', ['$scope', '$modalInstance', '$log', 'response', '$rootScope', 'VerificationServiceProvider',
        function ($scope, $modalInstance, $log, response, $rootScope, verificationServiceProvider) {

    	  $scope.verificationData = response.data;
          
	        $scope.acceptVerification = function () {
	        	 var dataToSend = {
							verificationId: $rootScope.verificationID,
							status: 'ACCEPTED'
						};
	        	 verificationServiceProvider.acceptVerification(dataToSend).success(function () {
	        		$rootScope.$broadcast('refresh-table');
	        		 $modalInstance.close();
	        	});
	        };
          
          $scope.rejectVerification = function () {
          	$rootScope.$broadcast("verification_rejected", { verifID: $rootScope.verificationID });
          	 $modalInstance.close();
          };
          
          $scope.close = function () {
              $modalInstance.close();
          };
      }]);
