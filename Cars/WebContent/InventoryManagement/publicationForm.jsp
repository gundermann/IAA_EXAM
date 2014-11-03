<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<s:form>
	<s:hidden name="publication.publicationId" />
	<s:textfield name="publication.nakId" key="publication.nakId"/>
	<s:textfield name="publication.title" key="lbl.title" />
	<s:textfield name="publication.dateOfPublication"
		key="lbl.dateOfPublication" size="4" maxlength="4" />
	<s:textfield name="publication.isbn" key="lbl.isbn" size="13"
		maxlength="13" />

	<s:textfield name="publication.quantity" key="lbl.quantity" />

	<display:table id="publicationTypeTable" name="publicationTypeList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="publicationTypeId"
				value="${publicationTypeTable.publicationTypeId}" />
		</display:column>
		<display:column titleKey="publicationType.name" property="name"/>
	</display:table>

	<display:table id="authorTable" name="authorList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="checkbox" name="authorId"
				value="${authorTable.authorId}" />
		</display:column>
		<display:column titleKey="author.name" property="name"/>
	</display:table>
	
	<display:table id="keywordTable" name="keywordList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="checkbox" name="keywordId"
				value="${keywordTable.keywordId}" />
		</display:column>
		<display:column titleKey="keyword" property="keyword"/>
	</display:table>

	<display:table id="publisherTable" name="publisherList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="publisherId"
				value="${publisherTable.publisherId}" />
		</display:column>
		<display:column titleKey="publisher.name" property="publisherName"/>
	</display:table>
	<%-- The buttons --%>
	<s:submit key="btn.setupAuthors" action="SavePublication" />
	<s:submit key="btn.cancel" action="CancelPublication" />
</s:form>
