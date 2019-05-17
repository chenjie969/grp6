package com.opensymphony.workflow.util;

import com.opensymphony.workflow.util.DynamicSplitGroupCallback;

public class DynamicSplitGroup implements DynamicSplitGroupCallback {

	//@Override
	public String[] excute(String owner) {
		return owner.split(",");
	}

}
