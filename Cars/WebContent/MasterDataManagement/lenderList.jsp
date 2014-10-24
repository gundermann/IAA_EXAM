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
		<display:column titleKey="lender.firstname" property="firstname" sortable="true"/>
		<display:column titleKey="lender.lastname" property="lastname" sortable="true"/>
	</display:table>
	
	<!-- 
	<%-- Liste von Publikationsarten --%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th></th>
			<th><s:text name="lbl.publicationType"/></th>
		</tr>
		<s:iterator value="publicationTypeList">
			<tr>
				<td><s:radio name="publicationTypeId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="publicationType"/></td>
			</tr>
		</s:iterator>
	</table>
	 -->
	
	<s:submit key="btn.add" action="AddLender"/>
	<s:submit key="btn.delete" action="DeleteLender"/>
	<s:submit key="btn.edit" action="EditLender"/>
</s:form>