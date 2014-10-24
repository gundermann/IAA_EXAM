<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- Form fields for the publicationtype's attributes --%>
	<s:hidden name="publicationType.publicationTypeId"/>
	<s:textfield name="publicationType.name" key="lbl.publicationType.name" requiredLabel="true"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SavePublicationType"/>
	<s:submit key="btn.cancel" action="CancelPublicationType"/>
</s:form>
