<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3><s:text name="txt.search" /></h3>
<s:form>
	<s:actionerror/>
	<%-- Form fields for the publication's attributes --%>
	<s:textfield name="publication.id" key="lbl.id"/>
	<s:textfield name="publication.title" key="lbl.title" />
	<s:textfield name="publication.authors" key="lbl.authors" />
	<s:textfield name="publication.yearOfPublication" key="lbl.yearOfPublication" size="4" maxlength="4"/>
	<s:textfield name="publication.kindOfPublication" key="lbl.kindOfPublication"/>
	<s:textfield name="publication.isbn" key="lbl.isbn" size="13" maxlength="13"/>
	<s:textfield name="publication.keyword" key="lbl.keywords"/>

	<%-- The buttons --%>
	<s:submit key="btn.search" action="SearchPublication"/>
</s:form>