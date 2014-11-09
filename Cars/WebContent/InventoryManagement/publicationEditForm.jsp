<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3>
	<s:text name="txt.inventoryManagement.editPublication" />
</h3>
<s:form>
	<s:actionerror />

	<%-- the list of authors of the publication --%>
	<h3>
		<s:text name="publication.authors" />
	</h3>
	<s:iterator value="publication.authors">
		<s:text name="name"></s:text>
		<br />
	</s:iterator>
	<br />
	
	<%-- the list of keywords of the publication --%>
	<h3>
		<s:text name="publication.keywords" />
	</h3>
	<s:iterator value="publication.keywords">
		<s:text name="keyword" />
		<br />
	</s:iterator>
	<br />
	
	<%-- the left attributes of publication--%>
	<s:hidden name="publicationId" />
	<s:textfield name="publication.nakId" key="publication.nakId"
		requiredLabel="true" type="int" />
	<s:textfield name="publication.title" key="publication.title"
		requiredLabel="true" />
	<s:date name="publication.dateOfPublication" id="dateOfPublication"
		format="dd.MM.yyyy" />
	<s:textfield key="publication.dateOfPublication"
		name="publication.dateOfPublication" value="%{dateOfPublication}" requiredLabel="true" />
	<s:textfield name="publication.isbn" key="publication.isbn" size="13"
		maxlength="13" />
	<s:textfield name="publication.quantity" key="publication.quantity"
		requiredLabel="true" type="int" />
	<s:label key="publication.publicationType"
		name="publication.publicationType.name" />
	<s:label key="publication.publisher"
		name="publication.publisher.publisherName" value="%{publication.publisher == null ? '' : publication.publisher.publisherName}"/>

	<%-- The buttons --%>
	<s:submit key="btn.add.keyword" align="left"
		action="ShowAddKeywordsSetup" />
	<s:submit key="btn.delete.keyword" align="left"
		action="ShowDeleteKeywordsSetup" />
	<s:submit key="btn.add.author" align="left"
		action="ShowAddAuthorsSetup" />
	<s:submit key="btn.delete.author" align="left"
		action="ShowDeleteAuthorsSetup" />
	<s:submit key="btn.edit.publicationType" align="left"
		action="SetupPublicationTypeForPublication" />
	<s:submit key="btn.edit.publisher" align="left"
		action="SetupPublisherForPublication" />
	<s:submit key="btn.save" action="SaveEditedPublication" align="left" />
	<s:submit key="btn.cancel" action="CancelPublication" align="left" />
</s:form>
