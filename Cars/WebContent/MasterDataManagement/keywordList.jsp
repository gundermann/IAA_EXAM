<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.masterDataManagement.keywords"/></h3>
<s:form>

	<s:actionerror/>
	<%-- List of keywords --%>
	<display:table id="keywordTable" name="keywordList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:setProperty name="basic.msg.empty_list" value="Keine Schlüsselwörter vorhanden" />
		<display:column>
			<input type="radio" name="keywordId" value="${keywordTable.keywordId}" />
		</display:column>
		<display:column titleKey="keyword" property="keyword" sortable="true"/>
	</display:table>
	
	<s:submit key="btn.add" action="AddKeyword"/>
	<s:submit key="btn.delete" action="DeleteKeyword"/>
	<s:submit key="btn.edit" action="EditKeyword"/>
</s:form>