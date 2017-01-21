<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="role" value="Employee" />
<sec:authorize access="hasAuthority('Damage Approval 300-2000')">
	<c:set var="role" value="Sales Manager" />
</sec:authorize>
<sec:authorize access="hasAuthority('Damage Approval more than 2000')">
	<c:set var="role" value="CEO" />
</sec:authorize>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<form id="logoutForm" method="POST" action="${contextPath}/logout">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$
									.ajax({
										type : "get",
										url : "<spring:url value="/cms/damage/formCount/${role}"></spring:url>",
										success : function(msg) {
											$('#badge').text(msg);
										}
									});
						});
	</script>
</c:if>
<div class="container-fluid">
<div class="row text-center">
	<img style="margin-top:20px; margin-bottom:20px;" class="col-xs-3 col-xs-offset-4" alt="CARINS logo" src='<spring:url value="/resources/images/LOGONAME.png"/>'>
</div>
</div>
<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#cmsNavbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="<spring:url value="/cms/home"></spring:url>"><span></span>CMS
			</a>
		</div>

		<div class="collapse navbar-collapse" id="cmsNavbar">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="<spring:url value="/cms/home"></spring:url>"><i
						class="glyphicon glyphicon-home"></i><span></span> Home <span
						class="sr-only">(current)</span></a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><i class="glyphicon glyphicon-briefcase"></i><span></span>
						Insurances <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="<spring:url value="/cms/insurance/findVehicle"></spring:url>">Create
								Insurance</a></li>
						<li><a
							href="<spring:url value="/cms/insurance/view"></spring:url>">View
								All</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><i class="glyphicon glyphicon-list-alt"></i><span></span>
						Damages <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="<spring:url value="/cms/insurance/view"></spring:url>">Declare
								Damage</a>
						<li><a
							href="<spring:url value="/cms/damage/view"></spring:url>">Damage
								History</a></li>
						<sec:authorize
							access="hasAnyAuthority('Damage Approval less than 300','Damage Approval 300-2000', 'Damage Approval more than 2000')">
							<li role="separator" class="divider"></li>
							<li><a
								href="<spring:url value="/cms/damage/view/specific"/>">Damage
									Approval <span id=badge class="badge"
									style="background-color: red;">0</span>
							</a></li>
						</sec:authorize>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<!-- <li><a href="#"><i class="glyphicon glyphicon-blackboard"></i><span></span>
						Statistics</a></li> -->
				<li><a onclick="document.forms['logoutForm'].submit()"
					style="cursor: pointer;"><i class="glyphicon glyphicon-off"></i><span></span>
						<sec:authentication property="principal.username" />, Logout</a></li>
			</ul>
		</div>
	</div>
</nav>