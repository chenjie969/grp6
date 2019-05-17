/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.workflow.loader;

import com.opensymphony.workflow.InvalidWorkflowDescriptorException;
import com.opensymphony.workflow.util.Validatable;

import org.w3c.dom.Element;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;


/**
 * DOCUMENT ME!
 * zhongzk 增加了两个属性，以便支持动态生成分支
 * @author $author$
 */
public class SplitDescriptor extends AbstractDescriptor implements Validatable {
    //~ Instance fields ////////////////////////////////////////////////////////

    protected List results = new ArrayList();
    protected boolean dynamic = false;//zhongzk 分支是否动态生成
    protected boolean autochoose = false; //zhongzk角色中的人员，是否还要再选择
    protected String obtainGroupsCallback = "";//zhongzk

    //~ Constructors ///////////////////////////////////////////////////////////

    /**
     * @deprecated use {@link DescriptorFactory} instead
     */
    SplitDescriptor() {
    }

    /**
     * @deprecated use {@link DescriptorFactory} instead
     */
    SplitDescriptor(Element split) {
        init(split);
    }

    //~ Methods ////////////////////////////////////////////////////////////////

    public List getResults() {
        return results;
    }
    
    //zhongzk
    public boolean isDynamic() {
        return this.dynamic;
      }
    
    //zhongzk
    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
      }
    
    //zhongzk
    public boolean isAutochoose() {
        return this.autochoose;
      }
    
    //zhongzk
    public void setAutochoose(boolean autochoose) {
        this.autochoose = autochoose;
      }

    //zhongzk
    public String getObtainGroupsCallback() {
        return this.obtainGroupsCallback;
      }

      public void setObtainGroupsCallback(String obtainGroupsCallback) {
        this.obtainGroupsCallback = obtainGroupsCallback;
      }

    public void validate() throws InvalidWorkflowDescriptorException {
        ValidationHelper.validate(results);
    }

    public void writeXML(PrintWriter out, int indent) {
        XMLUtil.printIndent(out, indent++);
        out.println("<split id=\"" + getId() + "\">");

        for (int i = 0; i < results.size(); i++) {
            ResultDescriptor result = (ResultDescriptor) results.get(i);
            result.writeXML(out, indent);
        }

        XMLUtil.printIndent(out, --indent);
        out.println("</split>");
    }

    private void init(Element split) {
        try {
            setId(Integer.parseInt(split.getAttribute("id")));
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid split id value " + split.getAttribute("id"));
        }

        //zhongzk
        this.dynamic = "true".equalsIgnoreCase(split.getAttribute("dynamic"));
        this.autochoose = "true".equalsIgnoreCase(split.getAttribute("autochoose"));
        this.obtainGroupsCallback = split.getAttribute("obtain-groups-callback");
        
        List uResults = XMLUtil.getChildElements(split, "unconditional-result");

        for (int i = 0; i < uResults.size(); i++) {
            Element result = (Element) uResults.get(i);
            ResultDescriptor resultDescriptor = new ResultDescriptor(result);
            resultDescriptor.setParent(this);
            results.add(resultDescriptor);
        }
    }
}
