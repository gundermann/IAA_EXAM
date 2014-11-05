<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<s:form>
	<s:actionerror />
	<s:hidden name="publicationId" />

	<%-- List of publication types --%>
	<display:table id="publicationTypeTable" name="publicationTypeList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="publicationTypeId" value="${publicationTypeTable.publicationTypeId}" />
		</display:column>
		<display:column titleKey="publicationType.name" property="name" sortable="true"/>
	</display:table>


	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveEditedPublicationTypeForPublication" align="left"/>
	<s:submit key="btn.cancel" action="CancelPublication" align="left" />
</s:form>
