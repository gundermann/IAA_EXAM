<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<h3>
	<s:text name="txt.inventoryManagement.addPublication" />
</h3>
<s:form>
	<s:actionerror />
	<%-- the attributes to setup form publication--%>
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

	<%-- the table of publication types from master data management --%>
	<display:table id="publicationTypeTable" name="publicationTypeList"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="basic.msg.empty_list"
			value="Keine Publikationsarten vorhanden" />
		<display:column>
			<input type="radio" name="publicationTypeId"
				value="${publicationTypeTable.publicationTypeId}" />
		</display:column>
		<display:column title="Publikationsart" property="name" />
	</display:table>

	<%-- the table of authors from master data management --%>
	<display:table id="authorTable" name="authorList" cellpadding="5px;"
		cellspacing="5px;" style="margin-left:50px;margin-top:20px;"
		requestURI="#">
		<display:setProperty name="basic.msg.empty_list"
			value="Keine Autoren vorhanden" />
		<display:column>
			<input type="checkbox" name="authorId"
				value="${authorTable.authorId}" />
		</display:column>
		<display:column title="Autoren" property="name" />
	</display:table>

	<%-- the table of keywords from master data management --%>
	<display:table id="keywordTable" name="keywordList" cellpadding="5px;"
		cellspacing="5px;" style="margin-left:50px;margin-top:20px;"
		requestURI="#">
		<display:setProperty name="basic.msg.empty_list"
			value="Keine Schlüsselwörter vorhanden" />
		<s:set name="id" value="%{keywordTable.keywordId}" />
		<display:column>
			<input type="checkbox" name="keywordId"
				value="${keywordTable.keywordId}" />
		</display:column>
		<display:column title="Schlüsselwörter" property="keyword" />
	</display:table>

	<%-- the table of publishers from master data management --%>
	<display:table id="publisherTable" name="publisherList"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="basic.msg.empty_list"
			value="Keine Verlage vorhanden" />
		<display:column>
			<input type="radio" name="publisherId"
				value="${publisherTable.publisherId}" />
		</display:column>
		<display:column title="Verlag" property="publisherName" />
	</display:table>

	<%-- The buttons --%>
	<s:submit key="btn.save" action="SavePublication" align="left" />
	<s:submit key="btn.cancel" action="CancelPublication" align="left" />
</s:form>
