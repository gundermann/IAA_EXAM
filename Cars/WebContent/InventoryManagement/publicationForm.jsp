<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- Form fields for the publication's attributes --%>
	<s:hidden name="publication.id"/>
	<s:textfield name="publication.title" key="lbl.title" />
	<s:textfield name="publication.authors" key="lbl.authors" />
	<s:textfield name="publication.yearOfPublication" key="lbl.yearOfPublication" size="4" maxlength="4"/>
	<s:textfield name="publication.type" key="lbl.kindOfPublication"/>
	<s:textfield name="publication.isbn" key="lbl.isbn" size="13" maxlength="13"/>
	<s:textfield name="publication.buzzwords" key="lbl.keywords"/>
	<s:textfield name="publication.quantity" key="lbl.quantity"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SavePublication"/>
	<s:submit key="btn.cancel" action="CancelPublication"/>
</s:form>
