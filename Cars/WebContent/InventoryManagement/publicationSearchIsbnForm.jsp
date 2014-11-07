<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3><s:text name="txt.search.isbn" /></h3>
<s:form>
	<s:actionerror/>
	<%-- Form fields for the criteria's isbn attribute --%>
	<s:textfield name="criteria.isbn" key="publication.isbn" size="13" maxlength="13"/>

	<%-- The buttons --%>
	<s:submit key="btn.search" action="FindPublicationByIsbn" align="left"/>
</s:form>