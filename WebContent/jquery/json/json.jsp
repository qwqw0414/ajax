<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax::jquery::json</title>
<script src="<%=request.getContextPath()%>/jquery/jquery-3.4.1.js"></script>
<style>
.area{
    border: 1px solid red;
    width: 300px;
    min-height: 50px;
    margin: 10px;
    padding: 10px;
}
table, td{
    border: 1px solid;
    border-collapse: collapse;
}
img{width: 100px;}
</style>
</head>
<body>
    <h1>ajax::jquery::json</h1>
    <h2>1.전체 회원 조회</h2>
    <button id="btn1">실행</button>
    <div id="area1" class="area"></div>

    <script>
    $("#btn1").click(e =>{
        $.ajax({
            url:"<%=request.getContextPath()%>/jquery/json/member/selectAll",
            type: "get",
            dataType: "json",
            success: data =>{
                console.log(data);//json문자열, javascript,

                let $table = $("<table></table>");

                $(data).each((idx,member)=>{
                    let html = "<tr><td>"+member.name+"</td>";
                    html += "<td>"+member.phone+"</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/"+member.profile+"'></td></tr>";
                    $table.append(html);
                });

                $("#area1").html($table);
            },
            error : (jqxhr, textStatus, errorThrown)=>{
                console.log(jqxhr,textStatus, errorThrown);
            }

        });
    });
    </script>

    <h2>@실습문제: 이름 검색 /jquery/json/member/searchName</h2>
    <input type="search" id="srchName" placeholder="이름">
    <button id="btn2">검색</button>
    <div id="area2" class="area"></div>
    <script>
    $("#btn2").click(e =>{
        var srchNameVal = $("#srchName").val();

        if(srchNameVal.length == 0) return;

        $.ajax({
            url:"<%=request.getContextPath()%>/jquery/json/member/searchName",
            type: "get",
            data: { srchName: srchNameVal },
            dataType: "json",
            success: data =>{
                let $table = $("<table></table>");

                $(data).each((idx,member)=>{
                    let html = "<tr><td>"+member.name+"</td>";
                    html += "<td>"+member.phone+"</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/"+member.profile+"'></td></tr>";
                    $table.append(html);
                });

                $("#area2").html($table);
            },
            error : (jqxhr, textStatus, errorThrown)=>{
                console.log(jqxhr,textStatus, errorThrown);
            }

        });
    });
    </script>

    <h2>@실습문제: 회원가입 /jquery/json/member/insertMember</h2>
    <p>MemberSingleton.list에 회원을 추가하고, 추가된 목록을 리턴받아 #area3에 출력</p>
    <input type="text" id="name" placeholder="이름"><br>
    <input type="text" id="phone" placeholder="전화번호"><br>
    <input type="text" id="profile" placeholder="프로필"><br>
    <button id="btn3">회원가입</button>
    <div class="area" id="area3"></div>
    <script>
    $("#btn3").click(e =>{
        var name = $("#name").val();
        var phone = $("#phone").val();
        var profile = $("#profile").val();

        if(name.length == 0) return;
        if(phone.length == 0) return;
        if(profile.length == 0) return;

        $.ajax({
            url:"<%=request.getContextPath()%>/jquery/json/member/insertMember",
            type: "post",
            data: { name: name,
                    phone: phone,
                    profile: profile },
            dataType: "json",
            success: data =>{
                let $table = $("<table></table>");

                $(data).each((idx,member)=>{
                    let html = "<tr><td>"+member.name+"</td>";
                    html += "<td>"+member.phone+"</td>";
                    html += "<td><img src='<%=request.getContextPath()%>/images/"+member.profile+"'></td></tr>";
                    $table.append(html);
                });

                $("#area3").html($table);
            },
            error : (jqxhr, textStatus, errorThrown)=>{
                console.log(jqxhr,textStatus, errorThrown);
            }

        });
    });
    </script>
</body>
</html>