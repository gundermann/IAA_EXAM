<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<s:form>
	<s:actionerror />
	<s:hidden name="publicationId" />
	<s:textfield name="publication.nakId" key="publication.nakId"
		requiredLabel="true" type="int" />
	<s:textfield name="publication.title" key="publication.title"
		requiredLabel="true" />
	<s:textfield name="publication.dateOfPublication"
		key="publication.dateOfPublication" size="10" maxlength="10"
		type="date" requiredLabel="true" />
	<s:textfield name="publication.isbn" key="publication.isbn" size="13"
		maxlength="13" />
	<s:textfield name="publication.quantity" key="publication.quantity"
		requiredLabel="true" type="int" />

<s:iterator value="publication.authors">
	<s:text name="name"></s:text>
	<br/>
</s:iterator>
	<s:submit key="btn.add" method="EditAuthorsOfPublication" />

	<display:table id="keywordTable" name="publication.keywords"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:column titleKey="publication.keywords" property="keyword" />
	</display:table>
	<s:submit key="btn.edit" method="EditKeywordsOfPublication" />

	<s:text name="publication.publicationType.publicationName" />
	<s:submit key="btn.edit" />

	<s:text name="publisher" />
	<s:text name="publication.publisher.publisherName" />

	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveEditedPublication" />
	<s:submit key="btn.cancel" action="CancelPublication" />
</s:form>
