<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<s:form>
	<%-- Form fields for the publication's attributes --%>
	<!-- 
	<s:hidden name="publication.id" />
	<s:hidden name="publication.keywords"/>
	<s:hidden name="publication.title"/>
	<s:hidden name="publication.yearOfPublication"/>
	<s:hidden name="publication.isbn"/>
	<s:hidden name="publication.publicationType"/>
	<s:hidden name="publication.quantity" key="lbl.quantity" />
	 -->
	
	<display:table id="authorInPublicationTable" name="publication.authors" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="checkbox" name="authorId" value="${authorInPublicationTable.authorId}" />
		</display:column>
		<display:column titleKey="author.name" property="name" sortable="true"/>
	</display:table>
	
	<s:submit key="btn.add" action="AddAuthorToPublication"/>
	
	<display:table id="authorTable" name="authorList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="checkbox" name="authorId" value="${authorTable.authorId}" />
		</display:column>
		<display:column titleKey="author.name" property="name" sortable="true"/>
	</display:table>
	
	
	<%-- The buttons --%>
	<s:submit key="btn.setupKeyword" action="SavePublicationAndGoToKeyword"/>
	<s:submit key="btn.cancel" action="CancelPublication"/>
</s:form>
