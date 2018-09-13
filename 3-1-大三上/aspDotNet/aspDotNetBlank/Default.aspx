<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>上机实验1</title>
  <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css">
  <script src="node_modules/jquery/dist/jquery.slim.min.js"></script>
  <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
  <style>
    .col-md-4, .col-md-8, .col-md-12 {
      padding: 0;
    }

    .jumbotron {
      background-color: rgb(251, 212, 180);
      margin: 0;
    }

    .navbar, .navbar-light, .bg-light {
      background-color: rgb(198, 217, 241) !important;
    }

    .sider {
      height: 100%;
      background-color: rgb(214, 227, 188);
    }

    .copyleft {
      text-align: center;
      background-color: rgb(255, 255, 204);
    }

    @keyframes roll {
      0% {
        -webkit-transform: translate3d(0, 0, 0);
        transform: translate3d(0, 0, 0);
      }

      100% {
        -webkit-transform: translate3d(0, -307px, 0);
        transform: translate3d(0, -307px, 0);
        display: none;
      }
  }

    .infoWrapper {
      height: 300px;
      overflow: hidden;
    }
    .wrapper {
      animation: 10s roll linear infinite normal; 
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="jumbotron">
          <h1 class="display-4">个人信息输入页</h1>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
         <nav class="navbar navbar-light bg-light">
           <a class="navbar-brand" href="#">导航</a>
         </nav>
      </div>
    </div>
    <div class="row">
      <div class="col-md-4">
        <div class="card sider">
          <div class="card-body">
            友情链接：
            <ul>
              <li><a href="https://sjydzq.cn" target="_blank">世间一等珍奇</a></li>
              <li><a href="http://hipicture.top" target="_blank">Picture图片社交</a></li>
              <li><a href="https://sjydzq.cn/qc" target="_blank">周南的个人博客：青池</a></li>
            </ul>
            滚动信息：
            <div class="card">
              <div class="card-body infoWrapper">
                <ul class="wrapper">
                  <li>1</li>
                  <li>2</li>
                  <li>3</li>
                  <li>4</li>
                  <li>5</li>
                  <li>6</li>
                  <li>7</li>
                  <li>8</li>
                  <li>9</li>
                  <li>10</li>
                  <li>11</li>
                  <li>12</li>
                  <li>13</li>
                  <li>14</li>
                  <li>15</li>
                  <li>16</li>
                  <li>17</li>
                  <li>18</li>
                  <li>19</li>
                  <li>20</li>
                  <li>21</li>
                  <li>22</li>
                  <li>23</li>
                  <li>24</li>
                  <li>25</li>
                  <li>26</li>
                  <li>27</li>
                  <li>28</li>
                  <li>29</li>
                  <li>30</li>
                  <li>31</li>
                  <li>32</li>
                  <li>33</li>
                  <li>34</li>
                  <li>35</li>
                  <li>36</li>
                  <li>37</li>
                  <li>38</li>
                  <li>39</li>
                  <li>40</li>
                  <li>41</li>
                  <li>42</li>
                  <li>43</li>
                  <li>44</li>
                  <li>45</li>
                  <li>46</li>
                  <li>47</li>
                  <li>48</li>
                  <li>49</li>
                  <li>50</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-8">
        <div class="card">
          <div class="card-body">
            <form onsubmit="return handleSubmit()" method="post" action="userInfo.aspx">
              <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
              </div>
              <div class="form-group">
                <label for="nickname">昵称</label>
                <input type="text" class="form-control" id="nickname" name="nickname" placeholder="请输入昵称">
              </div>
              <div class="form-group">
                <label for="gender">性别</label>
                <select class="form-control" id="gender" name="gender">
                  <option value="1">男</option>
                  <option value="0">女</option>
                </select>
              </div>
              <div class="form-group">
                <label for="location">地区</label>
                <input type="text" class="form-control" id="location" name="location" placeholder="请输入所在地区">
              </div>
              <div class="form-group">
                <label for="remarks">备注</label>
                <input type="text" class="form-control" id="remarks" name="remarks" placeholder="请输入备注">
              </div>
              <button type="submit" class="btn btn-primary">提交</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="card copyleft">
          <div class="card-body">
            Copyright ©<a href="https://gitee.com/joenahm" target="_blank">Joe Nahm</a><br />
            遵循<a href="https://gitee.com/joenahm/codeMemo/blob/master/LICENSE" target="_blank">GPL-3.0</a>协议
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
<script>
  const getValue = name => {
    return getElement(name).value;
  };

  const getElement = name => {
    return document.getElementsByName(name)[0];
  };

  const getValues = () => {
    return {
      name: getValue('name'),
      nickname: getValue('nickname'),
      gender: getValue('gender'),
      location: getValue('location'),
      remarks: getValue('remarks'),
    };
  };

  function handleSubmit() {
    const {
      name,
      nickname,
      gender,
      location,
      remarks,
    } = getValues();

    let alertInfo = "";
    let status = true;

    if (/\s/.test(name) || name === "") {
      alertInfo += "姓名不能为空！\n";
      status = false;
    }

    if (/\s/.test(nickname) || nickname === "") {
      alertInfo += "昵称不能为空！\n";
      status = false;
    }

    if (/\s/.test(location) || location === "") {
      alertInfo += "地区不能为空！\n";
      status = false;
    }

    if (!status) {
      alert(alertInfo);
    }

    return status;
  }
</script>
</html>
