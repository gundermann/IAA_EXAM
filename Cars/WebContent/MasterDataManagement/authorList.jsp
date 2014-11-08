<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.masterDataManagement.authors"/></h3>
<s:form>
	<s:actionerror/>
	<%-- List of authors --%>
	<display:table id="authorTable" name="authorList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:setProperty name="basic.msg.empty_list" value="Keine Autoren vorhanden" />
		<display:column>
			<input type="radio" name="authorId" value="${authorTable.authorId}" />
		</display:column>
		<display:column title="Name" property="name" sortable="true"/>
	</display:table>

	<s:submit key="btn.add" action="AddAuthor" align="left"/>
	<s:submit key="btn.delete" action="DeleteAuthor" align="left"/>
	<s:submit key="btn.edit" action="EditAuthor" align="left"/>
</s:form>