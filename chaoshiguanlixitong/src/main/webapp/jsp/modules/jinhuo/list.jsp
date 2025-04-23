<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <!-- font-awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">


    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <!-- layui -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
</head>
<style>

</style>
<body>




    <!-- Pre Loader -->
    <div class="loading">
        <div class="spinner">
            <div class="double-bounce1"></div>
            <div class="double-bounce2"></div>
        </div>
    </div>
<!--/Pre Loader -->
    <div class="wrapper">
        <!-- Page Content -->
        <div id="content">
            <!-- Top Navigation -->
            <%@ include file="../../static/topNav.jsp" %>
            <!-- Menu -->
            <div class="container menu-nav">
                <nav class="navbar navbar-expand-lg lochana-bg text-white">
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="ti-menu text-white"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul id="navUl" class="navbar-nav mr-auto">
                        </ul>
                    </div>
                </nav>
            </div>
            <!-- /Menu -->
            <!-- Breadcrumb -->
            <!-- Page Title -->
            <div class="container mt-0">
                <div class="row breadcrumb-bar">
                    <div class="col-md-6">
                        <h3 class="block-title">进货管理</h3>
                    </div>
                    <div class="col-md-6">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                                <a href="${pageContext.request.contextPath}/index.jsp">
                                    <span class="ti-home"></span>
                                </a>
                            </li>
                            <li class="breadcrumb-item">进货管理</li>
                            <li class="breadcrumb-item active">进货列表</li>
                        </ol>
                    </div>
                </div>
            </div>
            <!-- /Page Title -->

            <!-- /Breadcrumb -->
            <!-- Main Content -->
            <div class="container">
                <div class="row">
                    <!-- Widget Item -->
                    <div class="col-md-12">
                        <div class="widget-area-2 lochana-box-shadow">
                            <h3 class="widget-title">进货列表</h3>
                            <div class="table-responsive mb-3">
                                <div class="col-sm-12">
                                                                                                                                                                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        进货单号
                                        <div class="layui-input-inline">
                                            <input type="text" id="jinhuoUuidNumberSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="进货单号" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                                                                                                    
                                                                                                         
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        供应商名称
                                        <div class="layui-input-inline">
                                            <input type="text" id="gongyingshangNameSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="供应商名称" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                         
                                                                                                                                                                                                                 
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        商品编号
                                        <div class="layui-input-inline">
                                            <input type="text" id="shangpinUuidNumberSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="商品编号" aria-controls="tableId">
                                        </div>
                                    </div>
                                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        商品名称
                                        <div class="layui-input-inline">
                                            <input type="text" id="shangpinNameSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="商品名称" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                                                                             
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        商品类型
                                        <div class="layui-input-inline">
                                            <select name="shangpinTypesSelectSearch"  style="width: 150px;" id="shangpinTypesSelectSearch" class="form-control form-control-sm"
                                                    aria-controls="tableId">
                                            </select>
                                        </div>
                                    </div>
                                                                                                                                                                                                                                                                                                                                                                             
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        员工工号
                                        <div class="layui-input-inline">
                                            <input type="text" id="yuangongUuidNumberSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="员工工号" aria-controls="tableId">
                                        </div>
                                    </div>
                                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        员工姓名
                                        <div class="layui-input-inline">
                                            <input type="text" id="yuangongNameSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="员工姓名" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                                                                                                                                                                                    
                                    <div class="layui-inline" style="margin-left: 30px;margin-bottom: 10px;">
                                        <button onclick="search()" type="button" class="btn btn-primary">查询</button>
                                        <button onclick="add()" type="button" class="btn btn-primary 新增">添加</button>
                                        <button onclick="graph()" type="button" class="btn btn-primary 报表">报表</button>
                                        <button onclick="deleteMore()" type="button" class="btn btn-danger 删除">批量删除</button>
                                    </div>
                                </div>
                                <table id="tableId" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th class="no-sort" style="min-width: 35px;">
                                            <div class="custom-control custom-checkbox">
                                                <input class="custom-control-input" type="checkbox" id="select-all"
                                                       onclick="chooseAll()">
                                                <label class="custom-control-label" for="select-all"></label>
                                            </div>
                                        </th>

                                        <th >供应商名称</th>
                                        <th >供应商类型</th>
                                        <th >商品编号</th>
                                        <th >商品名称</th>
                                        <th >商品照片</th>
                                        <th >商品类型</th>
                                        <th >商品售价</th>
                                        <th >员工工号</th>
                                        <th >员工姓名</th>
                                        <th >员工手机号</th>
                                        <th >员工头像</th>
                                        <th>进货单号</th>
                                        <th>进货数量</th>
                                        <th>进货时间</th>
                                        <th>录入时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="thisTbody">
                                    </tbody>
                                </table>
                                <div class="col-md-6 col-sm-3">
                                    <div class="dataTables_length" id="tableId_length">

                                        <select name="tableId_length" aria-controls="tableId" id="selectPageSize"
                                                onchange="changePageSize()">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select>
                                        条 每页

                                    </div>
                                </div>
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination justify-content-end">
                                        <li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
                                            <a class="page-link" href="#" tabindex="-1">上一页</a>
                                        </li>

                                        <li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
                                            <a class="page-link" href="#">下一页</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <!-- /Widget Item -->
                </div>
            </div>
            <!-- /Main Content -->

        </div>
        <!-- /Page Content -->
    </div>
    <!-- Back to Top -->
    <a id="back-to-top" href="#" class="back-to-top">
        <span class="ti-angle-up"></span>
    </a>
    <!-- /Back to Top -->
    <%@ include file="../../static/foot.jsp" %>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
    <script>

        <%@ include file="../../utils/menu.jsp"%>
        <%@ include file="../../static/setMenu.js"%>
        <%@ include file="../../utils/baseUrl.jsp"%>
        <%@ include file="../../static/getRoleButtons.js"%>
        <%@ include file="../../static/crossBtnControl.js"%>
        var tableName = "jinhuo";
        var pageType = "list";
        var searchForm = {key: ""};
        var pageIndex = 1;
        var pageSize = 10;
        var totalPage = 0;
        var dataList = [];
        var sortColumn = '';
        var sortOrder = '';
        var ids = [];
        var checkAll = false;

        <!-- 级联表的级联字典表 -->
        var gongyingshangXinyongdengjiTypesOptions = [];
        var shangpinTypesOptions = [];

        <!-- 本表的级联字段表 -->

        function init() {
            // 满足条件渲染提醒接口
        }

        // 改变每页记录条数
        function changePageSize() {
            var selection = document.getElementById('selectPageSize');
            var index = selection.selectedIndex;
            pageSize = selection.options[index].value;
            getDataList();
        }



        // 查询
        function search() {
            searchForm = {key: ""};

        <!-- 级联表的级联字典表 -->
                                         
                            //供应商名称
            var gongyingshangNameSearchInput = $('#gongyingshangNameSearch');
            if( gongyingshangNameSearchInput != null){
                if (gongyingshangNameSearchInput.val() != null && gongyingshangNameSearchInput.val() != '') {
                    searchForm.gongyingshangName = $('#gongyingshangNameSearch').val();
                }
            }
                                         
            var gongyingshangXinyongdengjiTypesSelectSearchInput = document.getElementById("gongyingshangXinyongdengjiTypesSelectSearch");
            if(gongyingshangXinyongdengjiTypesSelectSearchInput != null){
                var gongyingshangXinyongdengjiTypesIndex = gongyingshangXinyongdengjiTypesSelectSearchInput.selectedIndex;
                if( gongyingshangXinyongdengjiTypesIndex  != 0){
                    searchForm.gongyingshangXinyongdengjiTypes = document.getElementById("gongyingshangXinyongdengjiTypesSelectSearch").options[gongyingshangXinyongdengjiTypesIndex].value;
                }
            }
                                                                                 
                            //商品编号
            var shangpinUuidNumberSearchInput = $('#shangpinUuidNumberSearch');
            if( shangpinUuidNumberSearchInput != null){
                if (shangpinUuidNumberSearchInput.val() != null && shangpinUuidNumberSearchInput.val() != '') {
                    searchForm.shangpinUuidNumber = $('#shangpinUuidNumberSearch').val();
                }
            }
                     
                            //商品名称
            var shangpinNameSearchInput = $('#shangpinNameSearch');
            if( shangpinNameSearchInput != null){
                if (shangpinNameSearchInput.val() != null && shangpinNameSearchInput.val() != '') {
                    searchForm.shangpinName = $('#shangpinNameSearch').val();
                }
            }
                                                             
            var shangpinTypesSelectSearchInput = document.getElementById("shangpinTypesSelectSearch");
            if(shangpinTypesSelectSearchInput != null){
                var shangpinTypesIndex = shangpinTypesSelectSearchInput.selectedIndex;
                if( shangpinTypesIndex  != 0){
                    searchForm.shangpinTypes = document.getElementById("shangpinTypesSelectSearch").options[shangpinTypesIndex].value;
                }
            }
                                                                                                                                             
                            //员工工号
            var yuangongUuidNumberSearchInput = $('#yuangongUuidNumberSearch');
            if( yuangongUuidNumberSearchInput != null){
                if (yuangongUuidNumberSearchInput.val() != null && yuangongUuidNumberSearchInput.val() != '') {
                    searchForm.yuangongUuidNumber = $('#yuangongUuidNumberSearch').val();
                }
            }
                     
                            //员工姓名
            var yuangongNameSearchInput = $('#yuangongNameSearch');
            if( yuangongNameSearchInput != null){
                if (yuangongNameSearchInput.val() != null && yuangongNameSearchInput.val() != '') {
                    searchForm.yuangongName = $('#yuangongNameSearch').val();
                }
            }
                                                                                                        <!-- 本表的查询条件 -->

                     
            //进货单号
            var jinhuoUuidNumberSearchInput = $('#jinhuoUuidNumberSearch');
            if( jinhuoUuidNumberSearchInput != null){
                if (jinhuoUuidNumberSearchInput.val() != null && jinhuoUuidNumberSearchInput.val() != '') {
                    searchForm.jinhuoUuidNumber = $('#jinhuoUuidNumberSearch').val();
                }
            }
                                getDataList();
        }

        // 获取数据列表
        function getDataList() {
            http("jinhuo/page", "GET", {
                page: pageIndex,
                limit: pageSize,
                sort: sortColumn,
                order: sortOrder,
                jinhuoDelete: 1,
                //本表的
                jinhuoUuidNumber: searchForm.jinhuoUuidNumber,
            //级联表的
                gongyingshangName: searchForm.gongyingshangName,
                gongyingshangXinyongdengjiTypes: searchForm.gongyingshangXinyongdengjiTypes,

                shangpinUuidNumber: searchForm.shangpinUuidNumber,
                shangpinName: searchForm.shangpinName,
                shangpinTypes: searchForm.shangpinTypes,

                yuangongUuidNumber: searchForm.yuangongUuidNumber,
                yuangongName: searchForm.yuangongName,


            }, (res) => {
                if(res.code == 0) {
                    clear();
                    $("#thisTbody").html("");
                    dataList = res.data.list;
                    totalPage = res.data.totalPage;
                    for (var i = 0; i < dataList.length; i++) { //遍历一下表格数据  
                        var trow = setDataRow(dataList[i], i); //定义一个方法,返回tr数据 
                        $('#thisTbody').append(trow);
                    }
                    pagination(); //渲染翻页组件
                    getRoleButtons();// 权限按钮控制
                }
            });
        }

        // 渲染表格数据
        function setDataRow(item, number) {
            //创建行 
            var row = document.createElement('tr');
            row.setAttribute('class', 'useOnce');
            //创建勾选框
            var checkbox = document.createElement('td');
            var checkboxDiv = document.createElement('div');
            checkboxDiv.setAttribute("class", "custom-control custom-checkbox");
            var checkboxInput = document.createElement('input');
            checkboxInput.setAttribute("class", "custom-control-input");
            checkboxInput.setAttribute("type", "checkbox");
            checkboxInput.setAttribute('name', 'chk');
            checkboxInput.setAttribute('value', item.id);
            checkboxInput.setAttribute("id", number);
            checkboxDiv.appendChild(checkboxInput);
            var checkboxLabel = document.createElement('label');
            checkboxLabel.setAttribute("class", "custom-control-label");
            checkboxLabel.setAttribute("for", number);
            checkboxDiv.appendChild(checkboxLabel);
            checkbox.appendChild(checkboxDiv);
            row.appendChild(checkbox)


                    //供应商名称
            var gongyingshangNameCell = document.createElement('td');
            gongyingshangNameCell.innerHTML = item.gongyingshangName;
            row.appendChild(gongyingshangNameCell);

                        //供应商类型
            var gongyingshangTypesCell = document.createElement('td');
            gongyingshangTypesCell.innerHTML = item.gongyingshangValue;
            row.appendChild(gongyingshangTypesCell);


                    //商品编号
            var shangpinUuidNumberCell = document.createElement('td');
            shangpinUuidNumberCell.innerHTML = item.shangpinUuidNumber;
            row.appendChild(shangpinUuidNumberCell);


                    //商品名称
            var shangpinNameCell = document.createElement('td');
            shangpinNameCell.innerHTML = item.shangpinName;
            row.appendChild(shangpinNameCell);


                //商品照片
            var shangpinPhotoCell = document.createElement('td');
            var shangpinPhotoImg = document.createElement('img');
            var shangpinPhotoImgValue = item.shangpinPhoto;
            if(shangpinPhotoImgValue !=null && shangpinPhotoImgValue !='' && shangpinPhotoImgValue !='null'){
                    shangpinPhotoImg.setAttribute('src', shangpinPhotoImgValue);
                    shangpinPhotoImg.setAttribute('height', 100);
                    shangpinPhotoImg.setAttribute('width', 100);
                    shangpinPhotoCell.appendChild(shangpinPhotoImg);
            }else{
                    shangpinPhotoCell.innerHTML = "暂无图片";
            }
            row.appendChild(shangpinPhotoCell);

                        //商品类型
            var shangpinTypesCell = document.createElement('td');
            shangpinTypesCell.innerHTML = item.shangpinValue;
            row.appendChild(shangpinTypesCell);


                    //商品售价
            var shangpinNewMoneyCell = document.createElement('td');
            shangpinNewMoneyCell.innerHTML = item.shangpinNewMoney;
            row.appendChild(shangpinNewMoneyCell);


                    //员工工号
            var yuangongUuidNumberCell = document.createElement('td');
            yuangongUuidNumberCell.innerHTML = item.yuangongUuidNumber;
            row.appendChild(yuangongUuidNumberCell);


                    //员工姓名
            var yuangongNameCell = document.createElement('td');
            yuangongNameCell.innerHTML = item.yuangongName;
            row.appendChild(yuangongNameCell);


                    //员工手机号
            var yuangongPhoneCell = document.createElement('td');
            yuangongPhoneCell.innerHTML = item.yuangongPhone;
            row.appendChild(yuangongPhoneCell);


                //员工头像
            var yuangongPhotoCell = document.createElement('td');
            var yuangongPhotoImg = document.createElement('img');
            var yuangongPhotoImgValue = item.yuangongPhoto;
            if(yuangongPhotoImgValue !=null && yuangongPhotoImgValue !='' && yuangongPhotoImgValue !='null'){
                    yuangongPhotoImg.setAttribute('src', yuangongPhotoImgValue);
                    yuangongPhotoImg.setAttribute('height', 100);
                    yuangongPhotoImg.setAttribute('width', 100);
                    yuangongPhotoCell.appendChild(yuangongPhotoImg);
            }else{
                    yuangongPhotoCell.innerHTML = "暂无图片";
            }
            row.appendChild(yuangongPhotoCell);


            //进货单号
            var jinhuoUuidNumberCell = document.createElement('td');
            jinhuoUuidNumberCell.innerHTML = item.jinhuoUuidNumber;
            row.appendChild(jinhuoUuidNumberCell);


            //进货数量
            var jinhuoNumberCell = document.createElement('td');
            jinhuoNumberCell.innerHTML = item.jinhuoNumber;
            row.appendChild(jinhuoNumberCell);


            //进货时间
            var jinhuoTimeCell = document.createElement('td');
            jinhuoTimeCell.innerHTML = item.jinhuoTime;
            row.appendChild(jinhuoTimeCell);


            //录入时间
            var insertTimeCell = document.createElement('td');
            insertTimeCell.innerHTML = item.insertTime;
            row.appendChild(insertTimeCell);



            //每行按钮
            var btnGroup = document.createElement('td');

            //详情按钮
            var detailBtn = document.createElement('button');
            var detailAttr = "detail(" + item.id + ')';
            detailBtn.setAttribute("type", "button");
            detailBtn.setAttribute("class", "btn btn-info btn-sm 查看");
            detailBtn.setAttribute("onclick", detailAttr);
            detailBtn.innerHTML = "查看";
            btnGroup.appendChild(detailBtn);


            //修改按钮
            var editBtn = document.createElement('button');
            var editAttr = 'edit(' + item.id + ')';
            editBtn.setAttribute("type", "button");
            editBtn.setAttribute("class", "btn btn-warning btn-sm 修改");
            editBtn.setAttribute("onclick", editAttr);
            editBtn.innerHTML = "修改";
            btnGroup.appendChild(editBtn);



            //删除按钮
            var deleteBtn = document.createElement('button');
            var deleteAttr = 'remove(' + item.id + ')';
            deleteBtn.setAttribute("type", "button");
            deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
            deleteBtn.setAttribute("onclick", deleteAttr);
            deleteBtn.innerHTML = "删除";
            btnGroup.appendChild(deleteBtn);

            row.appendChild(btnGroup);

            return row;
    }


        // 翻页
        function pageNumChange(val) {
            if (val == 'pre') {
                pageIndex--;
            } else if (val == 'next') {
                pageIndex++;
            } else {
                pageIndex = val;
            }
            getDataList();
        }

        // 下载
        function download(url) {
            window.open(url);
        }
        // 打开新窗口播放媒体
        function mediaPlay(url){
            window.open(url);
        }

        // 渲染翻页组件
        function pagination() {
            var beginIndex = pageIndex;
            var endIndex = pageIndex;
            var point = 4;
            //计算页码
            for (var i = 0; i < 3; i++) {
                if (endIndex == totalPage) {
                    break;
                }
                endIndex++;
                point--;
            }
            for (var i = 0; i < 3; i++) {
                if (beginIndex == 1) {
                    break;
                }
                beginIndex--;
                point--;
            }
            if (point > 0) {
                while (point > 0) {
                    if (endIndex == totalPage) {
                        break;
                    }
                    endIndex++;
                    point--;
                }
                while (point > 0) {
                    if (beginIndex == 1) {
                        break;
                    }
                    beginIndex--;
                    point--
                }
            }
            // 是否显示 前一页 按钮
            if (pageIndex > 1) {
                $('#tableId_previous').show();
            } else {
                $('#tableId_previous').hide();
            }
            // 渲染页码按钮
            for (var i = beginIndex; i <= endIndex; i++) {
                var pageNum = document.createElement('li');
                pageNum.setAttribute('onclick', "pageNumChange(" + i + ")");
                if (pageIndex == i) {
                    pageNum.setAttribute('class', 'paginate_button page-item active useOnce');
                } else {
                    pageNum.setAttribute('class', 'paginate_button page-item useOnce');
                }
                var pageHref = document.createElement('a');
                pageHref.setAttribute('class', 'page-link');
                pageHref.setAttribute('href', '#');
                pageHref.setAttribute('aria-controls', 'tableId');
                pageHref.setAttribute('data-dt-idx', i);
                pageHref.setAttribute('tabindex', 0);
                pageHref.innerHTML = i;
                pageNum.appendChild(pageHref);
                $('#tableId_next').before(pageNum);
            }
            // 是否显示 下一页 按钮
            if (pageIndex < totalPage) {
                $('#tableId_next').show();
                $('#tableId_next a').attr('data-dt-idx', endIndex + 1);
            } else {
                $('#tableId_next').hide();
            }
            var pageNumInfo = "当前第 " + pageIndex + " 页，共 " + totalPage + " 页";
            $('#tableId_info').html(pageNumInfo);
        }

        // 跳转到指定页
        function toThatPage() {
            //var index = document.getElementById('pageIndexInput').value;
            if (index < 0 || index > totalPage) {
                alert('请输入正确的页码');
            } else {
                pageNumChange(index);
            }
        }

        // 全选/全不选
        function chooseAll() {
            checkAll = !checkAll;
            var boxs = document.getElementsByName("chk");
            for (var i = 0; i < boxs.length; i++) {
                boxs[i].checked = checkAll;
            }
        }

        // 批量删除
        function deleteMore() {
            ids = []
            var boxs = document.getElementsByName("chk");
            for (var i = 0; i < boxs.length; i++) {
                if (boxs[i].checked) {
                    ids.push(boxs[i].value)
                }
            }
            if (ids.length == 0) {
                alert('请勾选要删除的记录');
            } else {
                remove(ids);
            }
        }

        // 删除
        function remove(id) {
            var mymessage = confirm("真的要删除吗？");
            if (mymessage == true) {
                var paramArray = [];
                if (id == ids) {
                    paramArray = id;
                } else {
                    paramArray.push(id);
                }
                httpJson("jinhuo/delete", "POST", paramArray, (res) => {
                    if(res.code == 0){
                        getDataList();
                        alert('删除成功');
                    }
                });
            } else {
                alert("已取消操作");
            }
        }

        // 用户登出
        <%@ include file="../../static/logout.jsp"%>

        //修改
        function edit(id) {
            window.sessionStorage.setItem('updateId', id)
            window.location.href = "add-or-update.jsp"
        }

        //清除会重复渲染的节点
        function clear() {
            var elements = document.getElementsByClassName('useOnce');
            for (var i = elements.length - 1; i >= 0; i--) {
                elements[i].parentNode.removeChild(elements[i]);
            }
        }

        //添加
        function add() {
            window.sessionStorage.setItem("addjinhuo", "addjinhuo");
            window.location.href = "add-or-update.jsp"
        }

        //报表
        function graph() {
            window.location.href = "graph.jsp"
        }

        // 查看详情
        function detail(id) {
            window.sessionStorage.setItem("updateId", id);
            window.location.href = "info.jsp";
        }


    //填充级联表搜索下拉框
                                         
                                         
        function gongyingshangXinyongdengjiTypesSelectSearch() {
            var gongyingshangXinyongdengjiTypesSelectSearch = document.getElementById('gongyingshangXinyongdengjiTypesSelectSearch');
            if(gongyingshangXinyongdengjiTypesSelectSearch != null) {
                gongyingshangXinyongdengjiTypesSelectSearch.add(new Option('-请选择-',''));
                if (gongyingshangXinyongdengjiTypesOptions != null && gongyingshangXinyongdengjiTypesOptions.length > 0){
                    for (var i = 0; i < gongyingshangXinyongdengjiTypesOptions.length; i++) {
                            gongyingshangXinyongdengjiTypesSelectSearch.add(new Option(gongyingshangXinyongdengjiTypesOptions[i].indexName, gongyingshangXinyongdengjiTypesOptions[i].codeIndex));
                    }
                }
            }
        }
                                                                                 
                     
                                                             
        function shangpinTypesSelectSearch() {
            var shangpinTypesSelectSearch = document.getElementById('shangpinTypesSelectSearch');
            if(shangpinTypesSelectSearch != null) {
                shangpinTypesSelectSearch.add(new Option('-请选择-',''));
                if (shangpinTypesOptions != null && shangpinTypesOptions.length > 0){
                    for (var i = 0; i < shangpinTypesOptions.length; i++) {
                            shangpinTypesSelectSearch.add(new Option(shangpinTypesOptions[i].indexName, shangpinTypesOptions[i].codeIndex));
                    }
                }
            }
        }
                                                                                                                                             
                     
                                                                                                    
    //填充本表搜索下拉框
                     
                    
    //查询级联表搜索条件所有列表
            function gongyingshangXinyongdengjiTypesSelect() {
                //填充下拉框选项
                http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=gongyingshang_xinyongdengji_types", "GET", {}, (res) => {
                    if(res.code == 0){
                        gongyingshangXinyongdengjiTypesOptions = res.data.list;
                    }
                });
            }
            function shangpinTypesSelect() {
                //填充下拉框选项
                http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=shangpin_types", "GET", {}, (res) => {
                    if(res.code == 0){
                        shangpinTypesOptions = res.data.list;
                    }
                });
            }

    //查询当前表搜索条件所有列表












        layui.use(['layer', 'carousel', 'jquery', 'form', 'upload', 'laydate', 'rate'], function () {
            var rate = layui.rate;//评分
            var jquery = layui.jquery;//jquery
            var $=jquery;

        });


        $(document).ready(function () {
            //激活翻页按钮
            $('#tableId_previous').attr('class', 'paginate_button page-item previous')
            $('#tableId_next').attr('class', 'paginate_button page-item next')
            //隐藏原生搜索框
            $('#tableId_filter').hide()
            //设置右上角用户名
            $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
            //设置项目名
            $('.sidebar-header h3 a').html(projectName)
            setMenu();
            init();

            //查询级联表的搜索下拉框
            gongyingshangXinyongdengjiTypesSelect();
            shangpinTypesSelect();

            //查询当前表的搜索下拉框
            getDataList();

        //级联表的下拉框赋值
                                                 
                                                 
            gongyingshangXinyongdengjiTypesSelectSearch();
                                                                                                 
                         
                                                                         
            shangpinTypesSelectSearch();
                                                                                                                                                                         
                         
                                                                                                                        
        //当前表的下拉框赋值
                                                             
                                                            
        <%@ include file="../../static/myInfo.js"%>
    });
</script>
</body>

</html>
