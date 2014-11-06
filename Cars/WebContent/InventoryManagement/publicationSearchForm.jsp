<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3><s:text name="txt.search" /></h3>
<s:form>
	<s:actionerror/>
	<%-- Form fields for the publication's attributes --%>
	<s:textfield name="publication.nakId" key="lbl.nakId"/>
	<s:textfield name="publication.title" key="lbl.title" />
	<s:textfield name="publication.authors" key="lbl.authors" />
	<s:textfield name="publication.dateOfPublication" key="lbl.dateOfPublication" size="4" maxlength="4"/>
	<s:textfield name="publication.publicationType" key="lbl.publicationType"/>
	<s:textfield name="publication.isbn" key="lbl.isbn" size="13" maxlength="13"/>
	<s:textfield name="publication.keywords" key="lbl.keywords"/>

	<%-- The buttons --%>
	<s:submit key="btn.search" action="FindPublication" align="left"/>
</s:form>