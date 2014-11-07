<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3><s:text name="txt.search" /></h3>
<s:form>
	<s:actionerror/>
	<%-- Form fields for the criteria's attributes --%>
	<s:textfield name="criteria.nakId" key="publication.nakId"/>
	<s:textfield name="criteria.title" key="publication.title" />
	<s:textfield name="criteria.authors" key="publication.authors" />
	<s:date name="criteria.dateOfPublication" id="dateOfPublication"
		format="dd.MM.yyyy" />
	<s:textfield key="publication.dateOfPublication"
		name="criteria.dateOfPublication" value="%{dateOfPublication}" />
	<s:textfield name="criteria.publicationType" key="publication.publicationType"/>
	<s:textfield name="criteria.isbn" key="publication.isbn" size="13" maxlength="13"/>
	<s:textfield name="criteria.keywords" key="publication.keywords"/>
	<s:textfield name="criteria.publisher" key="publication.publisher"/>

	<%-- The buttons --%>
	<s:submit key="btn.search" action="FindPublication" align="left"/>
</s:form>