<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#cmsNavbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><span class=""></span>CMS </a>
		</div>

		<div class="collapse navbar-collapse" id="cmsNavbar">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="#"><i class="glyphicon glyphicon-home"></i><span></span>
						Home <span class="sr-only">(current)</span></a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Insurances <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Create Insurance</a></li>
						<li><a href="#">Edit Insurance</a></li>
						<li><a href="#">Something else here</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Damages <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Declare Damage</a></li>
						<li><a href="#">Edit Damage Declaration</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Damage Approval <span class="badge">0</span></a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><i class="glyphicon glyphicon-blackboard"></i><span></span>
						 Statistics</a></li>
				<li><a href="#"><i class="glyphicon glyphicon-off"></i><span></span>
						Logout</a></li>
			</ul>
		</div>
	</div>
</nav>