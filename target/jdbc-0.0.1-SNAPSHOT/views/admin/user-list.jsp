<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý User</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Quản lý User</h2>

    <!-- Nút Thêm người dùng -->
    <div class="text-right mb-3">
        <a href="${pageContext.request.contextPath}/admin/user/add" class="btn btn-success">Thêm người dùng</a>
    </div>

    <!-- Bảng hiển thị danh sách người dùng -->
    <table id="userTable" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Full Name</th>
            <th>Phone</th>
            <th>Admin</th>
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
    $('#userTable').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/JPA-KT/admin/user",  // Đảm bảo URL này chính xác
            "type": "POST"
        },
        "columns": [
            { "data": "id" },
            { "data": "email" },
            { "data": "fullname" },
            { "data": "phone" },
            {
                "data": "is_admin",
                "render": function (data, type, row) {
                    return data ? "Yes" : "No";
                }
            },
            {
                "data": null,
                "orderable": false,
                "render": function (data, type, row) {
                    return '<button class="btn btn-warning update-btn" data-id="' + row.id + '">Cập nhật</button>' +
                        '<button class="btn btn-danger delete-btn" data-id="' + row.id + '">Xóa</button>';
                }
            }
        ]
    });

        // Xử lý sự kiện khi nhấn nút Chi tiết
        $('#userTable').on('click', '.detail-btn', function () {
            var userId = $(this).data('id');
            alert("Xem chi tiết user với ID: " + userId);
        });

        // Xử lý sự kiện khi nhấn nút Cập nhật
        $('#userTable').on('click', '.update-btn', function () {
            var userId = $(this).data('id');
            window.location.href = "${pageContext.request.contextPath}/admin/user/edit?userid=" + userId;
        });

        // Xử lý sự kiện khi nhấn nút Xóa
        $('#userTable').on('click', '.delete-btn', function () {
            var userId = $(this).data('id');
            if (confirm("Bạn có chắc chắn muốn xóa user này?")) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/admin/user/delete",
                    type: "POST",
                    data: { userid: userId },
                    success: function (response) {
                        alert("Xóa thành công!");
                        table.ajax.reload();
                    },
                    error: function (xhr, status, error) {
                        alert("Có lỗi xảy ra khi xóa user.");
                    }
                });
            }
        });
    });
</script>
</body>
</html>
