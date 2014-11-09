<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.inventoryManagement.deleteAuthor"/></h3>
<s:form>
	<s:actionerror />
	<s:hidden name="publicationId" />

	<%-- List of author form the publication--%>
	<display:table id="authorTable" name="publication.authorList" 
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="basic.msg.empty_list" value="Keine Autoren vorhanden" />
		<display:column>
			<input type="checkbox" name="authorId" value="${authorTable.authorId}" />
		</display:column>
		<display:column titleKey="author.name" property="author" sortable="true"/>
	</display:table>
	<s:submit key="btn.delete" action="DeleteAuthorsFromPublication" align="left"/>

</s:form>
