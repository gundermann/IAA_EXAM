<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3><s:text name="lbl.kindOfPublicationList"/></h3>
<s:form>
	<s:actionerror/>
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
	
	<s:submit key="btn.add" action="AddPublicationType"/>
	<s:submit key="btn.delete" action="DeletePublicationType"/>
	<s:submit key="btn.edit" action="EditPublicationType"/>
</s:form>