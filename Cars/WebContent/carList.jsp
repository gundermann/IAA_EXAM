<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>


<s:form>
	<%-- The car table --%>
	<s:actionerror />
	<display:table id="carTable" name="carList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
		<!-- carTable.id ist die ID aus der Klasse Car -->
			<input type="radio" name="carId" value="${carTable.id}" />
		</display:column>
		<display:column titleKey="lbl.brand" property="brand" sortable="true"/>
		<display:column property="color" titleKey="lbl.color" sortable="true"/>
		<display:column property="wheelCount" titleKey="lbl.wheelCount"
			sortable="true"/>
		<display:column property="yearOfProduction"
			titleKey="lbl.yearOfProduction" sortable="true"/>
		<display:column property="isDieselEngine" titleKey="lbl.isDieselEngine"
			sortable="true"/>
	</display:table>

	<%-- The buttons --%>
	<s:submit key="btn.main" action="AddCar" />
	<s:submit key="btn.edit" action="EditCar" />
	<s:submit key="btn.delete" action="DeleteCar" />
</s:form>
