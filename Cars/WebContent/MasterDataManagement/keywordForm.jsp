<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- Form fields for the keyword's attributes --%>
	<s:hidden name="keyword.id"/>
	<s:textfield name="keyword.name" key="lbl.name" />
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveKeyword"/>
	<s:submit key="btn.cancel" action="CancelKeyword"/>
</s:form>
