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
 * Assignment
 */
var KisBpmAssignmentCtrl = [ '$scope', '$modal', function($scope, $modal) {

    // Config for the modal window
    var opts = {
        template:  'editor-app/configuration/properties/assignment-popup.html?version=' + Date.now(),
        scope: $scope
    };

    // Open the dialog
    $modal(opts);
}];

var KisBpmAssignmentPopupCtrl = [ '$scope','$http', function($scope,$http) {
	
	//***********************mashuo add begin 20170801
	/*var userurl="/sys/dic/selectUsersDicNoEableList";
	$http({method: 'POST', url: userurl}).success(function (data, status, headers, config) {
		$scope.userItem=data.obj;
      });*/
	
	/*var roleurl="/sys/dic/selectRoleDicList";
	$http({method: 'POST', url: roleurl}).success(function (data, status, headers, config) {
		$scope.roleItem=data.obj;
      });*/
	
	//***********************mashuo add end 20170801
    	
    // Put json representing assignment on scope
    if ($scope.property.value !== undefined && $scope.property.value !== null
        && $scope.property.value.assignment !== undefined
        && $scope.property.value.assignment !== null) 
    {
        $scope.assignment = $scope.property.value.assignment;
    } else {
        $scope.assignment = {};
    }

    if ($scope.assignment.candidateUsers == undefined || $scope.assignment.candidateUsers.length == 0)
    {
    	$scope.assignment.candidateUsers = [{value: ''}];
    }
    
    // Click handler for + button after enum value
    var userValueIndex = 1;
    $scope.addCandidateUserValue = function(index) {
        $scope.assignment.candidateUsers.splice(index + 1, 0, {value: 'value ' + userValueIndex++});
    };

    // Click handler for - button after enum value
    $scope.removeCandidateUserValue = function(index) {
        $scope.assignment.candidateUsers.splice(index, 1);
    };
    
    if ($scope.assignment.candidateGroups == undefined || $scope.assignment.candidateGroups.length == 0)
    {
    	$scope.assignment.candidateGroups = [{value: ''}];
    }
    
    var groupValueIndex = 1;
    $scope.addCandidateGroupValue = function(index) {
        $scope.assignment.candidateGroups.splice(index + 1, 0, {value: 'value ' + groupValueIndex++});
    };

    // Click handler for - button after enum value
    $scope.removeCandidateGroupValue = function(index) {
        $scope.assignment.candidateGroups.splice(index, 1);
    };

    $scope.save = function() {

        $scope.property.value = {};
        handleAssignmentInput($scope);
        $scope.property.value.assignment = $scope.assignment;
        
        $scope.updatePropertyInModel($scope.property);
        $scope.close();
    };

    // Close button handler
    $scope.close = function() {
    	handleAssignmentInput($scope);
    	$scope.property.mode = 'read';
    	$scope.$hide();
    };
    
    var handleAssignmentInput = function($scope) {
    	if ($scope.assignment.candidateUsers)
    	{
	    	var emptyUsers = true;
	    	var toRemoveIndexes = [];
	        for (var i = 0; i < $scope.assignment.candidateUsers.length; i++)
	        {
	        	if ($scope.assignment.candidateUsers[i].value != '')
	        	{
	        		emptyUsers = false;
	        	}
	        	else
	        	{
	        		toRemoveIndexes[toRemoveIndexes.length] = i;
	        	}
	        }
	        
	        for (var i = 0; i < toRemoveIndexes.length; i++)
	        {
	        	$scope.assignment.candidateUsers.splice(toRemoveIndexes[i], 1);
	        }
	        
	        if (emptyUsers)
	        {
	        	$scope.assignment.candidateUsers = undefined;
	        }
    	}
        
    	if ($scope.assignment.candidateGroups)
    	{
	        var emptyGroups = true;
	        var toRemoveIndexes = [];
	        for (var i = 0; i < $scope.assignment.candidateGroups.length; i++)
	        {
	        	if ($scope.assignment.candidateGroups[i].value != '')
	        	{
	        		emptyGroups = false;
	        	}
	        	else
	        	{
	        		toRemoveIndexes[toRemoveIndexes.length] = i;
	        	}
	        }
	        
	        for (var i = 0; i < toRemoveIndexes.length; i++)
	        {
	        	$scope.assignment.candidateGroups.splice(toRemoveIndexes[i], 1);
	        }
	        
	        if (emptyGroups)
	        {
	        	$scope.assignment.candidateGroups = undefined;
	        }
    	}
    };
}];


//mashuo add 20170804  参数面板显示分配用户名称
var KisBpmAssignmentViewCtrl = [ '$scope','$http', function($scope,$http) {
	if ($scope.property.value !== undefined && $scope.property.value !== null
			&& $scope.property.value.assignment !== undefined
			&& $scope.property.value.assignment !== null){
		$scope.assignment = $scope.property.value.assignment;
	} else {
		$scope.assignment = {};
	}
	if ($scope.assignment.candidateUsers == undefined || $scope.assignment.candidateUsers.length == 0){
		$scope.assignment.candidateUsers = [{value: ''}];
	}
	if ($scope.assignment.candidateGroups == undefined || $scope.assignment.candidateGroups.length == 0){
		$scope.assignment.candidateGroups = [{value: ''}];
	}
	//设置办理人名称
	
	if ($scope.assignment.assignee !== undefined && $scope.assignment.assignee !== null && $scope.assignment.assignee !== ""){
		for(var a=0;a<$scope.userItem.length;a++){
			if($scope.assignment.assignee==$scope.userItem[a].id){
				$scope.assignment.assigneeName="办理人：无；";
				$scope.assignment.assigneeName="办理人："+$scope.userItem[a].name+";";
			}
		}
	}else{
		$scope.assignment.assigneeName="办理人：无；";
	}
	
	
	//设置候选人名称
	if ($scope.assignment.candidateUsers !== undefined && $scope.assignment.candidateUsers !== null && $scope.assignment.candidateUsers.length !==0){
		var candidateUsersNameArray=[];
		for(var i=0;i<$scope.assignment.candidateUsers.length;i++){
			if($scope.assignment.candidateUsers[i].value!==""){
				for(var a=0;a<$scope.userItem.length;a++){
					if($scope.assignment.candidateUsers[i].value==$scope.userItem[a].id){
						candidateUsersNameArray[i]=$scope.userItem[a].name;
					}
				}
			}
		}
		$scope.assignment.candidateUsersName="候选人：无";
		if(candidateUsersNameArray.length!==0){
			$scope.assignment.candidateUsersName="候选人："+candidateUsersNameArray.join(",")+";";
		}
		
	}else{
		$scope.assignment.candidateUsersName="候选人：无";
	}
	//设置候选组名称
	if ($scope.assignment.candidateGroups !== undefined && $scope.assignment.candidateGroups !== null && $scope.assignment.candidateGroups.length !==0){
		var candidateGroupsNameArray=[];
		for(var i=0;i<$scope.assignment.candidateGroups.length;i++){
			if($scope.assignment.candidateGroups[i].value!==""){
				for(var a=0;a<$scope.roleItem.length;a++){
					if($scope.assignment.candidateGroups[i].value==$scope.roleItem[a].id){
						candidateGroupsNameArray[i]=$scope.roleItem[a].name;
					}
				}
			}
		}
		$scope.assignment.candidateGroupsName="候选组：无";
		if(candidateGroupsNameArray.length!==0){
			$scope.assignment.candidateGroupsName="候选组："+candidateGroupsNameArray.join(",")+";";
		}
	}else{
		$scope.assignment.candidateGroupsName="候选组：无";
	}
}];
