<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.inventoryManagement.addAuthor"></s:text></h3>
<s:form>
	<s:actionerror />
	<s:hidden name="publicationId" />

	<%-- List of authors left in master data management--%>
	<display:table id="authorTable" name="authorList" 
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="basic.msg.empty_list" value="Keine Autoren vorhanden" />
		<display:column>
			<input type="checkbox" name="authorId" value="${authorTable.authorId}" />
		</display:column>
		<display:column titleKey="author.name" property="name" sortable="true"/>
	</display:table>
	
	<%-- the buttons --%>
	<s:submit key="btn.add" action="AddAuthorsToPublication" align="left"/>

</s:form>
