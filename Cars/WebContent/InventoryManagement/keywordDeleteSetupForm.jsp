<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<s:form>
	<s:actionerror />
	<s:hidden name="publicationId" />

	<%-- List of publication types left in master data management--%>
	<display:table id="keywordTable" name="keywordList" 
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:column>
			<input type="checkbox" name="keywordId" value="${keywordTable.keywordId}" />
		</display:column>
		<display:column titleKey="keyword.name" property="keyword" sortable="true"/>
	</display:table>
	<s:submit key="btn.add" action="DeleteKeywordsToPublication" align="left"/>

</s:form>
