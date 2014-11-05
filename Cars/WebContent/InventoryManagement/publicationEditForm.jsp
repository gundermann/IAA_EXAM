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
		
	<s:text name="publication.authors"/>
	<s:iterator value="publication.authors">
		<s:text name="name"></s:text>
		<br />
	</s:iterator>
	
	<s:text name="publication.keywords"/>
	<s:iterator value="publication.keywords">
		<s:text name="keyword"/>
	</s:iterator>
	<s:submit key="btn.add.keyword" align="left" action="AddKeywordsForPublication"/>
	<s:submit key="btn.delete.keyword" align="left" action="DeleteKeywordsForPublication"/>

	<s:label key="publication.publicationType"/>
	<s:label name="publication.publicationType.name" />
	<s:submit key="btn.edit.publicationType" align="left" action="SetupPublicationTypeForPublication"/>

	<s:label key="publication.publisher" name="publication.publisher.publisherName" />
	<s:submit key="btn.edit.publisher" align="left" action="SetupPublisherForPublication"/>


	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveEditedPublication" align="left"/>
	<s:submit key="btn.cancel" action="CancelPublication" align="left" />
</s:form>
