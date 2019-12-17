<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax::jquery::xml</title>
<script src="<%=request.getContextPath()%>/jquery/jquery-3.4.1.js"></script>
<style>
table, td, th{
    border: 1px solid;
    border-collapse: collapse;
    padding: 10px;
}
img{width: 100px;}

</style>
<script>
$(function(){
    $("#btn").click(e=>{

        $.ajax({
            url: "sample.xml",
            type: "get",
            dataType: "xml",
            success: data => {
                // console.log(data);
                var $root = $(data).find(":root");
                // console.log($root.prop("tagName"));//태그명 가져오기
                // console.log($root.attr("myattr"));//속성명 가져오기

                var $bookArr = $root.find("book");
                // console.log($bookArr);

                let fictionInfo = "<tr><td>제목</td><td>저자</td></tr>";
                let itInfo = "<tr><td>제목</td><td>저자</td></tr>";

                $bookArr.each((idx,book)=>{
                    // console.log(idx, book);
                    let html = "<tr><td>" + $(book).find("title").text() + "</td>";
                    html += "<td>"+$(book).find("author").text()+"</td>";

                    //소설인 경우
                    if($(book).find("subject").text() === '소설'){
                        fictionInfo += html;
                    }
                    //프로그래밍인 경우
                    else{
                        itInfo += html;
                    }

                });

                $("#fictionInfo").html(fictionInfo);
                $("#itInfo").html(itInfo);
            },
            error: (jqxhr,textStatus,errorThrown) => {
                console.log("ajax처리실패!",jqxhr,textStatus,errorThrown);
            }
        });
    });

    //회원정보 가져오기
    $("#btn-member").click(e =>{
        $.ajax({
            url: "<%=request.getContextPath()%>/jquery/xml/member",
            dataType: "xml",
            success: data =>{
                // console.log(data);
                var $root = $(data).find(":root");
                var $memberArr = $root.find("member");

                let memberInfo = "<tr><td>회원명</td><td>연락처</td><td>사진</td></tr>"

                $memberArr.each((idx,member)=>{
                    console.log(idx, member);
                    let html = "<tr><td>" + $(member).find("name").text() + "</td>";
                    html += "<td>"+$(member).find("phone").text()+"</td>";
                    // html += "<td>"+$(member).find("profile").text()+"</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/" + $(member).find("profile").text() + "'></td>"
                    memberInfo += html;
                });

                $("#memberInfo").html(memberInfo);
            },
            error:(jqxhr, textStatus, errorThrown) =>{
                console.log("ajax처리실패!", jqxhr,textStatus, errorThrown)
            }
        });
    });



});
</script>
</head>
<body>
    <h1>ajax::jquery::xml</h1>
    <button id="btn">실행</button>
    <div id="fiction">
        <h3>소설</h3>
        <table id="fictionInfo"></table>
    </div>


    <div id="fiction">
        <h3>프로그래밍</h3>
        <table id="itInfo"></table>
    </div>

    <hr>

    <button id="btn-member">실행</button>
    <div id="member-container">
        <h3>회원정보</h3>
        <table id="memberInfo"></table>
    </div>

</body>
</html>