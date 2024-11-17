<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Sách</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Danh sách Sách</h2>
    <table id="bookTable" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>Book ID</th>
            <th>Book Name</th>
            <th>Description</th>
            <th>Action</th> <!-- Cột dành cho nút Chi tiết -->
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
        $('#bookTable').DataTable({
            "processing": true,            // Hiển thị biểu tượng tải
            "serverSide": true,            // Bật tính năng xử lý phía server
            "ajax": {
                "url": "/JPA-KT/book", // URL của Servlet
                "type": "POST"
            },
            "columns": [
                {"data": "bookid"},        // ID sách
                {"data": "title"},         // Tên sách
                {"data": "description"},   // Mô tả sách
                {
                    "data": null,
                    "orderable": false,
                    "render": function (data, type, row) {
                        console.log("Row data:", row.bookid); // Kiểm tra dữ liệu của từng hàng
                        return '<button class="detail-btn" data-id=' + row.bookid + ' > Chi tiết </button>';
                    }
                }  // Cột Action với nút Chi tiết
            ]
        });

     // Xử lý sự kiện khi nhấn nút Chi tiết
        $('#bookTable').on('click', '.detail-btn', function () {
            var bookId = $(this).data('id'); // Lấy bookId từ thuộc tính data-id
            // Thực hiện hành động khi bấm nút Chi tiết, ví dụ hiển thị thông tin chi tiết
            //alert("Xem chi tiết sách với ID: " + bookId);
            // Hoặc chuyển hướng tới trang chi tiết sách
            window.location.href = "/JPA-KT/book-details?bookid=" + bookId;
        });
        
    });
</script>

</body>
</html>
