<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<h3><s:text name="txt.inventoryManagement.addKeyword"/></h3>
<s:form>
	<s:actionerror />
	<s:hidden name="publicationId" />

	<%-- List of keywords left in master data management--%>
	<display:table id="keywordTable" name="keywordList" 
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="basic.msg.empty_list" value="Keine Schlüsselwörter vorhanden" />
		<display:column>
			<input type="checkbox" name="keywordId" value="${keywordTable.keywordId}" />
		</display:column>
		<display:column titleKey="keyword.name" property="keyword" sortable="true"/>
	</display:table>
	
	<%-- the buttons --%>
	<s:submit key="btn.add" action="AddKeywordsToPublication" align="left"/>

</s:form>
