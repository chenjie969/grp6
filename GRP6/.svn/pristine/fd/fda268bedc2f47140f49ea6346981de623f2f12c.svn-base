/*
 * Activiti Modeler component part of the Activiti project
 * Copyright 2005-2014 Alfresco Software, Ltd. All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

/*
 * FormKeyDefinition  mashuo add 20170803 表单编号设置
 */
var KisBpmFormKeyDefinitionCtrl = [ '$scope', '$modal', function($scope, $modal) {

	// Config for the modal window
	var opts = {
			template:  'editor-app/configuration/properties/form-key-definition-popup.html?version=' + Date.now(),
			scope: $scope
	};

	// Open the dialog
	$modal(opts);
}];

var KisBpmFormKeyDefinitionPopupCtrl = [ '$scope','$http', function($scope,$http) {
	//***********************mashuo add begin 20170803
	/*var dicTaskurl="/gbpm/dicTaskManager/selectTaskManagerList";
	$http({method: 'POST', url: dicTaskurl}).success(function (data, status, headers, config) {
		$scope.formItem=data.obj;
	});*/
	//***********************mashuo add end 20170803

	// Put json representing formkeydefinition on scope
	if ($scope.property.value !== undefined && $scope.property.value !== null && $scope.property.value !== ""){
		var formkeydefinitionIDArray=[];
		$scope.formkeydefinition=[];
		formkeydefinitionIDArray=$scope.property.value.split(",");
		for(var i=0;i<formkeydefinitionIDArray.length;i++){
			if(formkeydefinitionIDArray[i]!==""){
				$scope.formkeydefinition.splice(i, 0, {value: formkeydefinitionIDArray[i]});
			}
		}
	}

	if ($scope.formkeydefinition == undefined || $scope.formkeydefinition.length == 0){
		$scope.formkeydefinition = [{value: ''}];
	}

	// Click handler for + button after enum value
	var userValueIndex = 1;
	$scope.addFormKeyDefinitionValue = function(index) {
		$scope.formkeydefinition.splice(index + 1, 0, {value: 'value ' + userValueIndex++});
	};

	// Click handler for - button after enum value
	$scope.removeFormKeyDefinitionValue = function(index) {
		$scope.formkeydefinition.splice(index, 1);
	};


	$scope.save = function() {

		$scope.property.value = "";
		handleFormKeyDefinitionInput($scope);
		$scope.property.value = $scope.formkeydefinitionIDString;

		$scope.updatePropertyInModel($scope.property);
		$scope.close();
	};

	// Close button handler
	$scope.close = function() {
		handleFormKeyDefinitionInput($scope);
		$scope.property.mode = 'read';
		$scope.$hide();
	};

	var handleFormKeyDefinitionInput = function($scope) {
		if ($scope.formkeydefinition){
			var formkeydefinitionIDArr=[];
			var empty = true;
			var toRemoveIndexes = [];
			for (var i = 0; i < $scope.formkeydefinition.length; i++){
				if ($scope.formkeydefinition[i].value != ''){
					formkeydefinitionIDArr[i]=$scope.formkeydefinition[i].value;
					empty = false;
				}
				else{
					toRemoveIndexes[toRemoveIndexes.length] = i;
				}
			}
			for (var i = 0; i < toRemoveIndexes.length; i++){
				$scope.formkeydefinition.splice(toRemoveIndexes[i], 1);
			}
			$scope.formkeydefinitionIDString="";
			$scope.formkeydefinitionIDString=formkeydefinitionIDArr.join(",");
			if (empty){
				$scope.formkeydefinition = undefined;
				$scope.formkeydefinitionIDString=undefined;
			}
		}

	};
}];




//mashuo add 20170804  参数面板显示任务事项名称
var KisBpmFormKeyDefinitionViewCtrl = [ '$scope','$http', function($scope,$http) {
	/*var dicTaskurl="/gbpm/dicTaskManager/selectTaskManagerList";
	$http({method: 'POST', url: dicTaskurl}).success(function (data, status, headers, config) {
		$scope.formItem=data.obj;*/
		if ($scope.property.value !== undefined && $scope.property.value !== null && $scope.property.value !== ""){
			var formkeydefinitionNameArray=[];
			var formkeydefinitionIDArray=[];
			$scope.formkeydefinition=[];
			formkeydefinitionIDArray=$scope.property.value.split(",");
			for(var i=0;i<formkeydefinitionIDArray.length;i++){
				if(formkeydefinitionIDArray[i]!==""){
					for(var a=0;a<$scope.formItem.length;a++){
						if(formkeydefinitionIDArray[i]==$scope.formItem[a].taskManager_ID){
							formkeydefinitionNameArray[i]=$scope.formItem[a].taskName;
						}
					}
				}
			}
			$scope.formkeydefinitionNameString="";
			$scope.formkeydefinitionNameString=formkeydefinitionNameArray.join(",");
		}
	/*});*/
}];