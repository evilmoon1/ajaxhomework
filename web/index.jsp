<%--
  Created by IntelliJ IDEA.
  User: 99739
  Date: 2020/8/11
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>

    <script type="text/JavaScript">
        function postData(){
            var message = $('#message').val();
            var dataString = 'message=' + message ;
            $.ajax({
                type: "POST",
                url: "/message",
                data: dataString,
                success: function(data) {
                    console.log('OK: ' + data);
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    console.log('Error: ' + data);
                }
            });
            return true;
        }
        $(document).ready(function(){
            $(".button").click(function() {
                if(postData()){
                    $('#messages').load("/message");
                };
                return false;
            });
        });
    </script>
    <script type="text/javascript">
        $(function(){
            $("#great").click(function(){
                //1.接受参数
               var num = $("#num").val();
               // $("#num").text(num);
                $.get("/likeplus","num="+num,function (result) {
                    $("#num").html(result);
                });
            });
        })
    </script>
</head>
<body>
<form>
    <span id="great" name = "0" value="0">点赞</span><br/>
    点赞数：<span id="num"></span><br/>
    <button>提交</button>
</form>
<%--username:<input type="text" id ="uname">--%>
    <div id="stylized" class="myform">
        <form id="form" name="form" action="#" method="post">

            <h1>Post your message</h1>
            <label>Message</label><br/>
            <span class="small">yourMessage</span></label>
            <textarea name="message" id="message"></textarea><br/><br/>
            <button type="submit" class="button">Submit</button><br/>
            <div class="spacer"></div>
        </form>
    </div>
    <div style="float: left">
        <div id="messages" class="messages">
            <!-- posted messages display here -->
        </div>
    </div>
</body>
</html>
