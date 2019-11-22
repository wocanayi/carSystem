<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>手机验证码</title>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
</head>
<body>
<form id="codeForm">
    <input type="text" placeholder="填写手机号" name="phone">
    <%-- button标签切勿忘记写type="button" ！！！！--%>
    <button type="button" id="sendCode">获取验证码</button>
    <font id="timer" color="red"></font>
    <br>

    <input type="text" placeholder="填写验证码" name="code">
    <button type="button" id="verifyCode">确定</button>
    <font id="result" color="#00ff7f"></font>
    <font id="error" color="red"></font>
</form>
</body>
<script type="text/javascript">
    // 设定倒计时时间
    var t = 20;
    var id;

    function refer() {
        // 显示倒计时
        $("#timer").text("请于" + t + "秒内填写验证码");
        t--;
        if (t <= 0) {
            clearInterval(id);
            $("#timer").text("验证码已失效，请重新发送！");
        }
    }

    $(function() {
        $("#sendCode").click(function () {
            $.post("${pageContext.request.contextPath}/test/sendCode", $("#codeForm").serialize(), function(data) {
                if ("success" === data) {
                    // 启动1秒定时
                    id = setInterval("refer()", 1000);
                }
            });
        });

        $("#verifyCode").click(function() {
            $.post("${pageContext.request.contextPath}/test/verifyCode", $("#codeForm").serialize(), function (data) {
                if ("success" === data) {
                    $("#result").attr("color", "green");
                    $("#result").text("验证成功！");
                    clearInterval(id);
                    $("#timer").text("");
                } else {
                    $("#result").attr("color", "red");
                    $("#result").text("验证失败！");
                }
            });
        });
    });
</script>
</html>
