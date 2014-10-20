<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3><s:text name="lbl.kindOfPublicationList"/></h3>
<s:form>
	<s:actionerror/>
	<%-- Liste von Publikationsarten --%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th></th>
			<th><s:text name="btn.kindOfPublication"/></th>
		</tr>
		<s:iterator value="kindOfPublicationList">
			<tr>
				<td><s:radio name="kindOfPublicationId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="kindOfPublication"/></td>
			</tr>
		</s:iterator>
	</table>
	
	<s:submit key="btn.add" action="AddKindOfPublication"/>
	<s:submit key="btn.delete" action="DeleteKindOfPublication"/>
	<s:submit key="btn.edit" action="EditKindOfPublication"/>
</s:form>