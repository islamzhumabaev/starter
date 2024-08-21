<!DOCTYPE html>
<html>
<head>
    <title>Bank Application</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #1A1A1D;
            color: #333333;
        }

        a {
            display: inline-block;
            padding: 15px 30px;
            font-size: 18px;
            color: #ffffff;
            background-color: #6f2232;
            text-decoration: none;
            border-radius: 21px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease;
        }

        a:hover {
            background-color: #950740;
            transform: translateY(-3px);
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2);
        }

    </style>
</head>
<body>
    <a href="${pageContext.request.contextPath}/firstPage" class="button">Go to Selection Page</a>
</body>
</html>
