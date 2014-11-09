<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<h3>
	<s:text name="txt.masterDataManagement.keywords"/>
</h3>
<s:form>
	<%-- Form fields for the keyword's attributes --%>
	<s:hidden name="keyword.keywordId"/>
	<s:textfield name="keyword.keyword" key="keyword" requiredLabel="true" />
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveKeyword" align="left"/>
	<s:submit key="btn.cancel" action="CancelKeyword" align="left"/>
</s:form>
