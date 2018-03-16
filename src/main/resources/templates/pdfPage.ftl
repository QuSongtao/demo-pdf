<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - PDF</title>
    <link href="http://localhost:8999/css/index.css" rel="stylesheet" type="text/css"/>
    <style>
        @page {
            size: 210mm 297mm; /*设置纸张大小:A4(210mm 297mm)、A3(297mm 420mm) 横向则反过来*/
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
<body style="font-family: 宋体">
<div>1.标题-中文</div>
<h2>${title}</h2>

<div>2.按钮:按钮的边框需要写css渲染</div>
<button class="a" style="border: 1px solid #000000"> click me t-p</button>
<div id="divsub"></div>

<div>3.普通div</div>
<div id="myheader">Alice's Adventures in Wonderland</div>

<div>4.图片 绝对定位到左上角(注意:图片必须用全路径或者http://开头的路径,否则无法显示)</div>
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

<div>6.input控件,边框需要写css渲染 (在模板中一般不用input,因为不存在输入操作)</div>
<div>
    <label>姓名:</label>
    <input id="input1" aria-label="dasdasd" type="text" value="123你是"/>
</div>
</body>
</html>