<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.admonitionManagement"/></h3>
<s:form>
	<s:actionerror/>
	<s:text name="txt.admonitionProcesses"/>
	<%-- list of admonition processes--%>
	<display:table id="admonitionProcessTable" name="admonitionProcessList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;" 
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="admonitionProcessId" value="${admonitionProcessTable.admonitionProcessId}" />
		</display:column>
		<display:column title="Publikation" property="lending.publication.title" sortable="true"/>
		<display:column title="Rückgabedatum" property="lending.expectedReturnDate" sortable="true" format="{0,date,dd.MM.yyyy}"/>
		<display:column title="Anzahl der Mahnungen" value="${admonitions.size()==null ? 0 : admonitons.size()}" sortable="true"/>
	</display:table>
	
	
	<s:submit key="btn.finish" action="FinishAdmonitionProcess" align="left"/>
	<s:submit key="btn.addAdmonition" action="AddAdmonition" align="left"/>
</s:form>