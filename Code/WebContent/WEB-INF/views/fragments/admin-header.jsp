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
			<a class="navbar-brand" href="#"><span class=""></span><i
				class="glyphicon glyphicon-leaf"></i><span></span> Spring Admin Page </a>
		</div>

		<div class="collapse navbar-collapse" id="cmsNavbar">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="#"><i class="glyphicon glyphicon-dashboard"></i><span></span>
						Dashboard <span class="sr-only">(current)</span></a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><i class="glyphicon glyphicon-user"></i><span></span>
						Users <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Add New</a></li>
						<li><a href="#">View All</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Roles <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Add New</a></li>
						<li><a href="#">View All</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><i class="glyphicon glyphicon-cog"></i><span></span>
						Services <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Add New</a></li>
						<li><a href="#">View All</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><i class="glyphicon glyphicon-off"></i><span></span>
						Logout</a></li>
			</ul>
		</div>
	</div>
</nav>