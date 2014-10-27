<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- Form fields for the publication's attributes --%>
	<s:hidden name="publication.id"/>
	<s:textfield name="publication.title" key="lbl.title" />
	<s:textfield name="publication.yearOfPublication" key="lbl.yearOfPublication" size="4" maxlength="4"/>
	<s:textfield name="publication.isbn" key="lbl.isbn" size="13" maxlength="13"/>
	<s:select list="publicationTypeList" name="publication.publicationType" listValue="name"/>
	<s:textfield name="publication.quantity" key="lbl.quantity"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.setupPublicationType" action="SetupPublicationType"/>
	<s:submit key="btn.cancel" action="CancelPublication"/>
</s:form>
