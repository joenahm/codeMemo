using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace aspDotNetBlank {
    public partial class userInfo : System.Web.UI.Page {
        public string name = "";
        public string nickname = "";
        public string gender = "";
        public string location = "";
        public string remarks = "";

        protected void Page_Load(object sender, EventArgs e) {
            name = Request.Form["name"];
            nickname = Request.Form["nickname"];
            gender = Request.Form["gender"] == "1" ? "男" : "女";
            location = Request.Form["location"];
            remarks = Request.Form["remarks"];
        }
    }
}