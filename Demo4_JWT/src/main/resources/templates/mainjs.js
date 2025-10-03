$(document).ready(function () {
    // Hiển thị thông tin người dùng đăng nhập thành công
    $.ajax({
        type: 'GET',
        url: '/users/me',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        beforeSend: function (xhr) {
            if (localStorage.token) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.token);
            }
        },
        success: function (data) {
            // In ra JSON debug
            var json = JSON.stringify(data, null, 4);
            console.log(json);

            // Hiển thị tên đầy đủ
            $('#profile').html(data.fullName);

            // Hiển thị ảnh đại diện
            document.getElementById("images").src = data.images;
        },
        error: function (e) {
            console.log("ERROR : ", e);
            alert("Sorry, you are not logged in.");
        }
    });

    // Hàm đăng xuất
    $('#Logout').click(function () {
        localStorage.clear();
        window.location.href = "/login";
    });

    // Hàm đăng nhập
    $('#Login').click(function () {
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;

        var basicInfo = JSON.stringify({
            email: email,
            password: password
        });

        $.ajax({
            type: "POST",
            url: "/auth/login",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: basicInfo,
            success: function (data) {
                // Lưu token vào localStorage
                localStorage.token = data.token;

                alert("Got a token from the server! Token: " + data.token);

                // Chuyển hướng sang trang profile
                window.location.href = "/user/profile";
            },
            error: function () {
                alert("Login Failed");
            }
        });
    });
});
