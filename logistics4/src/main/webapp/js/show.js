window.onload = function (){
    //1创建XMLHttpRequest对象
    let xml=new XMLHttpRequest();
    //建立连接
    xml.open("get","ShowCakeServlet",true);
    //设置回调函数
    xml.onreadystatechange=function(){
        /*
        	readyState ==4:判断request已完成(可以访问服务器)
    		status==200:判断request是否执行成功
        */
        if (this.readyState == 4 && this.status == 200) {
            let vals=xml.responseText;

            console.log(vals);
            let jsonArr=eval(vals);
            let temp='';
            let tbody=document.getElementsById("cakeData");
            for (let cake of jsonArr){
                temp+=
                    '<tr>'+
                    '<td>' + user.userId + '</td>' +
                    '<td>' + user.userName + '</td>' +
                    '<td>' + user.userSex + '</td>' +
                    '<td>' + user.userAge + '</td>' +
                    '</tr>';

            }
            tbody.innerHTML=temp;
        }
    }

    //发送数据
    xml.send(null);

}
