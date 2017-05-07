
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="../center/css/pintuer.css">
    <link rel="stylesheet" href="../center/css/admin.css">
    <script src="../center/js/jquery.js"></script>
    <script src="../center/js/pintuer.js"></script>
</head>
<body>

<script>
    /*var data;
    $(document).ready(function () {
        $.ajax({
            type: "post",
            url: "/server/getAllConfiguration",
            success: function (ev) {
                if (ev.code == 200) {
                    data = ev.data;
                } else {
                    alert(ev.message);
                }
            }
        });
    })*/
</script>


<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 配置管理</strong></div>
        <div class="padding border-bottom">
            <ul class="search">
                <li>
                    <button type="button" class="button border-green" id="checkall"><span class="icon-check"></span> 全选
                    </button>
                    <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="150">ID</th>
                <th>最后更新时间</th>
                <th>配置Key</th>
                <th>配置Value</th>
                <th>配置类型</th>
                <th>状态</th>
                <th>TTL</th>
                <th>操作</th>
            </tr>
            <#list data as item>
            <tr>
                <td><input type="checkbox" name="id[]" value="1"/>${item.id?substring(10,16)}</td>
                <td>${item.utime}</td>
                <td>${item.configurationKey}</td>
                <td>${item.configurationValue}</td>
                <td>${item.type}</td>
                <td>${item.status}</td>
                <td>${item.ttl}</td>
                <td>
                    <div class="button-group"><a class="button border-red" href="javascript:void(0)"
                                                 onclick="return del(1)"><span class="icon-trash-o"></span> 删除</a></div>
                </td>
            </tr>
            </#list>
            <!--tr>
              <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
            </tr-->
        </table>
    </div>
</form>
<script type="text/javascript">

    function del(id) {
        if (confirm("您确定要删除吗?")) {

        }
    }

    $("#checkall").click(function () {
        $("input[name='id[]']").each(function () {
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    function DelSelect() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false) return false;
        }
        else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>
</body>
</html>