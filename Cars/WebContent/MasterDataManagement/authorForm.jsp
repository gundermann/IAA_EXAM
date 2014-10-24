<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- Form fields for the author's attributes --%>
	<s:hidden name="author.authorId"/>
	<s:textfield name="author.name" key="lbl.name" />
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveAuthor"/>
	<s:submit key="btn.cancel" action="CancelAuthor"/>
</s:form>
