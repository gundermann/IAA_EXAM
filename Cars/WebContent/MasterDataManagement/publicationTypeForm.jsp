<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3>
	<s:text name="txt.masterDataManagement.publicationTypes"/>
</h3>
<s:form>
<s:actionerror/>
	<%-- Form fields for the publicationtype's attributes --%>
	<s:hidden name="publicationType.publicationTypeId"/>
	<s:textfield name="publicationType.name" key="publication.publicationType" requiredLabel="true"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SavePublicationType" align="left"/>
	<s:submit key="btn.cancel" action="CancelPublicationType" align="left"/>
</s:form>
