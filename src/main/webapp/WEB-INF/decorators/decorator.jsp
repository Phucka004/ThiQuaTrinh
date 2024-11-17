<!DOCTYPE html>
<%@ include file ="/common/taglib.jsp"%>
<html lang="en">
<head>
<title>Test Web</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>

	<%@ include file="/common/header.jsp"%>
	<div class="main">
		<div class="container">
			<!-- Begin Content -->
			<sitemesh:write property="body" />
		</div>
		<!-- End Content -->
	</div>
	<!-- BEGIN FOOTER -->
	<%@ include file="/common/footer.jsp"%>
	<!--  END FOOTER -->

	
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- DataTables JS -->
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	

</body>
</html>
