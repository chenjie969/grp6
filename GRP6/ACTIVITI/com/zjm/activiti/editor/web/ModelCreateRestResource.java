/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zjm.activiti.editor.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zjm.util.Tool;

/**
 * @author Tijs Rademakers
 */
@RestController
public class ModelCreateRestResource implements ModelDataJsonConstants {
  

  
  @RequestMapping(value="/create")
  public void create(HttpServletRequest request, HttpServletResponse response) {
      try {
      	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
      	 
      	RepositoryService repositoryService = processEngine.getRepositoryService();
      	 
          ObjectMapper objectMapper = new ObjectMapper();
          ObjectNode editorNode = objectMapper.createObjectNode();
          editorNode.put("id", "canvas");
          editorNode.put("resourceId", "canvas");
          ObjectNode stencilSetNode = objectMapper.createObjectNode();
          stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
          editorNode.put("stencilset", stencilSetNode);
          Model modelData = repositoryService.newModel();

          
          String modelName="新建模型";
          ObjectNode modelObjectNode = objectMapper.createObjectNode();
          modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, modelName);
          modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
          String description = modelName;
          modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
          modelData.setMetaInfo(modelObjectNode.toString());
          modelData.setName(modelName);
          modelData.setKey(Tool.createUUID32());

          //保存模型
          repositoryService.saveModel(modelData);
          repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
          response.sendRedirect(request.getContextPath() + "/modeler.jsp?modelId=" + modelData.getId());
      } catch (Exception e) {
          System.out.println("创建模型失败：");
      }
  }
}
