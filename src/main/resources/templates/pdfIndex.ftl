<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - PDF</title>
    <link href="http://192.168.2.105:8998/css/index.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="http://192.168.2.105:8998/lib/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="http://192.168.2.105:8998/js/pdfIndex.js"></script>
    <style>
        @page {
            size: 420mm 297mm; /*设置纸张大小:A4(210mm 297mm)、A3(297mm 420mm) 横向则反过来*/
            margin: 0.25in;
            padding: 1em;
            @bottom-center{
                content:"成都太阳高科技 © 版权所有";
                font-family: SimSun;
                font-size: 12px;
                color:red;
            };
            @top-center { content: element(header) };
            @bottom-right{
                content:"第" counter(page) "页  共 " counter(pages) "页";
                font-family: SimSun;
                font-size: 12px;
                color:#000;
            };
        }
    </style>
</head>
<body>
1.标题
<h2>${title}</h2>
2.按钮
<button class="a" style="border: 1px solid #000000"> click me t-p</button>
<div id="divsub"></div>
3.div
<div id="myheader">Alice's Adventures in Wonderland</div>
4.图片
<div id="signImg"></div>
5.表格
<div>
    <table>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>2</td>
            <td>2</td>
            <td>2</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>2</td>
            <td>2</td>
            <td>2</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>2</td>
            <td>2</td>
            <td>2</td>
        </tr>
    </table>

</div>
6.input
<div>
    <label>姓名:</label>
    <input id="input1" aria-label="dasdasd" type="text" value="123你是"/>
</div>
</body>
</html>