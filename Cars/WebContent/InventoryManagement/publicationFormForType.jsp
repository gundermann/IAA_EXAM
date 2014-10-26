<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<s:text name="txt.setupPublicationType"/>
	<%-- Form fields for the publication's attributes --%>
	<s:select list="publicationTypeList" name="publication.publicationType" listValue="name"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.setupAuthors" action="SavePublicationAndGoToAuthor"/>
	<s:submit key="btn.cancel" action="CancelPublication"/>
</s:form>
