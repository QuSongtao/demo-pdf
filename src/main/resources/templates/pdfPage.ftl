<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8" />
    <title>PDF模板</title>
    <script src="../static/js/echarts.min.js"></script>
    <link href="http://localhost:8999/css/index.css" rel="stylesheet" type="text/css"/>
    <style>
        @page {
            size: 210mm 297mm; /*设置纸张大小:A4(210mm 297mm)、A3(297mm 420mm) 横向则反过来*/
            margin: 0.25in;
            padding: 1em;
            @bottom-center{
                content:"成都太阳高科技有限责任公司 © 版权所有";
                font-family: FangSong_GB2312;
                font-size: 12px;
                color:red;
            };
            @top-center { content: element(header) };
            @bottom-right{
                content:"第" counter(page) "页  共 " counter(pages) "页";
                font-family: FangSong_GB2312;
                font-size: 12px;
                color:#000;
            };
        }
    </style>
</head>
<#-- 这样配置不中文不会显示 -->
<#--<body style="font-family: 宋体">-->
<body style="font-family: 'FangSong_GB2312'">
<div>1.标题-中文</div>
<h2>${cgx.title}</h2>

<div style="font-family: 'SimSun'">2.按钮:按钮的边框需要写css渲染(此处为宋体字)</div>
<button class="a" style="border: 1px solid #000000"> click me t-p</button>
<div id="divsub"></div>

<div style="font-family: 'FZHei-B01S'; font-size:22px">3.普通div(此处为方正黑体简体)</div>
<div id="myheader">Alice's Adventures in Wonderland</div>

<div>4.图片 绝对定位到左上角</div>
<div id="signImg"></div>

<div>5.普通table表格</div>
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

<div>6.图片img控件,从后端生成base64字符串动态填充</div>
<div>
    <img src="${cgx.img}"/>
</div>

</body>
</html>