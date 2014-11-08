<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<s:text name="txt.masterDataManagement.authors"/>
	<%-- Form fields for the author's attributes --%>
	<s:hidden name="author.authorId"/>
	<s:textfield name="author.name" key="author.name" requiredLabel="true" />
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveAuthor" align="left"/>
	<s:submit key="btn.cancel" action="CancelAuthor" align="left"/>
</s:form>
