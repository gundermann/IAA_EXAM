<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
	<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<s:form>
	<s:actionerror/>
	<%-- list of lenders --%>
	<display:table id="lenderTable" name="lenderList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="lenderId" value="${lenderTable.lenderId}" />
		</display:column>
		<display:column titleKey="lender.matrikelnumber" property="matrikelnumber" sortable="true"/>
		<display:column titleKey="lender.firstname" property="firstName" sortable="true"/>
		<display:column titleKey="lender.lastname" property="lastName" sortable="true"/>
	</display:table>
	
	<s:submit key="btn.add" action="AddLender"/>
	<s:submit key="btn.delete" action="DeleteLender"/>
	<s:submit key="btn.edit" action="EditLender"/>
</s:form>