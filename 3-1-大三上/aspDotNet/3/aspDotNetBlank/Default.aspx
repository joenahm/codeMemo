<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>上机实验3</title>
  <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css">
  <script src="node_modules/jquery/dist/jquery.slim.min.js"></script>
  <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
  <style>
    .jumbotron {
      text-align: center;
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="jumbotron">
          <h1 class="display-4">青岛理工大学人事管理系统</h1>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="card">
          <div class="card-body">
            <form onsubmit="return handleSubmit()" method="post" action="userInfo.aspx">
              <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
              </div>
              <div class="form-group">
                <label for="gender">性别</label>
                <select class="form-control" id="gender" name="gender">
                  <option value="1">男</option>
                  <option value="0">女</option>
                </select>
              </div>
              <div class="form-group">
                <label for="age">年龄</label>
                <input type="number" class="form-control" id="age" name="age" placeholder="请输入年龄" />
              </div>
              <div class="form-group">
                <label for="department">部门</label>
                <select class="form-control" id="department" name="department">
                  <option value="软件工程">软件工程</option>
                  <option value="计算机科学与技术">计算机科学与技术</option>
                  <option value="网络工程">网络工程</option>
                </select>
              </div>
              <div class="form-group">
                <label for="salary">工资</label>
                <input type="text" class="form-control" id="salary" name="salary" placeholder="请输入工资" />
              </div>
              <div class="form-group">
                <label for="nation">民族</label>
                <select class="form-control" id="nation" name="nation">
                  <option value="汉族">汉族</option>
                  <option value="回族">回族</option>
                </select>
              </div>
              <div class="form-group">
                <label for="remarks">备注</label>
                <input type="text" class="form-control" id="remarks" name="remarks" placeholder="请输入备注">
              </div>
              <button type="submit" class="btn btn-primary">添加</button>
              <button type="reset" class="btn">取消</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
<script>
   function getElement(name) {
    return document.getElementsByName(name)[0];
  };

  function getValue(name) {
    return getElement(name).value;
  }; 

  function getValues() {
    return {
      name: getValue('name'),
      gender: getValue('gender'),
      age: getValue('age'),
      department: getValue('department'),
      salary: getValue('salary'),
      nation: getValue('nation'),
      remarks: getValue('remarks'),
    };
  };

  function handleSubmit() {
    const {
      name,
      gender,
      age,
      department,
      salary,
      nation,
      remarks,
    } = getValues();

    let alertInfo = "";
    let status = true;

    if (/\s/.test(name) || name === "") {
      alertInfo += "姓名不能为空！\n";
      status = false;
    }

    if (/\s/.test(age) || age === "") {
      alertInfo += "年龄不能为空！\n";
      status = false;
    }

    if (/\s/.test(salary) || salary === "") {
      alertInfo += "工资不能为空！\n";
      status = false;
    }

    if (!status) {
      alert(alertInfo);
    }

    return status;
  }
</script>
</html>
