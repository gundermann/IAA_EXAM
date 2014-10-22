<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<style type="text/css">

/* for hiding the page banner */
.pagebanner 
{
        display: none;
}
/* for customizing page links */
.pagelinks 
{
        color: maroon;
        margin: 20px 0px 20px 50px;
}
/* for shifting all the Export options*/
.exportlinks 
{
        margin: 20px 0px 20px 30px;
}
/* For changing the spaces between export link */
.export 
{
        margin-left: 30px;
}
/* For Table css */
table 
{
        border: 1px solid #666;
        width: 60%;
        margin: 20px 0 20px 0px;
}
/* For odd and even row decoration */
tr.odd 
{
        background-color: #fff
}
tr.tableRowEven,tr.even 
{
        background-color: #CCCCCC
}
/* Css for table elements */
th,td 
{
        padding: 2px 4px 2px 4px;
        text-align: left;
        vertical-align: top;
}
thead tr 
{
        background-color: #999999;
}
/* For changing the background colour while sorting */
th.sorted 
{
        background-color: #CCCCCC;
}
th.sorted a
{
        background-position: right;
        display: block;
        width: 100%;
}
th.sortable a {
	background-image: url(img/arrow_off.png);
    background-repeat: no-repeat;
    background-position: right;
        display: block;
        width: 100%;
}

th.order1 a {
	background-image: url(img/arrow_down.png);
    background-repeat: no-repeat;
}

th.order2 a {
	background-image: url(img/arrow_up.png);
    background-repeat: no-repeat;
}
th a:hover 
{
        text-decoration: underline;
        color: black;
}
th a,th a:visited 
{
        color: black;
}
</style>


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