<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý Tác Giả</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Quản lý Tác Giả</h2>

    <!-- Nút Thêm Tác Giả -->
    <div class="text-right mb-3">
        <a href="${pageContext.request.contextPath}/admin/author/add" class="btn btn-success">Thêm Tác Giả</a>
    </div>

    <!-- Bảng hiển thị danh sách tác giả -->
    <table id="authorTable" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên Tác Giả</th>
            <th>Ngày Sinh</th>
            <th>Action</th>
        </tr>
        </thead>
    </table>
</div>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- DataTables JS -->
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
$(document).ready(function () {
    var table = $('#authorTable').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "${pageContext.request.contextPath}/admin/author",  // Update this URL if necessary
            "type": "POST"
        },
        "columns": [
            { "data": "authorId" },
            { "data": "authorName" },
            { 
                "data": "dateOfBirth",
                "render": function (data, type, row) {
                    var date = new Date(data);
                    return date.toLocaleDateString('en-GB'); // Định dạng ngày theo dd/mm/yyyy
                }
            },
            {
                "data": null,
                "orderable": false,
                "render": function (data, type, row) {
                    return '<button class="btn btn-warning update-btn" data-id="' + row.authorId + '">Cập nhật</button>' +
                           '<button class="btn btn-danger delete-btn" data-id="' + row.authorId + '">Xóa</button>';
                }
            }
        ]
    });

    // Xử lý sự kiện khi nhấn nút Cập nhật
    $('#authorTable').on('click', '.update-btn', function () {
        var authorId = $(this).data('id');
        window.location.href = "${pageContext.request.contextPath}/admin/author/edit?authorid=" + authorId;
    });

    // Xử lý sự kiện khi nhấn nút Xóa
    $('#authorTable').on('click', '.delete-btn', function () {
        var authorId = $(this).data('id');
        if (confirm("Bạn có chắc chắn muốn xóa tác giả này?")) {
            $.ajax({
                url: "${pageContext.request.contextPath}/admin/author/delete",
                type: "POST",
                data: { authorid: authorId },
                success: function (response) {
                    alert("Xóa thành công!");
                    table.ajax.reload();
                },
                error: function (xhr, status, error) {
                    alert("Có lỗi xảy ra khi xóa tác giả.");
                }
            });
        }
    });
});
</script>
</body>
</html>